package com.thesledgehammer.emcengines.compat;

import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;

public class TOPCompat {

    public static void registerProviders() {
        ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
        oneProbe.registerProvider(new EMCProbeInfoProvider());
    }
/*
    public static class GetTheOneProbe implements Function<ITheOneProbe, Void> {

        public static ITheOneProbe probe;

        @Nullable
        @Override
        public Void apply(@Nullable ITheOneProbe theOneProbe) {
            probe = theOneProbe;
            registerProviders();
            probe.registerProvider(new EMCProbeInfoProvider());
            probe.registerProvider(new IProbeInfoProvider() {

                @Override
                public String getID() {
                    return "emcengines:default";
                }

                @Override
                public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
                    if (blockState.getBlock() instanceof IProbeInfoProvider) {
                        TopInfoProvider provider = (TopInfoProvider) blockState.getBlock();
                        provider.addProbeInfo(mode, probeInfo, player, world, blockState, data);
                    }
                }
            });
            return null;
        }
    }*/
}
