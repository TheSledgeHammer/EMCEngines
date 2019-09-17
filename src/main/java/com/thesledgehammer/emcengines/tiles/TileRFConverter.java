package com.thesledgehammer.emcengines.tiles;

import com.thesledgehammer.groovymc.api.EnumVoltage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileRFConverter extends TileRfMj implements ITickable {

    public TileRFConverter(EnumVoltage energyType) {
        super(energyType, 3);
    }

    @Override
    public void update() {
        if (world.isRemote) {
            return;
        }

        for (EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            if (tile == null) {
                continue;
            } else if (tile != null) {
                convert(facing, tile);
            }
        }
    }
}