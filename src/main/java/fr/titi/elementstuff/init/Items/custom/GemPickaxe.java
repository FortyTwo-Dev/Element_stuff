package fr.titi.elementstuff.init.Items.custom;

import fr.titi.elementstuff.init.Items.client.GemPickaxeRenderer;
import fr.titi.elementstuff.utils.ElementStuffTab;
import fr.titi.elementstuff.utils.GemItemsTiers;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;

public class GemPickaxe extends PickaxeItem implements IAnimatable, ISyncable {
    public AnimationFactory factory = new AnimationFactory(this);


    public GemPickaxe() {
        super(GemItemsTiers.GEM, 1, -1.0f, new  Item.Properties().stacksTo(1).fireResistant().tab(ElementStuffTab.TAB)
                .setISTER(() -> GemPickaxeRenderer::new));
        GeckoLibNetwork.registerSyncable(this);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gem_pickaxe.new", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void onAnimationSync(int id, int state) {

    }
}
