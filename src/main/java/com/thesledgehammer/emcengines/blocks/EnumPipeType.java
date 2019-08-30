package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum EnumPipeType implements IStringSerializable {

    LV_PIPE(Constants.MJ_Voltage(EnumVoltage.LOW), Constants.MJ_Voltage(EnumVoltage.LOW)),
    MV_PIPE(Constants.MJ_Voltage(EnumVoltage.MEDIUM), Constants.MJ_Voltage(EnumVoltage.MEDIUM)),
    HV_PIPE(Constants.MJ_Voltage(EnumVoltage.HIGH), Constants.MJ_Voltage(EnumVoltage.HIGH)),
    UV_PIPE(Constants.MJ_Voltage(EnumVoltage.ULTRA), Constants.MJ_Voltage(EnumVoltage.ULTRA)),
    SV_PIPE(Constants.MJ_Voltage(EnumVoltage.SUPER), Constants.MJ_Voltage(EnumVoltage.SUPER)),
    EV_PIPE(Constants.MJ_Voltage(EnumVoltage.EXTREME), Constants.MJ_Voltage(EnumVoltage.EXTREME)),
    IV_PIPE(Constants.MJ_Voltage(EnumVoltage.INSANE), Constants.MJ_Voltage(EnumVoltage.INSANE)),
    INFINIV_PIPE(Constants.MJ_Voltage(EnumVoltage.INFINITE), Constants.MJ_Voltage(EnumVoltage.INFINITE));

    public static final EnumPipeType[] VALUES = values();
    private final String name;
    private final long capacity;
    private final long maxTransfer;

    EnumPipeType(long capacity, long maxTransfer) {
        this.name = toString().toLowerCase(Locale.ENGLISH);
        this.capacity = capacity;
        this.maxTransfer = maxTransfer;
    }

    public long getCapacity() {
        return capacity;
    }

    public long getMaxTransfer() {
        return maxTransfer;
    }

    @Override
    @Nonnull
    public String getName() {
        return name;
    }

    public int getMeta() {
        return ordinal();
    }
}
