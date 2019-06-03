package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.groovymc.blocks.GroovyBlockTileAdvanced;
import net.minecraft.creativetab.CreativeTabs;

public class BlockEngine extends GroovyBlockTileAdvanced<EnumEngineType> {

    public BlockEngine(EnumEngineType blockType) {
        super(blockType);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }
}
