package com.thesledgehammer.emcengines.tiles.engines;

import buildcraft.api.mj.MjAPI;
import com.thesledgehammer.groovymc.api.minecraftjoules.CapabilityMj;
import com.thesledgehammer.groovymc.api.minecraftjoules.IMjStorage;
import com.thesledgehammer.groovymc.api.minecraftjoules.MjTools;
import moze_intel.projecte.api.tile.IEmcProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEmcEngineMJBase extends TileEmcMJ implements ITickable {

    public TileEmcEngineMJBase(String tileName, long mjCapacity, long mjTransfer, long maximumEmc, long emcCharge) {
        super(tileName, mjCapacity, mjTransfer, maximumEmc, emcCharge);
    }

    @Override
    public void update() {

        if(world.isRemote) {
            return;
        }

        long emcExtract = Math.min(getStoredEmc(), getEmcMaxExtract());
        long mjOut = emcExtract * MjTools.getMJ();

        for(EnumFacing facing : EnumFacing.VALUES) {
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            TileEntity other = world.getTileEntity(pos.offset(facing));
            if(tile == null || other == null) {
                continue;
            } else if(tile instanceof IEmcProvider) {
                IEmcProvider emcTile = (IEmcProvider) tile;
                if(emcTile.getStoredEmc() > 0) {
                    emcManager.drainEMC(emcTile.provideEMC(facing, emcExtract));
                    mj.generatePower(mjOut);
                }
            } else if(other.hasCapability(CapabilityMj.getMJ_STORAGE(), facing) || other.hasCapability(MjAPI.CAP_CONNECTOR, facing)) {
                IMjStorage energyTile = other.getCapability(CapabilityMj.getMJ_STORAGE(), facing);
                if(energyTile != null) {
                    mj.drainPower(energyTile.receivePower(mjOut, false));
                }
            }
        }
    }
}
//To Fix, is Weird when next to collectors, on both Mj & Rf Base