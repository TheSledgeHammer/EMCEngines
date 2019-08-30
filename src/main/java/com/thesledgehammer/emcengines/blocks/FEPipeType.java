package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum FEPipeType implements IStringSerializable {

    LV_PIPE(Constants.RF_Voltage(EnumVoltage.LOW), Constants.RF_Voltage(EnumVoltage.LOW)),
    MV_PIPE(Constants.RF_Voltage(EnumVoltage.MEDIUM), Constants.RF_Voltage(EnumVoltage.MEDIUM)),
    HV_PIPE(Constants.RF_Voltage(EnumVoltage.HIGH), Constants.RF_Voltage(EnumVoltage.HIGH)),
    UV_PIPE(Constants.RF_Voltage(EnumVoltage.ULTRA), Constants.RF_Voltage(EnumVoltage.ULTRA)),
    SV_PIPE(Constants.RF_Voltage(EnumVoltage.SUPER), Constants.RF_Voltage(EnumVoltage.SUPER)),
    EV_PIPE(Constants.RF_Voltage(EnumVoltage.EXTREME), Constants.RF_Voltage(EnumVoltage.EXTREME)),
    IV_PIPE(Constants.RF_Voltage(EnumVoltage.INSANE), Constants.RF_Voltage(EnumVoltage.INSANE)),
    INFINIV_PIPE(Constants.RF_Voltage(EnumVoltage.INFINITE), Constants.RF_Voltage(EnumVoltage.INFINITE));

    public static final FEPipeType[] VALUES = values();
    private final String name;
    private final int capacity;
    private final int maxTransfer;

    FEPipeType(int capacity, int maxTransfer) {
        this.name = toString().toLowerCase(Locale.ENGLISH);
        this.capacity = capacity;
        this.maxTransfer = maxTransfer;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxTransfer() {
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
