package com.thesledgehammer.emcengines;

import buildcraft.api.mj.MjAPI;

public class Tester {

    public static void main(String[] args) {

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