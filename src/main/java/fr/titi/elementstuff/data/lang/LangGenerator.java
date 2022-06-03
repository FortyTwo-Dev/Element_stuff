package fr.titi.elementstuff.data.lang;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class LangGenerator extends LanguageProvider {

    public LangGenerator(DataGenerator generator) {
        super(generator, ElementStuff.MODID, "en_us");
    }

    private void block(PrefixHelper helper) {

    }
    private void Item(PrefixHelper helper) {

        helper.add(ModItems.FLYINGGEM.get(), "FlyingGem");
        helper.add(ModItems.GEM_SWORD.get(), "Gem Sword");
        helper.add(ModItems.GEM_HELMET.get(), "Gem Helmet");
        helper.add(ModItems.GEM_CHESTPLATE.get(), "Gem Chestplate");
        helper.add(ModItems.GEM_LEGGINGS.get(), "Gem Leggings");
        helper.add(ModItems.GEM_BOOTS.get(), "Gem Boots");
    }
    private void Categories(PrefixHelper helper) {
        add("itemGroup.elementstufftab", "ElementStuff");
    }
    private void toolTips(PrefixHelper helper) {
        helper.setPrefix("tooltip");

        helper.add("flyinggem.description", "\u00A7eRight Click \u00A77To Fly");
        helper.add("flyinggem.hold_shift","Hold \u00A7eShift \u00A77for More Information");

    }
    private void Key(PrefixHelper helper) {

    }
    private void Entities(PrefixHelper helper) {

    }
    @Override
    public void addBlock(Supplier<? extends Block> key, String name) {
        super.addBlock(key, name);
    }
    @Override
    protected void addTranslations() {
        PrefixHelper helper = new PrefixHelper(this);

        block(helper);
        Item(helper);
        Categories(helper);
        toolTips(helper);
        Key(helper);
        Entities(helper);

    }
    @Override
    public void add(Block key, String name) {
        if (key != null) super.add(key, name);
    }

    @Override
    public void add(Item key, String name) {
        if (key != null) super.add(key, name);
    }
    public static class PrefixHelper {
        private LangGenerator generator;
        private String prefix;

        public PrefixHelper(LangGenerator generator){
            this.generator = generator;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix + ".";
        }

        public void add(String translationKey, String translation) {
            generator.add(prefix + translationKey, translation);
        }

        public void add(Block key, String name) {
            if (key != null) generator.add(key, name);
        }

        public void add(Item key, String name) {
            if (key != null) generator.add(key, name);
        }

    }
}
