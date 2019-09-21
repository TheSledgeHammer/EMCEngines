package com.thesledgehammer.emcengines.tiles.engines;

import com.thesledgehammer.groovymc.compat.forgeenergy.ForgeEnergyTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TileFEEngine extends ForgeEnergyTile implements ITickable {

    public TileFEEngine(int capacity, int maxTransfer) {
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
                if(tile.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                    IEnergyStorage feTile = tile.getCapability(CapabilityEnergy.ENERGY, facing);
                    if(feTile != null) {
                        if(canReceive()) {
                            fe.drainEnergy(feTile.receiveEnergy(fe.getMaxReceive(), false));
                        }
                    }
                }
            }
        }
    }
}
