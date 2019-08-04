package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterLV extends RFConverterTile {

    public TileRFConverterLV() {
        super("rf_lv_converter", Constants.MJ_Voltage(EnumVoltage.LOW) * 3, Constants.MJ_Voltage(EnumVoltage.LOW), EnumVoltage.LOW);
    }
}
