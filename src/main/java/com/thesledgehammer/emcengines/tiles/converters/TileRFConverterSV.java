package com.thesledgehammer.emcengines.tiles.converters;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TileRFConverterSV extends RFConverterTile {

    public TileRFConverterSV() {
        super("rf_sv_converter", Constants.MJ_Voltage(EnumVoltage.SUPER) * 3, Constants.MJ_Voltage(EnumVoltage.SUPER), EnumVoltage.SUPER);
    }
}
