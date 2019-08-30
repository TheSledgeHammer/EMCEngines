package com.thesledgehammer.emcengines.tiles.powercell;

import com.thesledgehammer.emcengines.Constants;
import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj;
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage;
import com.thesledgehammer.groovymc.compat.minecraftjoules.MinecraftJoulesTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TilePowerCell extends MinecraftJoulesTile implements ITickable {

    //private String tileName;
    private long capacity = 1_000_000;

    public TilePowerCell() {
        super(Constants.toMJ(1_000_000), Constants.toMJ(1_000));
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
                    IMjStorage extractMj = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing.getOpposite());
                    if(extractMj != null && extractMj.getStored() > 0) {
                        long toReceive = extractMj.extractPower(0, mj.getMaxReceive(), true);
                        if(canReceive() && toReceive > 0) {
                            mj.generatePower(receivePower(toReceive, false));
                        }
                    }
                    IMjStorage insertMj = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing);
                    if(insertMj != null && getStored() > 0) {
                        long toExtract = extractPower(0, mj.getMaxExtract(), true);
                        if(canExtract() && toExtract > 0) {
                            mj.drainPower(insertMj.receivePower(toExtract, false));
                        }
                    }
                }
            }
        }
    }
}
