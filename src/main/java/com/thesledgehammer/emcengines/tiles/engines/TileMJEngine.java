package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj;
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage;
import com.thesledgehammer.groovymc.compat.minecraftjoules.MinecraftJoulesTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileMJEngine extends MinecraftJoulesTile implements ITickable {

    public TileMJEngine(long capacity, long maxTransfer) {
        super(capacity, maxTransfer);
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
