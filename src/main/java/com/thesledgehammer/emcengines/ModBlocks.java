package com.thesledgehammer.emcengines;

import com.thesledgehammer.emcengines.blocks.BlockEngine;
import com.thesledgehammer.emcengines.blocks.BlockPipe;
import com.thesledgehammer.emcengines.blocks.EnumEngineType;
import com.thesledgehammer.emcengines.blocks.EnumPipeType;
import com.thesledgehammer.groovymc.items.GroovyItemBlock;
import net.minecraft.block.Block;
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
    public static BlockPipe rfPipe;

    public static BlockEngine emcEngineMJ;

    public static void init() {

        emcEngineMK1 = new BlockEngine(EnumEngineType.EMC_ENGINE_MK1);
        registerBlock(emcEngineMK1, new GroovyItemBlock<>(emcEngineMK1), "emc_engine_mk1");
        emcEngineMK1.registerAdvancedTileEntity();

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

        emcEngineMJ = new BlockEngine(EnumEngineType.EMC_ENGINE_MJ);
        registerBlock(emcEngineMJ, new GroovyItemBlock<>(emcEngineMJ), "emc_engine_mj");
        emcEngineMJ.registerAdvancedTileEntity();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

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
