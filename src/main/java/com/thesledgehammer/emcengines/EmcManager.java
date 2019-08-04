package com.thesledgehammer.emcengines;

import moze_intel.projecte.api.tile.IEmcAcceptor;
import moze_intel.projecte.api.tile.IEmcProvider;
import moze_intel.projecte.api.tile.IEmcStorage;
import net.minecraft.util.EnumFacing;

import javax.annotation.Nonnull;

public class EmcManager implements IEmcAcceptor, IEmcProvider, IEmcStorage {

    private long currentEMC;
    private long maxReceive;
    private long maxExtract;
    private long maximumEMC;

    public EmcManager(long maxTransfer) {
        this(Long.MAX_VALUE, maxTransfer, maxTransfer);
    }

    public EmcManager(long maximumEMC, long maxTransfer) {
        this(maximumEMC, maxTransfer, maxTransfer);
    }

    public EmcManager(long maximumEMC, long maxReceive, long maxExtract) {
        setMaxReceive(maxReceive);
        setMaxExtract(maxExtract);
        setMaximumEMC(maximumEMC);
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

    public long getMaxReceive() {
        return maxReceive;
    }

    public long getMaxExtract() {
        return maxExtract;
    }

    public void drainEMC(long amount) {
        modifyEmcStored(currentEMC - amount);
    }

    public void generateEMC(long amount) {
        modifyEmcStored(currentEMC + amount);
    }

    private void modifyEmcStored(long currentEMC) {
        this.currentEMC = currentEMC;
        if(currentEMC > this.maximumEMC) {
            this.currentEMC = this.maximumEMC;
        } else if(this.currentEMC < 0) {
            this.currentEMC = 0;
        }
    }

    @Override
    public long getStoredEmc() {
        return currentEMC;
    }

    @Override
    public long getMaximumEmc() {
        return maximumEMC;
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
}
