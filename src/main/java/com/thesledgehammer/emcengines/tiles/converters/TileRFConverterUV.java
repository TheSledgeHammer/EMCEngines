package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterUV extends RFConverterTile {

    public TileRFConverterUV() {
        super("rf_uv_converter", Constants.MJ_Voltage(EnumVoltage.ULTRA) * 3, Constants.MJ_Voltage(EnumVoltage.ULTRA), EnumVoltage.ULTRA);
    }
}
