package com.thesledgehammer.emcengines.controller;

import com.thesledgehammer.groovymc.api.EnergyConfig;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import com.thesledgehammer.groovymc.compat.forgeenergy.ForgeEnergy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class EnergyFlow implements IEnergyStorage {

    private ForgeEnergy fe;
    public EnergyFlow() {
        EnergyConfig FE = EnergyConfig.createRFConfig((int) EnumVoltage.INFINITE.getVoltage());
        this.fe = new ForgeEnergy((int) FE.getCapacity(), (int) FE.getMaxReceive(), (int) FE.getMaxExtract());
    }

    public void transferFEOnTick(TileEntity tile, EnumFacing facing) {
        if (tile.hasCapability(CapabilityEnergy.ENERGY, facing)) {
            IEnergyStorage extractFe = tile.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
            if (extractFe != null && extractFe.getEnergyStored() > 0) {
                int toReceive = extractFe.extractEnergy(fe.getMaxReceive(), true);
                if (toReceive > 0) {
                    fe.generateEnergy(receiveEnergy(toReceive, false));
                }
            }

            IEnergyStorage insertFe = tile.getCapability(CapabilityEnergy.ENERGY, facing);
            if (insertFe != null && getEnergyStored() > 0) {
                int toExtract = extractEnergy(fe.getMaxExtract(), true);
                if (toExtract > 0) {
                    fe.drainEnergy(insertFe.receiveEnergy(toExtract, false));
                }
            }
        }
    }

    //IEnergyStorage
    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return fe.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return fe.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        return fe.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored() {
        return fe.getMaxEnergyStored();
    }

    @Override
    public boolean canExtract() {
        return fe.canExtract();
    }

    @Override
    public boolean canReceive() {
        return fe.canReceive();
    }
}
