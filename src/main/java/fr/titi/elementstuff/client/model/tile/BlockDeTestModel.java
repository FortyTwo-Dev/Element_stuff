package fr.titi.elementstuff.client.model.tile;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.blocks.tile.BlockDeTestTileEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlockDeTestModel extends AnimatedGeoModel<BlockDeTestTileEntity> {
    @Override
    public ResourceLocation getModelLocation(BlockDeTestTileEntity object) {
        return new ResourceLocation(ElementStuff.MODID, "geo/block_de_test.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BlockDeTestTileEntity object) {
        return new ResourceLocation(ElementStuff.MODID, "textures/block/block_de_test.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BlockDeTestTileEntity animatable) {
        return new ResourceLocation(ElementStuff.MODID, "animations/block_de_test.animation.json");
    }
}
