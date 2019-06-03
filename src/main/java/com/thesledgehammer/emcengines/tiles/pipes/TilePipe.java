package com.thesledgehammer.emcengines.tiles.pipes;

import com.thesledgehammer.groovymc.energy.ForgeEnergyTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TilePipe extends ForgeEnergyTile implements ITickable {

    public TilePipe(String tileName, int feCapacity, int feTransfer) {
        super(tileName, feCapacity, feTransfer);
    }

    @Override
    public void update() {
        if(world.isRemote) {
            return;
        }

        for(EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            if (tile == null) {
                return;
            } else {
                if(tile instanceof TilePipe) {
                    TilePipe pipeTile = (TilePipe) tile;
                    if(tile.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                        int toExtract = Math.min(fe.getMaxExtract(), getMaxEnergyStored() - getEnergyStored());
                        int move = 0;
                        if (pipeTile.canReceive()) {
                            move = pipeTile.receiveEnergy(toExtract, false);
                        }
                        extractEnergy(move, false);
                        IEnergyStorage other = tile.getCapability(CapabilityEnergy.ENERGY, facing);
                        int drain = 0;
                        if(other != null && pipeTile.receiveEnergy(toExtract, true) > 0) {
                            drain = other.receiveEnergy(toExtract, false);
                        }
                        extractEnergy(drain, false);
                        fe.modifyEnergyStored(extractEnergy(drain, false));
                    }
                }
            }
        }
    }
}
/*
                if(tile.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                        IEnergyStorage other = tile.getCapability(CapabilityEnergy.ENERGY, facing);
                        int toExtract = Math.min(fe.getMaxExtract(), getMaxEnergyStored() - getEnergyStored());
                        int move = 0;
                        if (other != null) {
                        move = other.receiveEnergy(toExtract, false);
                        }
                        extractEnergy(move, false);
                        fe.modifyEnergyStored(extractEnergy(move, false));
                        }
                */