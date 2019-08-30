package com.thesledgehammer.emcengines;

import buildcraft.api.mj.MjAPI;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import com.thesledgehammer.groovymc.api.minecraftjoules.MjTools;

public class Constants {

    public static int EMC_FACTOR = 16;
    //Collector to Relay Tier Output Factor = 16
    //Relay Tier Output = mk * 3 (mk1 ->  mk2 -> mk3) or mk / 3 (mk3 ->  mk2 -> mk1)
    //Relay Tier Max = 10 (mk1 ->  mk2 -> mk3)

    public static final long CURRENT_EMC_BASE_TRANSFER = 1024;
    public static final long MAX_EMC_BASE_CAPACITY = 1_000_000;

    public static long EMC_ENGINE_MK1_EMC_MAX = 1_000_000;
    public static long EMC_ENGINE_MK1_EMC_INPUT = 1024;

    public static int EMC_ENGINE_MK1_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, 1);
    public static int EMC_ENGINE_MK1_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, 1);

    public static int EMC_ENGINE_MK1_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, 8);
    public static int EMC_ENGINE_MK1_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, 8);

    public static int EMC_ENGINE_MK1_x64_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, 64);
    public static int EMC_ENGINE_MK1_x64_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, 64);

    public static long EMC_ENGINE_MK2_EMC_MAX = 10_000_000;
    public static long EMC_ENGINE_MK2_EMC_INPUT = 3072;
    public static int EMC_ENGINE_MK2_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, 1);
    public static int EMC_ENGINE_MK2_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, 1);
    public static int EMC_ENGINE_MK2_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, 8);
    public static int EMC_ENGINE_MK2_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, 8);
    public static int EMC_ENGINE_MK2_x64_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, 64);
    public static int EMC_ENGINE_MK2_x64_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, 64);

    public static long EMC_ENGINE_MK3_EMC_MAX = 100_000_000;
    public static long EMC_ENGINE_MK3_EMC_INPUT = 10_240;
    public static int EMC_ENGINE_MK3_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, 1);
    public static int EMC_ENGINE_MK3_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, 1);
    public static int EMC_ENGINE_MK3_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, 8);
    public static int EMC_ENGINE_MK3_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, 8);
    public static int EMC_ENGINE_MK3_x64_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, 64);
    public static int EMC_ENGINE_MK3_x64_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, 64);

    public static long EMC_ENGINE_MJ_EMC_MAX = 10_000_000;
    public static long EMC_ENGINE_MJ_EMC_INPUT = 3072;
    public static long EMC_ENGINE_MJ_CAPACITY = EMC_TO_MJ(EMC_ENGINE_MJ_EMC_MAX, 64);
    public static long EMC_ENGINE_MJ_TRANSFER = EMC_TO_MJ(EMC_ENGINE_MJ_EMC_INPUT, 64);


    private static int EMC_TO_RF(long emcValue, int multiplier) {
        return (int) (emcValue / EMC_FACTOR) * multiplier;
    }

    private static int RF_TO_EMC(long emcValue, int multiplier) {
        return (int) (emcValue * EMC_FACTOR) * multiplier;
    }

    public static long EMC_TO_MJ(long emcValue, int multiplier) {
        return ((emcValue / EMC_FACTOR) * multiplier) * MjAPI.MJ;
    }

    private static long MJ_TO_EMC(long emcValue, int multiplier) {
        return ((emcValue * EMC_FACTOR) * multiplier) * MjAPI.MJ;
    }

    public static long toMJ(long amount) {
        return amount * MjTools.getMJ();
    }

    //To Remove
    public static long MJ_Voltage(EnumVoltage voltage) {
        return voltage.getVoltage() * MjTools.getMJ();
    }

    public static int RF_Voltage(EnumVoltage voltage) {
        return (int) (MJ_Voltage(voltage) / MjTools.getMJ()) * 32;
    }
}
