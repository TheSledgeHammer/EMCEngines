package com.thesledgehammer.emcengines.tiles.engines;

import moze_intel.projecte.api.tile.IEmcProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TileEmcEngineRFBase extends TileEmcRF implements ITickable {

    public TileEmcEngineRFBase(String tileName, int feCapacity, int feTransfer, long emcMax, long emcCurrent) {
       super(tileName, feCapacity, feTransfer, emcMax, emcCurrent);
    }

    @Override
    public void update() {

        if(world.isRemote) {
            return;
        }

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
                    acceptEMC(facing, stored);
                    receiveEnergy(fe.getMaxReceive(), false);
                    emcManager.modifyEmcStored(acceptEMC(facing, stored));
                }
            } else if(other.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                IEnergyStorage energyTile = other.getCapability(CapabilityEnergy.ENERGY, facing);
                int toExtract = Math.min(fe.getMaxExtract(), getMaxEnergyStored() - getEnergyStored());

                if (energyTile != null) {
                    energyTile.receiveEnergy(toExtract, false);
                }
                if(fe.getEnergyStored() < fe.getCapacity()) {
                    receiveEnergy(Math.min(toExtract, fe.getMaxReceive()), false);
                }
                extractEnergy(toExtract, false);
                fe.modifyEnergyStored(extractEnergy(toExtract, false));
            }
        }
    }
}
