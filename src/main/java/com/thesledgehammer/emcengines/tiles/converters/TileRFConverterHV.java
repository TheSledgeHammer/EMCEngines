package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterHV extends RFConverterTile {

    public TileRFConverterHV() {
        super("rf_hv_converter", Constants.MJ_Voltage(EnumVoltage.HIGH) * 3, Constants.MJ_Voltage(EnumVoltage.HIGH), EnumVoltage.HIGH);
    }
}
