package com.thesledgehammer.emcengines;

import com.thesledgehammer.emcengines.tiles.pipes.PipeManager;
import com.thesledgehammer.emcengines.tiles.pipes.RFPipe;
import groovydatastructuresalgorithms.CircularDoublyLinkedList;

import java.util.LinkedList;

public class Tester {

    public static void main(String[] args) {

        LinkedList<RFPipe> pm = new LinkedList<>();
        RFPipe p = new RFPipe();
        pm.add(p);
        System.out.println(Constants.EMC_ENGINE_MK1_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK2_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK3_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK1_x8_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK2_x8_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK3_x8_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK1_x64_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK2_x64_RF_TRANSFER);
        System.out.println(Constants.EMC_ENGINE_MK3_x64_RF_TRANSFER);
    }
}
