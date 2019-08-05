package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeInfiniV extends TilePipeMJ {

    public TilePipeInfiniV() {
        super("infiniv_pipe", Constants.MJ_Voltage(EnumVoltage.INFINITE) * 3, Constants.MJ_Voltage(EnumVoltage.INFINITE), EnumVoltage.INFINITE);
    }
}
