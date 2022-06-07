package fr.titi.elementstuff.init.blocks.tile;

import fr.titi.elementstuff.init.blocks.ModTileEntity;
import net.minecraft.tileentity.TileEntity;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BlockDeTestTileEntity extends TileEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public BlockDeTestTileEntity() {
        super(ModTileEntity.BLOCK_DE_TEST_TILE_ENTITY.get());
    }

    @SuppressWarnings("unchecked")
    private <E extends TileEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().transitionLengthTicks = 0;
        event.getController().setAnimation(new AnimationBuilder().addAnimation("Botarium.anim.deploy", true));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
