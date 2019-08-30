package com.thesledgehammer.emcengines.blocks;

import com.thesledgehammer.emcengines.tiles.TileRFInverter;
import com.thesledgehammer.groovymc.api.EnumEnergyType;
import com.thesledgehammer.groovymc.blocks.GroovyBlockTileMeta;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
//TODO: Fix Name
public class BlockInverter extends GroovyBlockTileMeta {

    private static final PropertyEnum<EnumEnergyType> TIER = PropertyEnum.create("tier", EnumEnergyType.class);

    public BlockInverter() {
        super(Material.IRON);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.MISC);
        setDefaultState(this.getBlockState().getBaseState().withProperty(TIER, EnumEnergyType.LV));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileRFInverter(EnumEnergyType.values()[meta]);
    }

    @Override
    public String getNameFromMeta(int i) {
        return EnumEnergyType.values()[i].getName();
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecated")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TIER, EnumEnergyType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TIER).ordinal();
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TIER);
    }
}
