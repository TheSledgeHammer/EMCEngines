package com.thesledgehammer.emcengines.compat;

import com.thesledgehammer.emcengines.EMCEngines;
import com.thesledgehammer.groovymc.experimental.integration.modules.theoneprobe.EnumColorType;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

        if(EMCTools.isEmcEnergyHandler(te)) {
            long energy = EMCTools.getEmcStored(te);
            long capacity = EMCTools.getEmcCapacity(te);
            addEMCInfo(probeInfo, energy, capacity);
        }
    }

    private void addEMCInfo(IProbeInfo probeInfo, long energy, long capacity) {
        probeInfo.progress(energy, capacity, probeInfo.defaultProgressStyle()
                .suffix(" EMC")
                .filledColor(EnumColorType.FE.getFilledColor())
                .alternateFilledColor(0xff430000)
                .borderColor(0xff555555)
                .backgroundColor(EnumColorType.FE.getBackgroundColor())
                .numberFormat(NumberFormat.COMPACT)
        );
    }
}
