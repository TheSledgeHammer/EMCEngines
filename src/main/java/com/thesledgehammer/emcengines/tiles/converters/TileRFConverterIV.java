package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterIV extends RFConverterTile {

    public TileRFConverterIV() {
        super("rf_iv_converter", Constants.MJ_Voltage(EnumVoltage.INSANE) * 3, Constants.MJ_Voltage(EnumVoltage.INSANE), EnumVoltage.INSANE);
    }
}
