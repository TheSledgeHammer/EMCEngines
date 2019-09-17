package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.groovymc.api.EnergyConfig;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj;
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage;
import com.thesledgehammer.groovymc.compat.minecraftjoules.MinecraftJoulesTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TilePipeMJ extends MinecraftJoulesTile implements ITickable {

    public TilePipeMJ(EnumVoltage pipeType) {
        super(EnergyConfig.createMJConfig(pipeType.getVoltage()).getCapacity(), EnergyConfig.createMJConfig(pipeType.getVoltage()).getMaxExtract());
    }

    @Override
    public void update() {
        if (getWorld().isRemote) {
            return;
        }

        for (EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = getWorld().getTileEntity(getPos().offset(facing));
            if (tile == null) {
                continue;
            } else if (tile != null) {
                //Basic Pipe Energy Transfer: Tweaks in future
                if (tile.hasCapability(CapabilityMj.getMJ_STORAGE(), facing)) {
                    IMjStorage extractMj = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing.getOpposite());
                    if (extractMj != null && extractMj.getStored() > 0) {
                        long toReceive = extractMj.extractPower(0, mj.getMaxReceive(), true);
                        if (canReceive() && toReceive > 0) {
                            mj.generatePower(receivePower(toReceive, false));
                        }

                    }


                    IMjStorage insertMj = tile.getCapability(CapabilityMj.getMJ_STORAGE(), facing);
                    if (insertMj != null && getStored() > 0) {
                        long toExtract = extractPower(0, mj.getMaxExtract(), true);
                        if (canExtract() && toExtract > 0) {
                            mj.drainPower(insertMj.receivePower(toExtract, false));
                        }
                    }
                }
            }
        }
    }
}
