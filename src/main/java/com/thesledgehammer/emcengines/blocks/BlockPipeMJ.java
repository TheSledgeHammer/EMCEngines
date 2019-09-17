package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.pipes.TilePipeMJ;
import com.thesledgehammer.groovymc.api.EnumVoltage;
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileMeta;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Objects;

public class BlockPipeMJ extends GroovyBlockTileMeta {

    private static final PropertyEnum<EnumVoltage> MJ_PIPES = PropertyEnum.create("mj_pipes", EnumVoltage.class);

    public BlockPipeMJ() {
        super(Material.IRON);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
        setDefaultState(this.getBlockState().getBaseState().withProperty(MJ_PIPES, EnumVoltage.LOW));
    }

    @Override
    public String getNameFromMeta(int i) {
        return EnumVoltage.values()[i].getName();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(MJ_PIPES).ordinal();
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(MJ_PIPES, EnumVoltage.values()[meta]);
    }

    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return new TilePipeMJ(EnumVoltage.values()[meta]);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MJ_PIPES);
    }

    @Override
    @Nonnull
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel() {
        for(EnumVoltage pipeType : EnumVoltage.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), pipeType.ordinal(), new ModelResourceLocation(Objects.requireNonNull(getRegistryName()), "inventory"));
        }
    }
}
