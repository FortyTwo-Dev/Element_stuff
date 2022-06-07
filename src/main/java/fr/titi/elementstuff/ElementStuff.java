package fr.titi.elementstuff;

import fr.titi.elementstuff.client.renderer.tile.BlockDeTestTileRenderer;
import fr.titi.elementstuff.entity.client.armor.GemArmorRenderer;
import fr.titi.elementstuff.init.Items.armor.custom.GemArmorItem;
import fr.titi.elementstuff.init.ModBlocks;
import fr.titi.elementstuff.init.ModItems;
import fr.titi.elementstuff.init.blocks.ModTileEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod(ElementStuff.MODID)
public class ElementStuff {

    public static final String MODID = "elementstuff";

    public ElementStuff() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntity.TILES.register(bus);

    }

    private void setup(FMLCommonSetupEvent e){

    }

    private void clientSetup(FMLClientSetupEvent e){
        GeoArmorRenderer.registerArmorRenderer(GemArmorItem.class, new GemArmorRenderer());
        ClientRegistry.bindTileEntityRenderer(ModTileEntity.BLOCK_DE_TEST_TILE_ENTITY.get(), BlockDeTestTileRenderer::new);
    }

}
