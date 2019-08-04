package com.thesledgehammer.emcengines;

import buildcraft.api.mj.MjAPI;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;
import com.thesledgehammer.groovymc.api.minecraftjoules.MjTools;
import com.thesledgehammer.groovymc.integration.forgeenergy.ForgeEnergy;

public class Tester {

    public static void main(String[] args) {
        long base = MjTools.formatMj(Constants.EMC_TO_MJ(1024, 1));
       // System.out.println(base);
        //System.out.println(Constants.EMC_ENGINE_MJ_TRANSFER);
        long EMC_FACTOR = 16;
        long EMC_MAX_TRANSFER = 1024;
        long EMC_MAX_CAPACITY = 1000000;


        EmcManager EM = new EmcManager(10000000, 1024);
        long mjOut = (EMC_MAX_TRANSFER / EMC_FACTOR) * 64;
        long emcExtract = Math.min(EM.getMaxExtract(), 2000);
        EM.generateEMC(emcExtract);

        ForgeEnergy fe = new ForgeEnergy((int) EnumVoltage.INSANE.getVoltage() * 3, (int) EnumVoltage.INSANE.getVoltage());
        generateEnergy(fe, fe.getMaxExtract(), EnumVoltage.INSANE);

    }

    static void generateEnergy(ForgeEnergy fe, int amount, EnumVoltage voltage) {
        int volts = (int) voltage.getVoltage() * 32;
        if(amount >= volts) {
            amount = volts;
        }
        int generate = Math.min(fe.getEnergyStored(), volts);
        int maxGenerate =+ Math.max(generate, amount);
        System.out.println(maxGenerate);

    }

    public static long EMC_TO_MJ(long emcValue, int multiplier) {
        return ((emcValue / Constants.EMC_FACTOR) * multiplier) * MjAPI.MJ;
    }


    public static void MjEngine() {
        long MAX_OUTPUT = MjAPI.MJ;
        long MIN_OUTPUT = MAX_OUTPUT / 3;
        long esum = 0;
        long e = 3 * getMaxPower() / 8 - 7;
        long eLimit = (MAX_OUTPUT - MIN_OUTPUT) * 20;
        esum = clamp(esum + e, -eLimit, eLimit);
        System.out.println(clamp(e + esum / 20, MIN_OUTPUT, MAX_OUTPUT));
    }

    public static long clamp(long val, long min, long max) {
        return Math.max(min, Math.min(max, val));
    }

    public static long getMaxPower() {
        return 1000 * MjAPI.MJ;
    }
}
