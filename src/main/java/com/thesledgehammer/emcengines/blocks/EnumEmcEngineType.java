package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.engines.TileEmcEngineMJBase;
import com.thesledgehammer.emcengines.tiles.engines.TileEmcEngineMj;
import com.thesledgehammer.groovymc.blocks.properties.GroovyMachineProperties;
import com.thesledgehammer.groovymc.blocks.properties.IBlockType;
import com.thesledgehammer.groovymc.blocks.properties.MachinePropertyTraits;

public enum EnumEmcEngineType implements IBlockType {

    EMC_ENGINE_MJ(createMjEngineProperties(TileEmcEngineMj.class, "engine_mj"));

    private final MachinePropertyTraits<?> machinePropertyTraits;

    EnumEmcEngineType(MachinePropertyTraits machinePropertyTraits) {
        this.machinePropertyTraits = machinePropertyTraits;
    }
/*
    protected static MachinePropertyTraits<?> createRfEngineProperties(Class<? extends TileEmcEngineRFBase> teClass, String name) {
        MachinePropertyTraits<? extends TileEmcEngineRFBase> machinePropertiesRfEngine = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesRfEngine;
    }*/

    protected static MachinePropertyTraits<?> createMjEngineProperties(Class<? extends TileEmcEngineMJBase> teClass, String name) {
        MachinePropertyTraits<? extends TileEmcEngineMJBase> machinePropertiesMjEngine = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesMjEngine;
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
