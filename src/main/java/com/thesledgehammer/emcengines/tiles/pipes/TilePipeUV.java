package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeUV extends TilePipeMJ {

    public TilePipeUV() {
        super("uv_pipe", Constants.MJ_Voltage(EnumVoltage.ULTRA) * 3, Constants.MJ_Voltage(EnumVoltage.ULTRA), EnumVoltage.ULTRA);
    }
}
