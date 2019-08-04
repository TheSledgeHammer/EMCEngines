package com.thesledgehammer.emcengines.blocks

import com.thesledgehammer.emcengines.tiles.pipes.TilePipeFE
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileBasic
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

class BlockPipeFE extends GroovyBlockTileBasic {

    BlockPipeFE() {
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TilePipeFE();
    }
}
