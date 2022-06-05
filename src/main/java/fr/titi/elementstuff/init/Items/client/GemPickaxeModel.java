package fr.titi.elementstuff.init.Items.client;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.Items.custom.GemPickaxe;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GemPickaxeModel extends AnimatedGeoModel<GemPickaxe> {
    @Override
    public ResourceLocation getModelLocation(GemPickaxe object) {
        return new ResourceLocation(ElementStuff.MODID, "geo/gem_pickaxe.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GemPickaxe object) {
        return new ResourceLocation(ElementStuff.MODID, "textures/item/gem_pickaxe_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GemPickaxe animatable) {
        return new ResourceLocation(ElementStuff.MODID, "animations/gem_pickaxe.animation.json");
    }
}
