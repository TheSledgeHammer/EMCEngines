package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.emcengines.Constants;

public class EMCEngineMK2 extends TileEngine {

    public EMCEngineMK2() {
        super("emc_engine_mk2", Constants.EMC_ENGINE_MK2_RF_CAPACITY, Constants.EMC_ENGINE_MK2_RF_TRANSFER, Constants.EMC_ENGINE_MK2_EMC_INPUT, Constants.EMC_ENGINE_MK2_EMC_MAX);
    }
}
