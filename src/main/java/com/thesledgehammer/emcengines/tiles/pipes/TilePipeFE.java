package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.groovymc.api.EnergyConfig;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import com.thesledgehammer.groovymc.compat.forgeenergy.ForgeEnergyTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TilePipeFE extends ForgeEnergyTile implements ITickable {

    public TilePipeFE(EnumVoltage pipeType) {
        super((int) EnergyConfig.createRFConfig((int) pipeType.getVoltage() * 32).getCapacity(), (int) EnergyConfig.createRFConfig((int) pipeType.getVoltage() * 32).getMaxExtract());
    }

    @Override
    public void update() {
        if (getWorld().isRemote) {
            return;
        }

        for (EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = getWorld().getTileEntity(getPos().offset(facing));
            if (tile == null) {
                continue;
            } else if (tile != null) {
                //Basic Pipe Energy Transfer: Tweaks in future
                if (tile.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                    IEnergyStorage extractFe = tile.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
                    if (extractFe != null && extractFe.getEnergyStored() > 0) {
                        int toReceive = extractFe.extractEnergy(fe.getMaxReceive(), true);
                        if (canReceive() && toReceive > 0) {
                            fe.generateEnergy(receiveEnergy(toReceive, false));
                        }
                    }

                    IEnergyStorage insertFe = tile.getCapability(CapabilityEnergy.ENERGY, facing);
                    if (insertFe != null && getEnergyStored() > 0) {
                        int toExtract = extractEnergy(fe.getMaxExtract(), true);
                        if (canExtract() && toExtract > 0) {
                            fe.drainEnergy(insertFe.receiveEnergy(toExtract, false));
                        }
                    }
                }
            }
        }
    }
}
