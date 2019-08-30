package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.pipes.TilePipeMJ;
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileMeta;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
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

    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
    private static final PropertyEnum<EnumPipeType> MJ_PIPES = PropertyEnum.create("mj_pipes", EnumPipeType.class);

    public BlockPipeMJ() {
        super(Material.IRON);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
        setDefaultState(this.getBlockState().getBaseState().withProperty(MJ_PIPES, EnumPipeType.LV_PIPE));
    }

    @Override
    public String getNameFromMeta(int i) {
        return EnumPipeType.VALUES[i].getName();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(MJ_PIPES).getMeta();
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(MJ_PIPES, EnumPipeType.VALUES[meta]);
    }

    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return new TilePipeMJ(EnumPipeType.VALUES[meta]);
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
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Nonnull
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel() {
        for(EnumPipeType pipeType : EnumPipeType.VALUES) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), pipeType.getMeta(), new ModelResourceLocation(Objects.requireNonNull(getRegistryName()), "inventory"));
        }
    }

/*
    @Override
    @Nonnull
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        state = state.getActualState(source, pos);
        float minSize = 0.3125F;
        float maxSize =  0.6875F;

        float minX = state.getValue(WEST) ? 0.0F : minSize;
        float minY = state.getValue(DOWN) ? 0.0F : minSize;
        float minZ = state.getValue(NORTH) ? 0.0F : minSize;
        float maxX = state.getValue(EAST) ? 1.0F : maxSize;
        float maxY = state.getValue(UP) ? 1.0F : maxSize;
        float maxZ = state.getValue(SOUTH) ? 1.0F : maxSize;
        return new AxisAlignedBB((double) minX, (double) minY, (double) minZ, (double) maxX, (double) maxY, (double) maxZ);
    }*/
}
