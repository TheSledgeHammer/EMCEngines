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
        System.out.println(pm.get(0));
    }
}
