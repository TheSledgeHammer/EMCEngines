package com.thesledgehammer.emcengines;

import com.thesledgehammer.emcengines.blocks.*;
import com.thesledgehammer.emcengines.tiles.pipes.TilePipeFE;
import com.thesledgehammer.groovymc.items.GroovyItemBlock;
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

    public static BlockEngine emcEngineMK1;
    public static BlockEngine emcEngineMK2;
    public static BlockEngine emcEngineMK3;
    public static BlockEngine emcEngineMK1x8;
    public static BlockEngine emcEngineMK2x8;
    public static BlockEngine emcEngineMK3x8;
    public static BlockEngine emcEngineMK1x64;
    public static BlockEngine emcEngineMK2x64;
    public static BlockEngine emcEngineMK3x64;

    public static BlockEngine emcEngineMJ;

    public static BlockPipeFE fePipe;
    public static BlockPipeMJ lvPipe;
    public static BlockPipeMJ mvPipe;
    public static BlockPipeMJ hvPipe;
    public static BlockPipeMJ uvPipe;
    public static BlockPipeMJ svPipe;
    public static BlockPipeMJ evPipe;
    public static BlockPipeMJ ivPipe;
    public static BlockPipeMJ infinivPipe;

    public static BlockConverter feLvConverter;
    public static BlockConverter feMvConverter;
    public static BlockConverter feHvConverter;
    public static BlockConverter feUvConverter;
    public static BlockConverter feSvConverter;
    public static BlockConverter feEvConverter;
    public static BlockConverter feIvConverter;
    public static BlockConverter feInfinivConverter;

    public static void init() {
        initPipes();
        initConverters();

        emcEngineMK1 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK1);
        registerBlock(emcEngineMK1, new GroovyItemBlock<>(emcEngineMK1), "engine_mk1");
        emcEngineMK1.registerAdvancedTileEntity();
    /*
        emcEngineMK2 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK2);
        registerBlock(emcEngineMK2, new GroovyItemBlock<>(emcEngineMK2), "emc_engine_mk2");
        emcEngineMK2.registerAdvancedTileEntity();

        emcEngineMK3 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK3);
        registerBlock(emcEngineMK3, new GroovyItemBlock<>(emcEngineMK3), "emc_engine_mk3");
        emcEngineMK3.registerAdvancedTileEntity();

        emcEngineMK1x8 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK1_x8);
        registerBlock(emcEngineMK1x8, new GroovyItemBlock<>(emcEngineMK1x8), "emc_engine_mk1x8");
        emcEngineMK1x8.registerAdvancedTileEntity();

        emcEngineMK2x8 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK2_x8);
        registerBlock(emcEngineMK2x8, new GroovyItemBlock<>(emcEngineMK2x8), "emc_engine_mk2x8");
        emcEngineMK2x8.registerAdvancedTileEntity();

        emcEngineMK3x8 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK3_x8);
        registerBlock(emcEngineMK3x8, new GroovyItemBlock<>(emcEngineMK3x8), "emc_engine_mk3x8");
        emcEngineMK3x8.registerAdvancedTileEntity();

        emcEngineMK1x64 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK1_x64);
        registerBlock(emcEngineMK1x64, new GroovyItemBlock<>(emcEngineMK1x64), "emc_engine_mk1x64");
        emcEngineMK1x64.registerAdvancedTileEntity();

        emcEngineMK2x64 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK2_x64);
        registerBlock(emcEngineMK2x64, new GroovyItemBlock<>(emcEngineMK2x64), "emc_engine_mk2x64");
        emcEngineMK2x64.registerAdvancedTileEntity();

        emcEngineMK3x64 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK3_x64);
        registerBlock(emcEngineMK3x64, new GroovyItemBlock<>(emcEngineMK3x64), "emc_engine_mk3x64");
        emcEngineMK3x64.registerAdvancedTileEntity();
 */
        emcEngineMJ = new BlockEngine(EnumEngineType.EMC_ENGINE_MJ);
        registerBlock(emcEngineMJ, new GroovyItemBlock<>(emcEngineMJ), "mj_engine");
        emcEngineMJ.registerAdvancedTileEntity();
    }

    private static void initPipes() {
        fePipe = new BlockPipeFE();
        registerBlock(fePipe, new GroovyItemBlock<>(fePipe), "fe_pipe");
        fePipe.registerTileEntity(TilePipeFE.class, "fe_pipe");

        lvPipe = new BlockPipeMJ(EnumPipeType.LV_PIPE);
        registerBlock(lvPipe, new GroovyItemBlock<>(lvPipe), "lv_pipe");
        lvPipe.registerAdvancedTileEntity();

        mvPipe = new BlockPipeMJ(EnumPipeType.MV_PIPE);
        registerBlock(mvPipe, new GroovyItemBlock<>(mvPipe), "mv_pipe");
        mvPipe.registerAdvancedTileEntity();

        hvPipe = new BlockPipeMJ(EnumPipeType.HV_PIPE);
        registerBlock(hvPipe, new GroovyItemBlock<>(hvPipe), "hv_pipe");
        hvPipe.registerAdvancedTileEntity();

        uvPipe = new BlockPipeMJ(EnumPipeType.UV_PIPE);
        registerBlock(uvPipe, new GroovyItemBlock<>(uvPipe), "uv_pipe");
        uvPipe.registerAdvancedTileEntity();

        svPipe = new BlockPipeMJ(EnumPipeType.SV_PIPE);
        registerBlock(svPipe, new GroovyItemBlock<>(svPipe), "sv_pipe");
        svPipe.registerAdvancedTileEntity();

        evPipe = new BlockPipeMJ(EnumPipeType.EV_PIPE);
        registerBlock(evPipe, new GroovyItemBlock<>(evPipe), "ev_pipe");
        evPipe.registerAdvancedTileEntity();

        ivPipe = new BlockPipeMJ(EnumPipeType.IV_PIPE);
        registerBlock(ivPipe, new GroovyItemBlock<>(ivPipe), "iv_pipe");
        ivPipe.registerAdvancedTileEntity();

        infinivPipe = new BlockPipeMJ(EnumPipeType.INFINIV_PIPE);
        registerBlock(infinivPipe, new GroovyItemBlock<>(infinivPipe), "infiniv_pipe");
        infinivPipe.registerAdvancedTileEntity();
    }

    private static void initConverters() {
        feLvConverter = new BlockConverter(EnumConverterType.FE_LV_CONVERTER);
        registerBlock(feLvConverter, new GroovyItemBlock<>(feLvConverter), "fe_lv_converter");
        feLvConverter.registerAdvancedTileEntity();

        feMvConverter = new BlockConverter(EnumConverterType.FE_MV_CONVERTER);
        registerBlock(feMvConverter, new GroovyItemBlock<>(feMvConverter), "fe_mv_converter");
        feMvConverter.registerAdvancedTileEntity();

        feHvConverter = new BlockConverter(EnumConverterType.FE_HV_CONVERTER);
        registerBlock(feHvConverter, new GroovyItemBlock<>(feHvConverter), "fe_hv_converter");
        feHvConverter.registerAdvancedTileEntity();

        feUvConverter = new BlockConverter(EnumConverterType.FE_UV_CONVERTER);
        registerBlock(feUvConverter, new GroovyItemBlock<>(feUvConverter), "fe_uv_converter");
        feUvConverter.registerAdvancedTileEntity();

        feSvConverter = new BlockConverter(EnumConverterType.FE_SV_CONVERTER);
        registerBlock(feSvConverter, new GroovyItemBlock<>(feSvConverter), "fe_sv_converter");
        feSvConverter.registerAdvancedTileEntity();

        feEvConverter = new BlockConverter(EnumConverterType.FE_EV_CONVERTER);
        registerBlock(feEvConverter, new GroovyItemBlock<>(feEvConverter), "fe_ev_converter");
        feEvConverter.registerAdvancedTileEntity();

        feIvConverter = new BlockConverter(EnumConverterType.FE_IV_CONVERTER);
        registerBlock(feIvConverter, new GroovyItemBlock<>(feIvConverter), "fe_iv_converter");
        feIvConverter.registerAdvancedTileEntity();

        feInfinivConverter = new BlockConverter(EnumConverterType.FE_INFINIV_CONVERTER);
        registerBlock(feInfinivConverter, new GroovyItemBlock<>(feInfinivConverter), "fe_infiniv_converter");
        feInfinivConverter.registerAdvancedTileEntity();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
       // emcEngineMK1.initModel();
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
