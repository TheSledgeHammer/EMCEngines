package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.pipes.TilePipeFE;
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileMeta;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockPipeFE extends GroovyBlockTileMeta {

    private static final PropertyEnum<FEPipeType> FE_PIPES = PropertyEnum.create("fe_pipes", FEPipeType.class);

    public BlockPipeFE() {
        super(Material.IRON);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
        setDefaultState(this.getBlockState().getBaseState().withProperty(FE_PIPES, FEPipeType.LV_PIPE));
    }

    @Override
    public String getNameFromMeta(int i) {
        return FEPipeType.VALUES[i].getName();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FE_PIPES).getMeta();
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FE_PIPES, FEPipeType.VALUES[meta]);
    }

    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return new TilePipeFE(FEPipeType.VALUES[meta]);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FE_PIPES);
    }
}
