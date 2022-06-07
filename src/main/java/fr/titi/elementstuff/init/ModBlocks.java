package fr.titi.elementstuff.init;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.blocks.BlockDeTest;
import fr.titi.elementstuff.utils.ElementStuffTab;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementStuff.MODID);

    public static final RegistryObject<Block> BLOCK_DE_TEST = createBlock("block_de_test", () ->new BlockDeTest());

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> Block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(Block.get(), new Item.Properties().tab(ElementStuffTab.TAB).fireResistant()));
        return Block;
    }

}
