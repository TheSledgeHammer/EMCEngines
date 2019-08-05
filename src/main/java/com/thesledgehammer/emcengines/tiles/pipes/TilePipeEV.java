package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeEV extends TilePipeMJ {

    public TilePipeEV() {
        super("ev_pipe", Constants.MJ_Voltage(EnumVoltage.EXTREME) * 3, Constants.MJ_Voltage(EnumVoltage.EXTREME), EnumVoltage.EXTREME);
    }
}
