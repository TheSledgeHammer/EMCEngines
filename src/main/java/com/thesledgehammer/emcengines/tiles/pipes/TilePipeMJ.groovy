package com.thesledgehammer.emcengines.tiles.pipes

import com.thesledgehammer.emcengines.blocks.EnumPipeType
import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage
import com.thesledgehammer.groovymc.compat.minecraftjoules.MinecraftJoulesTile
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraft.util.ITickable

class TilePipeMJ extends MinecraftJoulesTile implements ITickable {

    TilePipeMJ(EnumPipeType pipeType) {
        super(pipeType.getCapacity(), pipeType.getMaxTransfer());
    }

    @Override
    void update() {
        if(world.isRemote) {
            return;
        }
        for(EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            if(tile == null) {
                continue;
            } else if(tile != null) {
                //Basic Pipe Energy Transfer: Tweaks in future
                if(tile.hasCapability(CapabilityMj.MJ_STORAGE, facing)) {
                    IMjStorage extractMj = tile.getCapability(CapabilityMj.MJ_STORAGE, facing.getOpposite());
                    if(extractMj != null && extractMj.getStored() > 0) {
                        long toReceive = extractMj.extractPower(0, mj.getMaxReceive(), true);
                        if(toReceive > 0) {
                            mj.generatePower(receivePower(toReceive, false));
                        }
                    }

                    IMjStorage insertMj = tile.getCapability(CapabilityMj.MJ_STORAGE, facing);
                    if(insertMj != null && getStored() > 0) {
                        long toExtract = extractPower(0, mj.getMaxExtract(), true);
                        if(toExtract > 0) {
                            mj.drainPower(insertMj.receivePower(toExtract, false));
                        }
                    }
                }
            }
        }
    }
}
