package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.engines.*;
import com.thesledgehammer.groovymc.blocks.properties.*;
import com.thesledgehammer.groovymc.blocks.properties.GroovyMachineProperties;

public enum EnumEngineType implements IBlockType {
    EMC_ENGINE_MK1(createEngineProperties(EMCEngineMK1.class, "engine_mk1")),
    EMC_ENGINE_MK2(createEngineProperties(EMCEngineMK2.class, "engine_mk2")),
    EMC_ENGINE_MK3(createEngineProperties(EMCEngineMK3.class, "engine_mk3")),

    EMC_ENGINE_MK1_x8(createEngineProperties(EMCEngineMK1x8.class, "engine_mk1x8")),
    EMC_ENGINE_MK2_x8(createEngineProperties(EMCEngineMK2x8.class, "engine_mk2x8")),
    EMC_ENGINE_MK3_x8(createEngineProperties(EMCEngineMK3x8.class, "engine_mk3x8"));
    /*
        EMC_ENGINE_MK1_x64(createEngineProperties(EMCEngineMK1.class, "engine_mk1x64")),
        EMC_ENGINE_MK2_x64(createEngineProperties(TileEngine.class, "engine_mk2x64")),
        EMC_ENGINE_MK3_x64(createEngineProperties(TileEngine.class, "engine_mk3x64"));
    */
    private final MachinePropertyTraits<?> machinePropertyTraits;

    EnumEngineType(MachinePropertyTraits machinePropertyTraits) {
        this.machinePropertyTraits = machinePropertyTraits;
    }

    protected static MachinePropertyTraits<?> createEngineProperties(Class<? extends TileEngine> teClass, String name) {
        MachinePropertyTraits<? extends TileEngine> machinePropertiesEngine = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesEngine;
    }


    protected static MachinePropertyTraits<?> createGeneratorProperties(Class<? extends TileGenerator> teClass, String name) {
        MachinePropertyTraits<? extends TileGenerator> machinePropertiesGenerator = new GroovyMachineProperties<>(teClass, name);
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
