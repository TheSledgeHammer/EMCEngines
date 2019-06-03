package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.pipes.RFPipe;
import com.thesledgehammer.emcengines.tiles.pipes.TilePipe;
import com.thesledgehammer.groovymc.blocks.properties.GroovyMachineProperties;
import com.thesledgehammer.groovymc.blocks.properties.IBlockType;
import com.thesledgehammer.groovymc.blocks.properties.MachinePropertyTraits;

public enum EnumPipeType implements IBlockType {
    RF_PIPE(createPipeProperties(RFPipe.class, "rf_pipe"));

    private final MachinePropertyTraits<?> machinePropertyTraits;

    EnumPipeType(MachinePropertyTraits machinePropertyTraits) {
        this.machinePropertyTraits = machinePropertyTraits;
    }

    protected static MachinePropertyTraits<?> createPipeProperties(Class<? extends TilePipe> teClass, String name) {
        MachinePropertyTraits<? extends TilePipe> machinePropertiesPipe = new GroovyMachineProperties<>(teClass, name);
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
