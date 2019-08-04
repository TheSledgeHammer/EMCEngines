package com.thesledgehammer.emcengines.compat;

import com.thesledgehammer.emcengines.EMCEngines;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.awt.*;

public class EMCProbeInfoProvider implements IProbeInfoProvider {

    @Override
    public String getID() {
        return EMCEngines.MOD_ID + ":emcprobe";
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
        BlockPos pos = data.getPos();
        TileEntity te = world.getTileEntity(pos);

        if(EMCTools.isMjEnergyHandler(te)) {
            long energy = EMCTools.getMjStored(te);
            long capacity = EMCTools.getMjCapacity(te);
            addMJInfo(probeInfo, energy, capacity);
        }

        if(EMCTools.isEmcEnergyHandler(te)) {
            long energy = EMCTools.getEmcStored(te);
            long capacity = EMCTools.getEmcCapacity(te);
            addEMCInfo(probeInfo, energy, capacity);
        }
    }

    private void addEMCInfo(IProbeInfo probeInfo, long energy, long capacity) {
        probeInfo.progress(energy, capacity,
                probeInfo.defaultProgressStyle()
                        .suffix("EMC")
                        .filledColor(new Color(0x470E51).getRGB())
                        .alternateFilledColor(new Color(0xC60310).getRGB())
                        .borderColor(new Color(0xff555555).getRGB())
                        .backgroundColor(new Color(0x000000).getRGB())
                        .numberFormat(NumberFormat.COMPACT)
        );
    }

    private static void addMJInfo(IProbeInfo probeInfo, long energy, long capacity) {
        probeInfo.progress(energy, capacity, probeInfo.defaultProgressStyle()
                .suffix("MJ")
                .filledColor(new Color(0x00CD66).getRGB())
                .alternateFilledColor(new Color(0x009A33).getRGB())
                .borderColor(new Color(0xff555555).getRGB())
                .backgroundColor(new Color(0x000000).getRGB())
                .numberFormat(NumberFormat.COMPACT)
        );
    }
}
