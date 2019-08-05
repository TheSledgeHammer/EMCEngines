package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.EnumVoltage;

public class TilePipeLV extends TilePipeMJ {

    public TilePipeLV() {
        super("lv_pipe", Constants.MJ_Voltage(EnumVoltage.LOW) * 3, Constants.MJ_Voltage(EnumVoltage.LOW), EnumVoltage.LOW);
    }
}
