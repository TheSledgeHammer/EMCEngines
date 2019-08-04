package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;
import com.thesledgehammer.groovymc.api.minecraftjoules.MjTools;
import com.thesledgehammer.groovymc.integration.forgeenergy.ForgeEnergy;
import com.thesledgehammer.groovymc.integration.minecraftjoules.TieredMinecraftJoulesTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
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

    public int RF_Transfer(EnumVoltage voltage) {
        return (int) (Constants.MJ_Voltage(voltage) / MjTools.getMJ()) * 32;
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        tag = super.writeToNBT(tag);
        if (getEnergyStored() > getMaxEnergyStored()) {
            int current = getEnergyStored();
            current = getMaxEnergyStored();
        }
        tag.setInteger("feEnergy", getEnergyStored());
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        int set = tag.getInteger("feEnergy");
        if (set > getMaxEnergyStored()) {
            set = getMaxEnergyStored();
        }
        int current = getEnergyStored();
        current = set;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return CapabilityEnergy.ENERGY.cast(this);
        }
        return super.getCapability(capability, facing);
    }
}
