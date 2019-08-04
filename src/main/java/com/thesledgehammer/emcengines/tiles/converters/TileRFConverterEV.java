package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterEV extends RFConverterTile {

    public TileRFConverterEV() {
        super("rf_ev_converter", Constants.MJ_Voltage(EnumVoltage.EXTREME) * 3, Constants.MJ_Voltage(EnumVoltage.EXTREME), EnumVoltage.EXTREME);
    }
}
