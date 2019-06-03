package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.emcengines.Constants;

public class EMCEngineMK3x8 extends TileEngine {

    public EMCEngineMK3x8() {
        super("emc_engine_mk3x8", Constants.EMC_ENGINE_MK3_x8_RF_CAPACITY, Constants.EMC_ENGINE_MK3_x8_RF_TRANSFER, Constants.EMC_ENGINE_MK3_x8_EMC_INPUT, Constants.EMC_ENGINE_MK3_x8_EMC_MAX);
    }
}
