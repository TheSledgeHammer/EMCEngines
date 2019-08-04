package com.thesledgehammer.emcengines.tiles.engines;

import moze_intel.projecte.api.tile.IEmcProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TileEmcEngineRFBase extends TileEmcRF implements ITickable {

    public TileEmcEngineRFBase(String tileName, int feCapacity, int feTransfer, long maximumEMC, long emcCurrent) {
       super(tileName, feCapacity, feTransfer, maximumEMC, emcCurrent);
    }

    @Override
    public void update() {
        if(world.isRemote) {
            return;
        }

        int toExtract = Math.min(fe.getMaxExtract(), getMaxEnergyStored() - getEnergyStored());

        for(EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            TileEntity other = world.getTileEntity(pos.offset(facing));
            if(tile == null || other == null) {
                continue;
            } else if(tile instanceof IEmcProvider) {
                IEmcProvider emcTile = (IEmcProvider) tile;
                if(emcTile.getStoredEmc() > 0) {
                    emcTile.provideEMC(facing, Math.min(getMaximumEmc(), getStoredEmc()));
                    long stored =+ emcTile.provideEMC(facing, Math.min(getMaximumEmc(), getStoredEmc()));
                    emcManager.drainEMC(acceptEMC(facing, stored));
                    fe.generateEnergy(toExtract);
                }
            } else if(other.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                IEnergyStorage energyTile = other.getCapability(CapabilityEnergy.ENERGY, facing);
                if (energyTile != null && getEnergyStored() > 0) {
                    fe.drainEnergy(energyTile.receiveEnergy(toExtract, false));
                }
            }
        }
    }
}
