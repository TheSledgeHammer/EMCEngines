package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.emcengines.EmcManager;
import com.thesledgehammer.groovymc.compat.forgeenergy.ForgeEnergyTile;
import moze_intel.projecte.api.tile.IEmcAcceptor;
import moze_intel.projecte.api.tile.IEmcProvider;
import moze_intel.projecte.api.tile.IEmcStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

import javax.annotation.Nonnull;

public class TileEmcRF extends ForgeEnergyTile implements IEmcAcceptor, IEmcProvider, IEmcStorage {

    protected EmcManager emcManager;

    public TileEmcRF(int feCapacity, int feTransfer, long currentEMC, long maximumEMC) {
        super(feCapacity, feTransfer);
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
    public long acceptEMC(@Nonnull EnumFacing face, long toAccept) {
        if (world.getTileEntity(pos.offset(face)) instanceof TileEmcRF) {
            return 0;
        } else {
            return emcManager.acceptEMC(face, toAccept);
        }
    }

    @Override
    public long provideEMC(@Nonnull EnumFacing face, long toProvide) {
        if (world.getTileEntity(pos.offset(face)) instanceof TileEmcRF) {
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
