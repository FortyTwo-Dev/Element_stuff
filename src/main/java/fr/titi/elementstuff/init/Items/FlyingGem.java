package fr.titi.elementstuff.init.Items;

import fr.titi.elementstuff.init.Items.client.FlyingGemRenderer;
import fr.titi.elementstuff.utils.ElementStuffTab;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class FlyingGem extends Item implements IAnimatable, ISyncable {
    public AnimationFactory factory = new AnimationFactory(this);
    float fly = 0.07f;

    public FlyingGem() {
        super(new Item.Properties().stacksTo(1).tab(ElementStuffTab.TAB).setISTER(() -> FlyingGemRenderer::new));
        GeckoLibNetwork.registerSyncable(this);
    }
    public int util = 100;
    public int test = 0;
    public int anime = 0;
    public int chrono = 0;
    Timer timer = new Timer();

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> textComponents, ITooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()) {
            textComponents.add(new TranslationTextComponent("tooltip.flyinggem.description"));
            textComponents.add(new TranslationTextComponent("Utilisation: " + util));
            textComponents.add(new TranslationTextComponent("Cooldown: " + chrono));
        } else {
            textComponents.add(new TranslationTextComponent("tooltip.flyinggem.hold_shift"));

        }

        super.appendHoverText(stack, world, textComponents, tooltipFlag);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!player.isSpectator() && !player.isCreative()) {
            if (!player.abilities.flying){
                test++;
                anime++;
                if (util > 1){
                    player.getCooldowns().addCooldown(this, 2*20);
                }
            }
        }
        if (test == 2){
            --util;
            test = 0;
        }
        if (util == 0) {
            player.getCooldowns().addCooldown(this, 300*20);
            this.timer = new Timer();

            chrono = 300;

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    --chrono;
                    if (chrono == 0) {
                        util = 100;
                        cancel();
                    }

                }
            }, 1000, 1000);
        }
        if (!player.isSpectator() && !player.isCreative()) {
            if (util >= 1 && chrono == 0) {
                if (!player.abilities.flying) {
                    player.jumpFromGround();
                    for(int i = 0; i < 360*2; i++) {
                        if(i % 20 == 0) {
                            world.addParticle(ParticleTypes.FLAME,
                                    player.getX() + 0.0d, player.getY() + 0, player.getZ() + 0.0d,
                                    Math.cos(i) * 0.15d, 0.05d, Math.sin(i) * 0.15d);
                        }
                    }
                    player.abilities.flying = true;
                    player.abilities.setFlyingSpeed(fly);
                    player.ignoreExplosion();
                    player.stopFallFlying();
                }
            }
        }
        return super.use(world, player, hand);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (anime > 0) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.flying_gem.new", false));
            anime = 0;
        }
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
