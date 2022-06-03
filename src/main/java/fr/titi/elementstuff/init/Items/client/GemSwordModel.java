package fr.titi.elementstuff.init.Items.client;


import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.Items.custom.GemSword;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GemSwordModel extends AnimatedGeoModel<GemSword> {
    @Override
    public ResourceLocation getModelLocation(GemSword object) {
        return new ResourceLocation(ElementStuff.MODID, "geo/gem_sword.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GemSword object) {
        return new ResourceLocation(ElementStuff.MODID, "textures/item/gem_sword_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GemSword animatable) {
        return new ResourceLocation(ElementStuff.MODID, "animations/gem_blade.animation.json");
    }
}
