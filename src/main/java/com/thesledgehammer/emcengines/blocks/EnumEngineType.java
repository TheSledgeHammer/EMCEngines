package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.engines.*;
import com.thesledgehammer.groovymc.blocks.properties.*;
import com.thesledgehammer.groovymc.blocks.properties.GroovyMachineProperties;

public enum EnumEngineType implements IBlockType {
    EMC_ENGINE_MK1(createEngineProperties(TileEmcEngineMK1.class, "engine_mk1")),
    EMC_ENGINE_MK2(createEngineProperties(TileEmcEngineMK2.class, "engine_mk2")),
    EMC_ENGINE_MK3(createEngineProperties(TileEmcEngineMK3.class, "engine_mk3")),

    EMC_ENGINE_MK1_x8(createEngineProperties(TileEmcEngineMK1x8.class, "engine_mk1x8")),
    EMC_ENGINE_MK2_x8(createEngineProperties(TileEmcEngineMK2x8.class, "engine_mk2x8")),
    EMC_ENGINE_MK3_x8(createEngineProperties(TileEmcEngineMK3x8.class, "engine_mk3x8")),

    EMC_ENGINE_MK1_x64(createEngineProperties(TileEmcEngineMK1x64.class, "engine_mk1x64")),
    EMC_ENGINE_MK2_x64(createEngineProperties(TileEmcEngineMK2x64.class, "engine_mk2x64")),
    EMC_ENGINE_MK3_x64(createEngineProperties(TileEmcEngineMK3x64.class, "engine_mk3x64"));

    private final MachinePropertyTraits<?> machinePropertyTraits;

    EnumEngineType(MachinePropertyTraits machinePropertyTraits) {
        this.machinePropertyTraits = machinePropertyTraits;
    }

    protected static MachinePropertyTraits<?> createEngineProperties(Class<? extends TileEmcEngineBase> teClass, String name) {
        MachinePropertyTraits<? extends TileEmcEngineBase> machinePropertiesEngine = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesEngine;
    }


    protected static MachinePropertyTraits<?> createGeneratorProperties(Class<? extends TileEmcGeneratorBase> teClass, String name) {
        MachinePropertyTraits<? extends TileEmcGeneratorBase> machinePropertiesGenerator = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesGenerator;
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
