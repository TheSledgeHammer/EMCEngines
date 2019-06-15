package com.thesledgehammer.emcengines.compat;

import com.google.common.base.Function;
import com.thesledgehammer.groovymc.experimental.integration.modules.theoneprobe.ITheOneProbeInfoProvider;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.*;
import mcjty.theoneprobe.apiimpl.TheOneProbeImp;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TOPCompat {

    private static boolean registered;

    public static void register() {
        if(registered) {
            return;
        }
        registered = true;
        registerProviders();
    }

    private static void registerProviders() {
        TheOneProbeImp.registerElements();
        TheOneProbe.theOneProbeImp.registerProvider(new EMCProbeInfoProvider());
    }

    public static class GetTheOneProbe implements Function<ITheOneProbe, Void> {

        public static ITheOneProbe probe;

        @Nullable
        @Override
        public Void apply(@Nullable ITheOneProbe theOneProbe) {
            probe = theOneProbe;
            probe.registerProvider(new IProbeInfoProvider() {
                @Override
                public String getID() {
                    return "enginesemc:oneprobe";
                }

                @Override
                public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
                    if (blockState.getBlock() instanceof ITheOneProbeInfoProvider) {
                        ITheOneProbeInfoProvider provider = (ITheOneProbeInfoProvider) blockState.getBlock();
                        provider.addProbeInfo(mode, probeInfo, player, world, blockState, data);
                    }
                }
            });
            return null;
        }
    }
}
