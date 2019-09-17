package com.thesledgehammer.emcengines.compat;

import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;

public class TOPCompat {

    public static void registerProviders() {
        ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
        oneProbe.registerProvider(new EMCProbeInfoProvider());
    }
}
