package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeIV extends TilePipeMJ {

    public TilePipeIV() {
        super("iv_pipe", Constants.MJ_Voltage(EnumVoltage.INSANE) * 3, Constants.MJ_Voltage(EnumVoltage.INSANE), EnumVoltage.INSANE);
    }
}
