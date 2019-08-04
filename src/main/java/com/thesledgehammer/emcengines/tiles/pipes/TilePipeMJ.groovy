package com.thesledgehammer.emcengines.tiles.pipes

import buildcraft.api.mj.MjAPI
import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage
import com.thesledgehammer.groovymc.api.minecraftjoules.MjTools
import com.thesledgehammer.groovymc.integration.minecraftjoules.MinecraftJoulesTile
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraft.util.ITickable

class TilePipeMJ extends MinecraftJoulesTile implements ITickable{

    TilePipeMJ() {
        super(5120 * MjTools.MJ, 1024 * MjTools.MJ)
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
                if(tile.hasCapability(CapabilityMj.MJ_STORAGE, facing) || tile.hasCapability(MjAPI.CAP_CONNECTOR, facing)) {
                    IMjStorage extractMj = tile.getCapability(CapabilityMj.MJ_STORAGE, facing.getOpposite());
                    if(extractMj != null && extractMj.getStored() > 0) {
                        long toReceive = extractMj.extractPower(0, mj.getMaxReceive(), true);
                        mj.generatePower(receivePower(toReceive, false));
                    }
                    IMjStorage insertMj = tile.getCapability(CapabilityMj.MJ_STORAGE, facing);
                    if(insertMj != null && getStored() > 0) {
                        long toExtract = extractPower(0, mj.getMaxExtract(), true);
                        mj.drainPower(insertMj.receivePower(toExtract, false));
                    }
                }
            }
        }
    }
}
