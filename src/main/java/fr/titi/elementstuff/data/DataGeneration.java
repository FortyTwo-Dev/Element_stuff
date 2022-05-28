package fr.titi.elementstuff.data;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.data.lang.LangGenerator;
import fr.titi.elementstuff.data.recipe.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ElementStuff.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent e){
        DataGenerator generator = e.getGenerator();

        if (e.includeServer()) {

            generator.addProvider(new RecipeGenerator(generator));

        }
        if (e.includeClient()) {
            generator.addProvider(new LangGenerator(generator));
        }
    }
}
