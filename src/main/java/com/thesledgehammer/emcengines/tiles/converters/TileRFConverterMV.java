package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterMV extends RFConverterTile {

    public TileRFConverterMV() {
        super("rf_mv_converter", Constants.MJ_Voltage(EnumVoltage.MEDIUM) * 3, Constants.MJ_Voltage(EnumVoltage.MEDIUM), EnumVoltage.MEDIUM);
    }
}
