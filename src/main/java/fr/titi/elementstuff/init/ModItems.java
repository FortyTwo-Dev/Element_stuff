package fr.titi.elementstuff.init;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.Items.FlyingGem;
import fr.titi.elementstuff.init.Items.armor.custom.GemArmorItem;
import fr.titi.elementstuff.init.Items.custom.GemPickaxe;
import fr.titi.elementstuff.init.Items.custom.GemSword;
import fr.titi.elementstuff.utils.ElementStuffTab;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementStuff.MODID);

    //flying gem
    public static final RegistryObject<FlyingGem> FLYINGGEM = ITEMS.register("flying_gem", () -> new FlyingGem());

    //armor gem
    public static final RegistryObject<ArmorItem> GEM_HELMET = ITEMS.register("gem_helmet", () ->
            new GemArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.HEAD, new Item.Properties().stacksTo(1).tab(ElementStuffTab.TAB).fireResistant()));

    public static final RegistryObject<ArmorItem> GEM_CHESTPLATE = ITEMS.register("gem_chestplate", () ->
            new GemArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.CHEST, new Item.Properties().stacksTo(1).tab(ElementStuffTab.TAB).fireResistant()));

    public static final RegistryObject<ArmorItem> GEM_LEGGINGS = ITEMS.register("gem_leggings", () ->
            new GemArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.LEGS, new Item.Properties().stacksTo(1).tab(ElementStuffTab.TAB).fireResistant()));

    public static final RegistryObject<ArmorItem> GEM_BOOTS = ITEMS.register("gem_boots", () ->
            new GemArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.FEET, new Item.Properties().stacksTo(1).tab(ElementStuffTab.TAB).fireResistant()));

    //gem sword
    public static final RegistryObject<GemSword> GEM_SWORD = ITEMS.register("gem_sword", () -> new GemSword());

    //gem pickaxe
    public static final RegistryObject<GemPickaxe> GEM_PICKAXE = ITEMS.register("gem_pickaxe", () -> new GemPickaxe());

}
