package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.emcengines.Constants;

public class EMCEngineMK3 extends TileEngine {

    public EMCEngineMK3() {
        super("emc_engine_mk3", Constants.EMC_ENGINE_MK3_RF_CAPACITY, Constants.EMC_ENGINE_MK3_RF_TRANSFER, Constants.EMC_ENGINE_MK3_EMC_INPUT, Constants.EMC_ENGINE_MK3_EMC_MAX);
    }
}
