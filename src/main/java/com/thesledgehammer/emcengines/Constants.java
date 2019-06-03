package com.thesledgehammer.emcengines;

public class Constants {

    protected static int EMC_FACTOR = 16;
    public static long EMC_ENGINE_MK1_EMC_MAX = 1000000;
    public static long EMC_ENGINE_MK1_EMC_INPUT = 1024;
    public static int EMC_ENGINE_MK1_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, EMC_FACTOR);
    public static int EMC_ENGINE_MK1_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, EMC_FACTOR);

    public static long EMC_ENGINE_MK2_EMC_MAX = 10000000;
    public static long EMC_ENGINE_MK2_EMC_INPUT = 3072;
    public static int EMC_ENGINE_MK2_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, EMC_FACTOR);
    public static int EMC_ENGINE_MK2_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, EMC_FACTOR);

    public static long EMC_ENGINE_MK3_EMC_MAX = 10000000;
    public static long EMC_ENGINE_MK3_EMC_INPUT = 10240;
    public static int EMC_ENGINE_MK3_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, EMC_FACTOR);
    public static int EMC_ENGINE_MK3_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, EMC_FACTOR);

    public static long EMC_ENGINE_MK1_x8_EMC_MAX = 1000000;
    public static long EMC_ENGINE_MK1_x8_EMC_INPUT = 1024;
    public static int EMC_ENGINE_MK1_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK1_EMC_MAX, EMC_FACTOR) * 8;
    public static int EMC_ENGINE_MK1_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK1_EMC_INPUT, EMC_FACTOR) * 8;

    public static long EMC_ENGINE_MK2_x8_EMC_MAX = 10000000;
    public static long EMC_ENGINE_MK2_x8_EMC_INPUT = 3072;
    public static int EMC_ENGINE_MK2_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK2_EMC_MAX, EMC_FACTOR) * 8;
    public static int EMC_ENGINE_MK2_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK2_EMC_INPUT, EMC_FACTOR) * 8;

    public static long EMC_ENGINE_MK3_x8_EMC_MAX = 10000000;
    public static long EMC_ENGINE_MK3_x8_EMC_INPUT = 10240;
    public static int EMC_ENGINE_MK3_x8_RF_CAPACITY = EMC_TO_RF(EMC_ENGINE_MK3_EMC_MAX, EMC_FACTOR) * 8;
    public static int EMC_ENGINE_MK3_x8_RF_TRANSFER = EMC_TO_RF(EMC_ENGINE_MK3_EMC_INPUT, EMC_FACTOR) * 8;

    protected static int EMC_TO_RF(long emcValue, int factor) {
        return (int) emcValue / factor;
    }

    protected static int RF_TO_EMC(long emcValue, int factor) {
        return (int) emcValue * factor;
    }
}
