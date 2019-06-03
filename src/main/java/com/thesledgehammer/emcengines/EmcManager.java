package com.thesledgehammer.emcengines;

import moze_intel.projecte.api.tile.IEmcAcceptor;
import moze_intel.projecte.api.tile.IEmcProvider;
import moze_intel.projecte.api.tile.IEmcStorage;
import net.minecraft.util.EnumFacing;

import javax.annotation.Nonnull;

public class EmcManager implements IEmcAcceptor, IEmcProvider, IEmcStorage {

    protected long currentEMC;
    private long capacity;
    private long maxReceive;
    private long maxExtract;
    private long maximumEMC;

    public EmcManager(long capacity) {
        setMaxCapacity(capacity);
        setMaximumEMC(Long.MAX_VALUE);
    }

    public EmcManager(long capacity, long maxTransfer) {
        setMaxCapacity(capacity);
        setMaxReceive(maxTransfer);
        setMaxExtract(maxTransfer);
        setMaximumEMC(Long.MAX_VALUE);
    }

    public EmcManager(long capacity, long maxReceive, long maxExtract) {
        setMaxCapacity(capacity);
        setMaxReceive(maxReceive);
        setMaxExtract(maxExtract);
        setMaximumEMC(Long.MAX_VALUE);
    }

    public void setMaxCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void setMaxReceive(long maxReceive) {
        this.maxReceive = maxReceive;
    }

    public void setMaxExtract(long maxExtract) {
        this.maxExtract = maxExtract;
    }

    public void setMaximumEMC(long maximumEMC) {
        this.maximumEMC = maximumEMC;
        if(currentEMC > maximumEMC) {
            currentEMC = maximumEMC;
        }
    }

    public long getCapacity() {
        return capacity;
    }

    public long getMaxReceive() {
        return maxReceive;
    }

    public long getMaxExtract() {
        return maxExtract;
    }

    public void modifyEmcStored(long currentEMC) {
        this.currentEMC = currentEMC;
        if(currentEMC > this.capacity) {
            this.currentEMC = this.capacity;
        } else if(this.currentEMC < 0) {
            this.currentEMC = 0;
        }
    }

    @Override
    public long acceptEMC(@Nonnull EnumFacing enumFacing, long toAccept) {
        long toAdd = Math.min(maximumEMC - currentEMC, toAccept);
        currentEMC += toAdd;
        return toAdd;
    }

    @Override
    public long provideEMC(@Nonnull EnumFacing enumFacing, long toExtract) {
        long toRemove = Math.min(currentEMC, toExtract);
        currentEMC -= toRemove;
        return toRemove;
    }

    @Override
    public long getStoredEmc() {
        return currentEMC;
    }

    @Override
    public long getMaximumEmc() {
        return maximumEMC;
    }

    public long getMaxStoredEmc() {
        return capacity;
    }
}
