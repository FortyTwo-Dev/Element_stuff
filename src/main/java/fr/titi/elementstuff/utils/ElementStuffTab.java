package fr.titi.elementstuff.utils;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ElementStuffTab extends ItemGroup {

    public static final ElementStuffTab TAB = new ElementStuffTab(ItemGroup.TABS.length, "elementstufftab");

    public ElementStuffTab(int i, String name) {
        super(i, name);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.ACACIA_FENCE);
    }
}
