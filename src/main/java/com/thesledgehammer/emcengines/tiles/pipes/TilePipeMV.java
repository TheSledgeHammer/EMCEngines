package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeMV extends TilePipeMJ {

    public TilePipeMV() {
        super("mv_pipe", Constants.MJ_Voltage(EnumVoltage.MEDIUM) * 3, Constants.MJ_Voltage(EnumVoltage.MEDIUM), EnumVoltage.MEDIUM);
    }
}
