package fr.titi.elementstuff.init.Items.custom;

import com.google.common.collect.ImmutableSet;
import fr.titi.elementstuff.init.Items.client.GemSwordRenderer;
import fr.titi.elementstuff.utils.ElementStuffTab;
import fr.titi.elementstuff.utils.GemItemsTiers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
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

import java.util.Timer;
import java.util.TimerTask;

public class GemSword extends SwordItem implements IAnimatable, ISyncable {
    public AnimationFactory factory = new AnimationFactory(this);
    public int fast = 1;
    public int chrono = 3;
    Timer timer = new Timer();

    public GemSword() {
        super(GemItemsTiers.GEM, 0, -1.0f, new  Item.Properties().stacksTo(1).fireResistant().tab(ElementStuffTab.TAB)
                .setISTER(() -> GemSwordRenderer::new));
        GeckoLibNetwork.registerSyncable(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        World world = player.level;
        if (fast == 1){
            fast = 0;
            for(int i = 0; i < 360*6; i++) {
                if(i % 20 == 0) {
                    world.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                            entity.getX() + 0.0d, entity.getY() + 0.5, entity.getZ() + 0.0d,
                            Math.cos(i) * 0.05d, 0.05d, Math.sin(i) * 0.05d);
                }
            }
            time();
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (fast == 0) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gem_blade_fast.new", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gem_blade.new", true));
        }
        System.out.println(fast);
        return PlayState.CONTINUE;
    }
    public void time() {
        System.out.println(chrono);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                --chrono;
                System.out.println(chrono);
                if (chrono == 0) {
                    fast = 1;
                    chrono = 3;
                    cancel();
                }
            }
        }, 1000, 1000);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void onAnimationSync(int id, int state) {

    }
}
