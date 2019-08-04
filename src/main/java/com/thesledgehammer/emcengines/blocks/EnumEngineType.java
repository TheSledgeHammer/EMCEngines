package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.engines.*;
import com.thesledgehammer.groovymc.blocks.properties.GroovyMachineProperties;
import com.thesledgehammer.groovymc.blocks.properties.IBlockType;
import com.thesledgehammer.groovymc.blocks.properties.MachinePropertyTraits;

public enum EnumEngineType implements IBlockType {
    EMC_ENGINE_MK1(createRfEngineProperties(TileEmcEngineMK1.class, "engine_mk1")),
    EMC_ENGINE_MK2(createRfEngineProperties(TileEmcEngineMK2.class, "engine_mk2")),
    EMC_ENGINE_MK3(createRfEngineProperties(TileEmcEngineMK3.class, "engine_mk3")),

    EMC_ENGINE_MK1_x8(createRfEngineProperties(TileEmcEngineMK1x8.class, "engine_mk1x8")),
    EMC_ENGINE_MK2_x8(createRfEngineProperties(TileEmcEngineMK2x8.class, "engine_mk2x8")),
    EMC_ENGINE_MK3_x8(createRfEngineProperties(TileEmcEngineMK3x8.class, "engine_mk3x8")),

    EMC_ENGINE_MK1_x64(createRfEngineProperties(TileEmcEngineMK1x64.class, "engine_mk1x64")),
    EMC_ENGINE_MK2_x64(createRfEngineProperties(TileEmcEngineMK2x64.class, "engine_mk2x64")),
    EMC_ENGINE_MK3_x64(createRfEngineProperties(TileEmcEngineMK3x64.class, "engine_mk3x64")),

    EMC_ENGINE_MJ(createMjEngineProperties(TileEmcEngineMj.class, "engine_mj"));

    private final MachinePropertyTraits<?> machinePropertyTraits;

    EnumEngineType(MachinePropertyTraits machinePropertyTraits) {
        this.machinePropertyTraits = machinePropertyTraits;
    }

    protected static MachinePropertyTraits<?> createRfEngineProperties(Class<? extends TileEmcEngineRFBase> teClass, String name) {
        MachinePropertyTraits<? extends TileEmcEngineRFBase> machinePropertiesRfEngine = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesRfEngine;
    }

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
