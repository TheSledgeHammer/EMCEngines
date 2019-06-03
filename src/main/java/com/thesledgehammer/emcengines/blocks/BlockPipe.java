package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.groovymc.blocks.GroovyBlockTileAdvanced;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPipe extends GroovyBlockTileAdvanced<EnumPipeType> {

    public BlockPipe(EnumPipeType blockType) {
        super(blockType);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }
}