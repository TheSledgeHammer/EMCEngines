package com.thesledgehammer.emcengines.compat;

import moze_intel.projecte.api.tile.IEmcStorage;
import net.minecraft.tileentity.TileEntity;

public class EMCTools {

    public static long getEmcStored(TileEntity te) {
        IEmcStorage handler = (IEmcStorage) te;
        return handler.getStoredEmc();
    }

    public static long getEmcCapacity(TileEntity te) {
        IEmcStorage handler = (IEmcStorage) te;
        return handler.getMaximumEmc();
    }

    public static boolean isEmcEnergyHandler(TileEntity te) {
        return te instanceof IEmcStorage;
    }
}
