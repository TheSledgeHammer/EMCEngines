package com.thesledgehammer.emcengines.tiles.pipes

import com.thesledgehammer.emcengines.blocks.FEPipeType
import com.thesledgehammer.groovymc.compat.forgeenergy.ForgeEnergyTile
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraft.util.ITickable
import net.minecraftforge.energy.CapabilityEnergy
import net.minecraftforge.energy.IEnergyStorage

class TilePipeFE extends ForgeEnergyTile implements ITickable {

    TilePipeFE(FEPipeType pipeType) {
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
                if(tile.hasCapability(CapabilityEnergy.ENERGY, facing)) {
                    IEnergyStorage extractFe = tile.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
                    if(extractFe != null && extractFe.getEnergyStored() > 0) {
                        int toReceive = extractFe.extractEnergy(fe.getMaxReceive(), true);
                        fe.generateEnergy(receiveEnergy(toReceive, false));
                    }
                    IEnergyStorage insertFe = tile.getCapability(CapabilityEnergy.ENERGY, facing);
                    if(insertFe != null && getEnergyStored() > 0) {
                        int toExtract = extractEnergy(fe.getMaxExtract(), true);
                        fe.drainEnergy(insertFe.receiveEnergy(toExtract, false));
                    }
                }
            }
        }
    }
}
