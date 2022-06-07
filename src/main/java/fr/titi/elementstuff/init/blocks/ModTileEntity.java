package fr.titi.elementstuff.init.blocks;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.ModBlocks;
import fr.titi.elementstuff.init.blocks.tile.BlockDeTestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntity {

    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ElementStuff.MODID);

    public static final RegistryObject<TileEntityType<BlockDeTestTileEntity>> BLOCK_DE_TEST_TILE_ENTITY = TILES.register("block_de_test_tile_entity", () -> TileEntityType.Builder
            .of(() -> new BlockDeTestTileEntity(), ModBlocks.BLOCK_DE_TEST.get()).build(null));

}
