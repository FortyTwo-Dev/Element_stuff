package fr.titi.elementstuff.init.Items.armor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class GemArmorItemChestplate extends ArmorItem {

    public GemArmorItemChestplate(IArmorMaterial material, EquipmentSlotType equipmentSlotType, Properties properties) {
        super(material, equipmentSlotType, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!player.isSpectator() && !player.isCreative()) {
            if (!player.verticalCollision && !player.horizontalCollision) {
                world.destroyBlock(BlockPos.of(2), true);
                player.abilities.flying = true;
                player.abilities.setFlyingSpeed(0.08f);
                if (player.isShiftKeyDown()) {
                    player.abilities.flying = false;
                    //player.abilities.invulnerable = true;
                }
            }
        } else {
            //player.abilities.invulnerable = false;
            player.abilities.setFlyingSpeed(0.05f);
        }

        super.onArmorTick(stack, world, player);
    }

}
