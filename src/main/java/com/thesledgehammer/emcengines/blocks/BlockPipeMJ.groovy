package com.thesledgehammer.emcengines.blocks

import com.thesledgehammer.emcengines.tiles.pipes.TilePipeMJ
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileBasic
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

class BlockPipeMJ extends GroovyBlockTileBasic {

    BlockPipeMJ() {
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TilePipeMJ();
    }
}
