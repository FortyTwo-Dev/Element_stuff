package fr.titi.elementstuff.init.Items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class FlyingGem extends Item {
    float fly = 0.05f;
    public FlyingGem(Item.Properties properties) {super(properties);}
    public int util = 100;
    public int test = 0;
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
        test++;
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
                //System.out.println(util);
                if (!player.abilities.flying) {
                    player.abilities.flying = true;
                    player.abilities.setFlyingSpeed(fly);
                    player.ignoreExplosion();
                    player.stopFallFlying();
                } else {
                    player.abilities.flying = false;
                }
            }
        }
        return super.use(world, player, hand);
    }

}
