package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj;
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage;
import com.thesledgehammer.groovymc.compat.minecraftjoules.MinecraftJoulesTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileCreativeEngine extends MinecraftJoulesTile implements ITickable {

    public TileCreativeEngine() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void update() {
        if(world.isRemote) {
            return;
        }
        for(EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            if (tile == null) {
                continue;
            } else if (tile != null) {
                if(tile.hasCapability(CapabilityMj.getMJ_STORAGE(), facing)) {
                    IMjStorage mjTile = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing);
                    if(mjTile != null) {
                        if(canReceive()) {
                            mj.drainPower(mjTile.receivePower(mj.getMaxReceive(), false));
                        }
                    }
                }
            }
        }
    }
}
