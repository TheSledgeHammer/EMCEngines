package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class RFConverterTile extends MjRfTile implements ITickable {

    public RFConverterTile(String tileName, long capacity, EnumVoltage voltage) {
        super(tileName, capacity, voltage);
    }

    public RFConverterTile(String tileName, long capacity, long maxTransfer, EnumVoltage voltage) {
        super(tileName, capacity, maxTransfer, voltage);
    }

    @Override
    public void update() {

        if (world.isRemote) {
            return;
        }

        for (EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            if (tile == null) {
                continue;
            } else if (tile != null) {
                //Simple Mj to RF Conversion. Needs some tweaks and improvements (syncing of internal MJ & RF buffers)
                if(tile.hasCapability(CapabilityEnergy.ENERGY, facing) || tile.hasCapability(CapabilityMj.getMJ_STORAGE(), facing)) {

                    IMjStorage extractMj = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing.getOpposite());
                    if(extractMj != null && extractMj.getStored() > 0) {
                        long toReceive = extractMj.extractPower(0, mj.getMaxReceive(), true);
                        mj.generatePower(receivePower(toReceive, false), voltage);
                        fe.generateEnergy(receiveEnergy(Constants.MJ_TO_RF(toReceive), false), voltage);
                    }

                    IEnergyStorage insertFe = tile.getCapability(CapabilityEnergy.ENERGY, facing);
                    if(insertFe != null && getEnergyStored() > 0) {
                        long toExtract = extractPower(0, mj.getMaxExtract(), true);
                        mj.drainPower(insertFe.receiveEnergy(Constants.MJ_TO_RF(toExtract), false), voltage);
                        fe.drainEnergy(insertFe.receiveEnergy(Constants.MJ_TO_RF(toExtract), false), voltage);
                    }
                }
            }
        }
    }
}