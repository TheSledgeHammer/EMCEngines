package com.thesledgehammer.emcengines;

import com.thesledgehammer.emcengines.blocks.*;
import com.thesledgehammer.emcengines.tiles.TileRFConverter;
import com.thesledgehammer.emcengines.tiles.TileRFInverter;
import com.thesledgehammer.emcengines.tiles.engines.TileCreativeEngine;
import com.thesledgehammer.emcengines.tiles.pipes.TilePipeFE;
import com.thesledgehammer.emcengines.tiles.pipes.TilePipeMJ;
import com.thesledgehammer.emcengines.tiles.powercell.TilePowerCell;
import com.thesledgehammer.groovymc.items.GroovyItemBlock;
import com.thesledgehammer.groovymc.utils.TileEntityTools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;

public class ModBlocks {

    public static BlockEngine creativeEngine;

    public static BlockEmcEngine emcEngineMJ;

    public static BlockPipeFE fePipe;
    public static BlockPipeMJ mjPipe;

    public static BlockConverter converter;
    public static BlockInverter inverter;
    public static BlockPowerCell powerCell;

    public static void init() {

        converter = new BlockConverter();
        registerBlock(converter, new GroovyItemBlock<>(converter), "converter");
        TileEntityTools.registerTileEntity(TileRFConverter.class, "converter");

        inverter = new BlockInverter();
        registerBlock(inverter, new GroovyItemBlock<>(inverter), "inverter");
        TileEntityTools.registerTileEntity(TileRFInverter.class, "inverter");

        fePipe = new BlockPipeFE();
        registerBlock(fePipe, new GroovyItemBlock<>(fePipe), "fe_pipes");
        TileEntityTools.registerTileEntity(TilePipeFE.class, "fe_pipes");

        mjPipe = new BlockPipeMJ();
        registerBlock(mjPipe, new GroovyItemBlock<>(mjPipe), "mj_pipes");
        TileEntityTools.registerTileEntity(TilePipeMJ.class, "mj_pipes");

        emcEngineMJ = new BlockEmcEngine(EnumEmcEngineType.EMC_ENGINE_MJ);
        registerBlock(emcEngineMJ, new GroovyItemBlock<>(emcEngineMJ), "mj_engine");
        emcEngineMJ.registerAdvancedTileEntity();

        creativeEngine = new BlockEngine();
        registerBlock(creativeEngine, new GroovyItemBlock<>(creativeEngine), "creative_engine");
        TileEntityTools.registerTileEntity(TileCreativeEngine.class, "creative_engine");

        powerCell = new BlockPowerCell();
        registerBlock(powerCell, new GroovyItemBlock<>(powerCell), "powercell");
        TileEntityTools.registerTileEntity(TilePowerCell.class, "powercell");
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

    }

    private static <T extends Item> T registerItem(T item, String name) {
        item.setUnlocalizedName(name);
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        EMCEngines.registerItem(item);
        return item;
    }

    private static <T extends Block> T registerBlock(T block, @Nullable ItemBlock itemBlock, String name) {
        block.setUnlocalizedName(name);
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        EMCEngines.registerBlock(block);

        if(itemBlock != null) {
            itemBlock.setRegistryName(name);
            ForgeRegistries.ITEMS.register(itemBlock);
            EMCEngines.registerItem(itemBlock);
        }
        return block;
    }

    private static <T extends Block> T registerBlock(T block, String name) {
        return registerBlock(block, new GroovyItemBlock<>(block), name);
    }

    private static void registerOreDictWildcard(String oreDictName, Block block) {
        OreDictionary.registerOre(oreDictName, new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
    }
}
