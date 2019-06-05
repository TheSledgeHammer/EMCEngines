package com.thesledgehammer.emcengines.tiles.engines;

import moze_intel.projecte.api.tile.IEmcAcceptor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEmcGeneratorBase extends TileEmcRF implements ITickable {

    public TileEmcGeneratorBase(String tileName, int capacity, int maxTransfer, long currentEMC, long maximumEMC) {
        super(tileName, capacity, maxTransfer, currentEMC, maximumEMC);
    }

    @Override
    public void update() {

        if(world.isRemote) {
            return;
        }

        long store = 0;

        for(EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            TileEntity other = world.getTileEntity(pos.offset(facing));
            if (tile == null) {
                continue;
            } else if (tile instanceof IEmcAcceptor) {
                IEmcAcceptor emcTile = (IEmcAcceptor) tile;
                if(emcTile.getStoredEmc() < emcTile.getMaximumEmc()) {
                    emcTile.acceptEMC(facing, Math.min(getMaximumEmc(), emcManager.getMaxReceive()));
                    store += emcTile.acceptEMC(facing, Math.min(getMaximumEmc(), emcManager.getMaxReceive()));
                    provideEMC(facing, store);
                    extractEnergy(fe.getMaxExtract(), false);
                    emcManager.modifyEmcStored(provideEMC(facing, store));
                }
            }
        }
    }
}
