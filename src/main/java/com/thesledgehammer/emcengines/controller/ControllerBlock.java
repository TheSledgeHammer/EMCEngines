package com.thesledgehammer.emcengines.controller;

import com.thesledgehammer.groovymc.blocks.GroovyBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.EnumMap;
import java.util.Objects;

public class ControllerBlock extends GroovyBlock {

    private static final AxisAlignedBB BOX_CENTER = new AxisAlignedBB(0.25, 0.25, 0.25, 0.75, 0.75, 0.75);
    private static final AxisAlignedBB BOX_DOWN = new AxisAlignedBB(0.25, 0, 0.25, 0.75, 0.25, 0.75);
    private static final AxisAlignedBB BOX_UP = new AxisAlignedBB(0.25, 0.75, 0.25, 0.75, 1, 0.75);
    private static final AxisAlignedBB BOX_NORTH = new AxisAlignedBB(0.25, 0.25, 0, 0.75, 0.75, 0.25);
    private static final AxisAlignedBB BOX_SOUTH = new AxisAlignedBB(0.25, 0.25, 0.75, 0.75, 0.75, 1);
    private static final AxisAlignedBB BOX_WEST = new AxisAlignedBB(0, 0.25, 0.25, 0.25, 0.75, 0.75);
    private static final AxisAlignedBB BOX_EAST = new AxisAlignedBB(0.75, 0.25, 0.25, 1, 0.75, 0.75);
    private static final AxisAlignedBB[] BOX_FACES = { BOX_DOWN, BOX_UP, BOX_NORTH, BOX_SOUTH, BOX_WEST, BOX_EAST };
    private EnumMap<EnumFacing, AxisAlignedBB> extendFace = new EnumMap<EnumFacing, AxisAlignedBB>(EnumFacing.class);

    public ControllerBlock() {
        super(Material.IRON);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(Objects.requireNonNull(getRegistryName()), "inventory"));
    }
/*
    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new ControllerTile(new EnergyFlow());
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        if(tile instanceof ControllerTile) {
            ControllerTile controllerTile = (ControllerTile) tile;
            setBoundingBox(controllerTile.getPos(), tile.getPos());
        }
        return super.getSelectedBoundingBox(state, world, pos);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, BOX_CENTER);
        if(!p_185477_7_) {
            state = state.getActualState(worldIn, pos);
        }
        for(EnumFacing facing : EnumFacing.VALUES) {
            AxisAlignedBB axisAlignedBB = extendFace.get(facing);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, axisAlignedBB);
        }
    }

    private void setBoundingBox(BlockPos minPos, BlockPos maxPos) {
        for(EnumFacing face : EnumFacing.VALUES) {
            extendFace.put(face, new AxisAlignedBB(minPos, maxPos.offset(face.getOpposite())));
        }
    }*/
}
