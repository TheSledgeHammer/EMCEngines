package com.thesledgehammer.emcengines.items;

import com.thesledgehammer.groovymc.integration.forgeenergy.ForgeEnergy;
import com.thesledgehammer.groovymc.integration.forgeenergy.ForgeEnergyItem;
import com.thesledgehammer.groovymc.items.GroovyItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class FEItem extends GroovyItem {

    private int capacity = 0;
    private int maxTransfer = 0;
    private ForgeEnergy FE;

    public FEItem(int capacity, int maxTransfer) {
        this.capacity = capacity;
        this.maxTransfer = maxTransfer;
        FE = new ForgeEnergy(capacity, maxTransfer);
        setCreativeTab(CreativeTabs.MISC);
        setMaxStackSize(1);
        setMaxDamage(1);
    }

    @Override
    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new ForgeEnergyItem(stack, capacity, maxTransfer);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        if(stack.isEmpty()) {
            return 0.0;
        }
        IEnergyStorage feItem = new ForgeEnergyItem(stack, capacity, maxTransfer);
        return (double) feItem.getEnergyStored() / (double) feItem.getMaxEnergyStored();
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0xD01010;
    }
}
