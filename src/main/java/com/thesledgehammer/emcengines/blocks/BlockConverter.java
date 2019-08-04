package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.groovymc.blocks.GroovyBlockTileAdvanced;
import net.minecraft.creativetab.CreativeTabs;

public class BlockConverter extends GroovyBlockTileAdvanced<EnumConverterType> {

    public BlockConverter(EnumConverterType blockType) {
        super(blockType);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }
}
