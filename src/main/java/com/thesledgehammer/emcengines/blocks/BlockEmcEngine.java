package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.groovymc.blocks.GroovyBlockTileAdvanced;
import net.minecraft.creativetab.CreativeTabs;

public class BlockEmcEngine extends GroovyBlockTileAdvanced<EnumEmcEngineType> {

    public BlockEmcEngine(EnumEmcEngineType blockType) {
        super(blockType);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }
}
