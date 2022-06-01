package fr.titi.elementstuff.init.Items.client;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.Items.FlyingGem;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FlyingGemModel extends AnimatedGeoModel<FlyingGem> {
    @Override
    public ResourceLocation getModelLocation(FlyingGem object) {
        return new ResourceLocation(ElementStuff.MODID, "geo/flying_gem.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FlyingGem object) {
        return new ResourceLocation(ElementStuff.MODID, "textures/item/flying_gem_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FlyingGem animatable) {
        return new ResourceLocation(ElementStuff.MODID, "animations/flying_gem.animation.json");
    }
}
