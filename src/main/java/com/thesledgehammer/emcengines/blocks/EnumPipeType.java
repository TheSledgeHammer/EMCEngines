package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.pipes.*;
import com.thesledgehammer.groovymc.blocks.properties.GroovyMachineProperties;
import com.thesledgehammer.groovymc.blocks.properties.IBlockType;
import com.thesledgehammer.groovymc.blocks.properties.MachinePropertyTraits;

public enum EnumPipeType implements IBlockType {
    LV_PIPE(createPipeProperties(TilePipeLV.class, "lv_pipe")),
    MV_PIPE(createPipeProperties(TilePipeMV.class, "mv_pipe")),
    HV_PIPE(createPipeProperties(TilePipeHV.class, "hv_pipe")),
    UV_PIPE(createPipeProperties(TilePipeUV.class, "uv_pipe")),
    SV_PIPE(createPipeProperties(TilePipeSV.class, "sv_pipe")),
    EV_PIPE(createPipeProperties(TilePipeEV.class, "ev_pipe")),
    IV_PIPE(createPipeProperties(TilePipeIV.class, "iv_pipe")),
    INFINIV_PIPE(createPipeProperties(TilePipeInfiniV.class, "infiniv_pipe"));

    private final MachinePropertyTraits<?> machinePropertyTraits;

    EnumPipeType(MachinePropertyTraits machinePropertyTraits) {
        this.machinePropertyTraits = machinePropertyTraits;
    }

    protected static MachinePropertyTraits<?> createPipeProperties(Class<? extends TilePipeMJ> teClass, String name) {
        MachinePropertyTraits<? extends TilePipeMJ> machinePropertiesPipe = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesPipe;
    }

    @Override
    public MachinePropertyTraits getGroovyMachineProperties() {
        return machinePropertyTraits;
    }

    @Override
    public String getName() {
        return getGroovyMachineProperties().getName();
    }
}
