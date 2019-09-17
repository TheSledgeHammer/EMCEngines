package com.thesledgehammer.emcengines.controller;

import com.thesledgehammer.groovymc.tiles.GroovyTileBasic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class ControllerTile extends GroovyTileBasic implements ITickable {

    private EnergyFlow pipeBlock;
    ControllerTile(EnergyFlow pipeBlock) {
        this.pipeBlock = pipeBlock;
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
                this.pipeBlock.transferFEOnTick(tile, facing);

            }
        }
    }
}
