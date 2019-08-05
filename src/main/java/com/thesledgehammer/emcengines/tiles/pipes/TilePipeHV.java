package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeHV extends TilePipeMJ {

    public TilePipeHV() {
        super("hv_pipe", Constants.MJ_Voltage(EnumVoltage.HIGH) * 3, Constants.MJ_Voltage(EnumVoltage.HIGH), EnumVoltage.HIGH);
    }
}
