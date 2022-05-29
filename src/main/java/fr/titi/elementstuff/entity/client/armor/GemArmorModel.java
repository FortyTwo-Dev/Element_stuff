package fr.titi.elementstuff.entity.client.armor;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.Items.armor.custom.GemArmorItem;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GemArmorModel extends AnimatedGeoModel<GemArmorItem> {
    @Override
    public ResourceLocation getModelLocation(GemArmorItem object) {
        return new ResourceLocation(ElementStuff.MODID, "geo/gem_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GemArmorItem object) {
        return new ResourceLocation(ElementStuff.MODID, "textures/models/armor/gem_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GemArmorItem animatable) {
        return new ResourceLocation(ElementStuff.MODID, "animations/gem_armor.animation.json");
    }
}
