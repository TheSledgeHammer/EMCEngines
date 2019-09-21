package com.thesledgehammer.emcengines.tiles;

import com.thesledgehammer.groovymc.api.EnergyConfig;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj;
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage;
import com.thesledgehammer.groovymc.compat.forgeenergy.ForgeEnergy;
import com.thesledgehammer.groovymc.compat.minecraftjoules.MinecraftJoules;
import com.thesledgehammer.groovymc.tiles.GroovyTileBasic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileRfMj extends GroovyTileBasic implements IMjStorage, IEnergyStorage {

    private final MinecraftJoules mj;
    private final ForgeEnergy fe;

    public TileRfMj(EnumVoltage voltage, int capacityMultiplier) {
        int RF_LIMIT = 32;
        EnergyConfig MJ = EnergyConfig.createMJConfig((voltage.getVoltage() * capacityMultiplier), voltage.getVoltage(), voltage.getVoltage());
        EnergyConfig RF = EnergyConfig.createRFConfig((int) (voltage.getVoltage() * 100 * capacityMultiplier), (int) (voltage.getVoltage() * RF_LIMIT), (int) (voltage.getVoltage() * RF_LIMIT));

        this.mj = new MinecraftJoules(MJ.getCapacity(), MJ.getMaxReceive(), MJ.getMaxExtract());
        this.fe = new ForgeEnergy((int) RF.getCapacity(), (int) RF.getMaxReceive(), (int) RF.getMaxExtract());
    }

    protected void convert(EnumFacing facing, TileEntity tile) {
        if (tile.hasCapability(CapabilityEnergy.ENERGY, facing) || tile.hasCapability(CapabilityMj.getMJ_STORAGE(), facing)) {
            IMjStorage extractMJ = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing.getOpposite());
            if(extractMJ != null && extractMJ.getStored() > 0) {
                long toReceive = extractMJ.extractPower(0, fe.getMaxExtract(), true);
                fe.generateEnergy((int) toReceive);
                mj.generatePower(mj.getMaxExtract());
            }
            IEnergyStorage insertFE = tile.getCapability(CapabilityEnergy.ENERGY, facing);
            if(insertFE != null && getStored() > 0) {
                long toExtract = extractPower(0, fe.getMaxExtract(), true);
                mj.drainPower(insertFE.receiveEnergy((int) toExtract, false));
                fe.drainEnergy(fe.getMaxExtract());
            }
        }
    }

    protected void invert(EnumFacing facing, TileEntity tile) {
        if(tile.hasCapability(CapabilityEnergy.ENERGY, facing) || tile.hasCapability(CapabilityMj.getMJ_STORAGE(), facing)) {

            IEnergyStorage extractFE = tile.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
            if(extractFE != null && extractFE.getEnergyStored() > 0) {
                int toReceive = extractFE.extractEnergy(fe.getMaxExtract(), true);
                fe.generateEnergy(toReceive);
                mj.generatePower(mj.getMaxExtract());
            }

            IMjStorage insertMJ = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing);
            if(insertMJ != null && getEnergyStored() > 0) {
                int toExtract = extractEnergy(fe.getMaxExtract(), true);
                fe.drainEnergy((int) insertMJ.receivePower(toExtract, false));
                mj.drainPower(mj.getMaxExtract());
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        mj.readFromNBT(tagCompound);
        fe.readFromNBT(tagCompound);
    }

    @Override
    @Nonnull
    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        mj.writeToNBT(tagCompound);
        fe.writeToNBT(tagCompound);
        return tagCompound;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return mj.hasCapability(capability, facing) || fe.hasCapability(capability, facing) || super.hasCapability(capability, facing);
    }

    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        T mjCapability = mj.getCapability(capability, facing);
        if(mjCapability != null) {
            return mjCapability;
        }
        T feCapability = fe.getCapability(capability, facing);
        if(feCapability != null) {
            return feCapability;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

    //IMjStorage
    @Override
    public long getPowerRequested() {
        return mj.getPowerRequested();
    }

    @Override
    public long extractPower(long min, long max, boolean simulate) {
        return mj.extractPower(min, max, simulate);
    }

    @Override
    public long receivePower(long microJoules, boolean simulate) {
        return mj.receivePower(microJoules, simulate);
    }

    @Override
    public long getStored() {
        return mj.getStored();
    }

    @Override
    public long getCapacity() {
        return mj.getCapacity();
    }

    @Override
    public boolean canConnect(@Nonnull IMjStorage iMjStorage) {
        return true;
    }

    //IEnergyStorage
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
}
