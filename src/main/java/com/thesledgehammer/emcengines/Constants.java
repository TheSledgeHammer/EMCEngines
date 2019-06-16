package com.thesledgehammer.emcengines;

import buildcraft.api.mj.MjAPI;

public class Constants {

    public static int EMC_FACTOR = 16;
    public static long EMC_ENGINE_MK1_EMC_MAX = 1000000;
    public static long EMC_ENGINE_MK1_EMC_INPUT = 1024;
    public static int EMC_ENGINE_MK1_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, 1);
    public static int EMC_ENGINE_MK1_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, 1);
    public static int EMC_ENGINE_MK1_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, 8);
    public static int EMC_ENGINE_MK1_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, 8);
    public static int EMC_ENGINE_MK1_x64_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, 64);
    public static int EMC_ENGINE_MK1_x64_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, 64);

    public static long EMC_ENGINE_MK2_EMC_MAX = 10000000;
    public static long EMC_ENGINE_MK2_EMC_INPUT = 3072;
    public static int EMC_ENGINE_MK2_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, 1);
    public static int EMC_ENGINE_MK2_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, 1);
    public static int EMC_ENGINE_MK2_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, 8);
    public static int EMC_ENGINE_MK2_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, 8);
    public static int EMC_ENGINE_MK2_x64_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, 64);
    public static int EMC_ENGINE_MK2_x64_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, 64);

    public static long EMC_ENGINE_MK3_EMC_MAX = 10000000;
    public static long EMC_ENGINE_MK3_EMC_INPUT = 10240;
    public static int EMC_ENGINE_MK3_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, 1);
    public static int EMC_ENGINE_MK3_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, 1);
    public static int EMC_ENGINE_MK3_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, 8);
    public static int EMC_ENGINE_MK3_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, 8);
    public static int EMC_ENGINE_MK3_x64_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, 64);
    public static int EMC_ENGINE_MK3_x64_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, 64);

    public static long EMC_ENGINE_MJ_EMC_MAX = 1000000;
    public static long EMC_ENGINE_MJ_EMC_INPUT = 1024;
    public static long EMC_ENGINE_MJ_CAPACITY = EMC_TO_MJ(EMC_ENGINE_MJ_EMC_MAX, 1);
    public static long EMC_ENGINE_MJ_TRANSFER = EMC_TO_MJ(EMC_ENGINE_MJ_EMC_INPUT, 1);


    private static int EMC_TO_RF(long emcValue, int multiplier) {
        return (int) (emcValue / EMC_FACTOR) * multiplier;
    }

    private static int RF_TO_EMC(long emcValue, int multiplier) {
        return (int) (emcValue * EMC_FACTOR) * multiplier;
    }

    private static long EMC_TO_MJ(long emcValue, int multiplier) {
        return ((emcValue / EMC_FACTOR) * multiplier) * MjAPI.MJ;
    }

    private static long MJ_TO_EMC(long emcValue, int multiplier) {
        return ((emcValue * EMC_FACTOR) * multiplier) * MjAPI.MJ;
    }
}
