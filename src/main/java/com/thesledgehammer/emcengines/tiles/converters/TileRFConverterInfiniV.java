package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterInfiniV extends RFConverterTile {

    public TileRFConverterInfiniV() {
        super("rf_infiniv_converter", Constants.MJ_Voltage(EnumVoltage.INFINITE) * 3, Constants.MJ_Voltage(EnumVoltage.INFINITE), EnumVoltage.INFINITE);
    }
}
