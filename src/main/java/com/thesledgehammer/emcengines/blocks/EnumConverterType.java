package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.converters.*;
import com.thesledgehammer.groovymc.blocks.properties.GroovyMachineProperties;
import com.thesledgehammer.groovymc.blocks.properties.IBlockType;
import com.thesledgehammer.groovymc.blocks.properties.MachinePropertyTraits;

public enum EnumConverterType implements IBlockType {
    FE_LV_CONVERTER(createRFConverterProperties(TileRFConverterLV.class, "fe_lv_converter")),
    FE_MV_CONVERTER(createRFConverterProperties(TileRFConverterMV.class, "fe_mv_converter")),
    FE_HV_CONVERTER(createRFConverterProperties(TileRFConverterHV.class, "fe_hv_converter")),
    FE_UV_CONVERTER(createRFConverterProperties(TileRFConverterUV.class, "fe_uv_converter")),
    FE_SV_CONVERTER(createRFConverterProperties(TileRFConverterSV.class, "fe_sv_converter")),
    FE_EV_CONVERTER(createRFConverterProperties(TileRFConverterEV.class, "fe_ev_converter")),
    FE_IV_CONVERTER(createRFConverterProperties(TileRFConverterIV.class, "fe_iv_converter")),
    FE_INFINIV_CONVERTER(createRFConverterProperties(TileRFConverterInfiniV.class, "fe_infiniv_converter"));

    private final MachinePropertyTraits<?> machinePropertyTraits;

    EnumConverterType(MachinePropertyTraits machinePropertyTraits) {
        this.machinePropertyTraits = machinePropertyTraits;
    }

    protected static MachinePropertyTraits<?> createRFConverterProperties(Class<? extends RFConverterTile> teClass, String name) {
        MachinePropertyTraits<? extends RFConverterTile> machinePropertiesRFConverter = new GroovyMachineProperties<>(teClass, name);
        return machinePropertiesRFConverter;
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
