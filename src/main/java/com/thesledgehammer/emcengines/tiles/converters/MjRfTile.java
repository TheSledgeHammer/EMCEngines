package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;
import com.thesledgehammer.groovymc.integration.forgeenergy.ForgeEnergy;
import com.thesledgehammer.groovymc.integration.minecraftjoules.TieredMinecraftJoulesTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MjRfTile extends TieredMinecraftJoulesTile implements IEnergyStorage {

    protected ForgeEnergy fe;

    public MjRfTile(String tileName, long capacity, EnumVoltage voltage) {
        super(capacity, voltage);
        this.fe = new ForgeEnergy(Constants.MJ_TO_RF(capacity));
    }

    public MjRfTile(String tileName, long capacity, long maxTransfer, EnumVoltage voltage) {
        super(capacity, maxTransfer, voltage);
        this.fe = new ForgeEnergy(Constants.MJ_TO_RF(capacity), Constants.MJ_TO_RF(maxTransfer));
    }

    public MjRfTile(String tileName, long capacity, long maxReceive, long maxExtract, EnumVoltage voltage) {
        super(capacity, maxReceive, maxExtract, voltage);
        this.fe = new ForgeEnergy(Constants.MJ_TO_RF(capacity), Constants.MJ_TO_RF(maxReceive), Constants.MJ_TO_RF(maxExtract));
    }

    public MjRfTile(String tileName, long capacity, long maxReceive, long maxExtract, long power, EnumVoltage voltage) {
        super(capacity, maxReceive, maxExtract, power, voltage);
        this.fe = new ForgeEnergy(Constants.MJ_TO_RF(capacity), Constants.MJ_TO_RF(maxReceive), Constants.MJ_TO_RF(maxExtract), Constants.MJ_TO_RF(power));
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return fe.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return fe.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        return fe.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored() {
        return fe.getMaxEnergyStored();
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        fe.readFromNBT(tagCompound);
    }

    @Override
    @Nonnull
    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        fe.writeToNBT(tagCompound);
        return tagCompound;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return fe.hasCapability(capability, facing) || super.hasCapability(capability, facing);
    }

    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        T feCapability = fe.getCapability(capability, facing);
        if(feCapability != null) {
            return feCapability;
        }
        return super.getCapability(capability, facing);
    }
}
