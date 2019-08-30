package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.engines.TileCreativeEngine;
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileBasic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockEngine extends GroovyBlockTileBasic {

    public BlockEngine() {
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCreativeEngine();
    }
}
