package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.powercell.TilePowerCell;
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileBasic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockPowerCell extends GroovyBlockTileBasic {

    public BlockPowerCell() {
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TilePowerCell();
    }
}
