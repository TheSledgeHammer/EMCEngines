package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeSV extends TilePipeMJ {

    public TilePipeSV() {
        super("sv_pipe", Constants.MJ_Voltage(EnumVoltage.SUPER) * 3, Constants.MJ_Voltage(EnumVoltage.SUPER), EnumVoltage.SUPER);
    }
}
