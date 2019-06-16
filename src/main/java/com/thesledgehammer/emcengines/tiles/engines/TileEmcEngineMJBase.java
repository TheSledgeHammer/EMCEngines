package com.thesledgehammer.emcengines.tiles.engines;

import buildcraft.api.mj.IMjReceiver;
import buildcraft.api.mj.MjAPI;
import moze_intel.projecte.api.tile.IEmcProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEmcEngineMJBase extends TileEmcMJ implements ITickable {

    public TileEmcEngineMJBase(String tileName, long mjCapacity, long mjTransfer, long currentEMC, long maximumEMC) {
        super(tileName, mjCapacity, mjTransfer, currentEMC, maximumEMC);
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
                    receivePower(mj.getMaxReceive(), false);
                    emcManager.modifyEmcStored(acceptEMC(facing, stored));
                }
            } else if(other.hasCapability(MjAPI.CAP_RECEIVER, facing)) {
                IMjReceiver energyTile = other.getCapability(MjAPI.CAP_RECEIVER, facing);
                long toExtract = Math.min(mj.getMaxExtract(), getCapacity() - getStored());
                if(energyTile != null) {
                    energyTile.receivePower(toExtract, false);
                }

                if(mj.getStored() < mj.getCapacity()) {
                    receivePower(Math.min(toExtract, mj.getMaxReceive()), false);
                }
                extractPower(0, toExtract, false);
                mj.modifyPowerStored(extractPower(0, toExtract, false));
            }
        }
    }
}
//To Fix, is Weird when next to collectors, on both Mj & Rf Base