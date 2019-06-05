package com.thesledgehammer.emcengines.tiles.engines;

import moze_intel.projecte.api.tile.IEmcProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TileEmcEngineBase extends TileEmcRF implements ITickable {

    public TileEmcEngineBase(String tileName, int feCapacity, int feTransfer, long emcMax, long emcCurrent) {
       super(tileName, feCapacity, feTransfer, emcMax, emcCurrent);
    }

    @Override
    public void update() {

        if(world.isRemote) {
            return;
        }

        long stored = 0;
        int move = 0;

        for(EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            TileEntity other = world.getTileEntity(pos.offset(facing));
            if(tile == null) {
                continue;
            } else if(tile instanceof IEmcProvider) {
                IEmcProvider emcTile = (IEmcProvider) tile;
                if(emcTile.getStoredEmc() > 0) {
                    emcTile.provideEMC(facing, Math.min(getMaximumEmc(), getStoredEmc()));
                    stored += emcTile.provideEMC(facing, Math.min(getMaximumEmc(), getStoredEmc()));
                    acceptEMC(facing, stored);
                    receiveEnergy(fe.getMaxReceive(), false);
                    emcManager.modifyEmcStored(acceptEMC(facing, stored));
                }
            }

            if (other != null && other.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                IEnergyStorage energyTile = other.getCapability(CapabilityEnergy.ENERGY, facing);
                int toExtract = Math.min(fe.getMaxExtract(), getMaxEnergyStored() - getEnergyStored());

                if (energyTile != null) {
                    move = energyTile.receiveEnergy(toExtract, false);
                }
                if(fe.getEnergyStored() < fe.getCapacity()) {
                    receiveEnergy(Math.min(move, fe.getMaxReceive()), false);
                }
                extractEnergy(move, false);
                fe.modifyEnergyStored(extractEnergy(move, false));
            }
        }
    }
}
