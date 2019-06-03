package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.emcengines.Constants;

public class EMCEngineMK1 extends TileEngine {

    public EMCEngineMK1() {
        super("emc_engine_mk1", Constants.EMC_ENGINE_MK1_RF_CAPACITY, Constants.EMC_ENGINE_MK1_RF_TRANSFER, Constants.EMC_ENGINE_MK1_EMC_INPUT, Constants.EMC_ENGINE_MK1_EMC_MAX);
    }
}
