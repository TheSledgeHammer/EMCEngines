package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.emcengines.EmcManager;
import com.thesledgehammer.groovymc.energy.ForgeEnergyTile;
import moze_intel.projecte.api.tile.IEmcProvider;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

import javax.annotation.Nonnull;

public class TileEmcProviderRF extends ForgeEnergyTile implements IEmcProvider {

    protected EmcManager emcManager;

    public TileEmcProviderRF(String tileName, int capacity, int maxTransfer, long currentEMC, long maximumEMC) {
        super(tileName, capacity, maxTransfer);
        emcManager = new EmcManager(maximumEMC, currentEMC);
    }

    @Override
    public long getStoredEmc() {
        return emcManager.getStoredEmc();
    }

    @Override
    public long getMaximumEmc() {
        return emcManager.getMaximumEmc();
    }

    @Override
    public long provideEMC(@Nonnull EnumFacing face, long toProvide) {
        if (world.getTileEntity(pos.offset(face)) instanceof TileEmcProviderRF) {
            return 0;
        } else {
            return emcManager.provideEMC(face, toProvide);
        }
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        tag = super.writeToNBT(tag);
        if(getStoredEmc() > getMaximumEmc()) {
            long current = getStoredEmc();
            current = getMaximumEmc();
        }
        tag.setLong("EMC", getStoredEmc());
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        long set = tag.getLong("EMC");
        if(set > getMaximumEmc()) {
            set = getMaximumEmc();
        }
        long current = getStoredEmc();
        current = set;
    }
}
