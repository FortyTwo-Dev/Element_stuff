package fr.titi.elementstuff.event;

import fr.titi.elementstuff.ElementStuff;
import fr.titi.elementstuff.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElementStuff.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GemArmorEvent {

    @SubscribeEvent
    public void onPlayerArmorEquip(LivingEquipmentChangeEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.GEM_HELMET.get())
                    && (event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.GEM_CHESTPLATE.get()
                    && (event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.GEM_LEGGINGS.get()
                    && (event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.GEM_BOOTS.get())))) {
                player.abilities.invulnerable = true;
                System.out.println("invulnerable");
            } else if (event.getFrom().getItem() == ModItems.GEM_HELMET.get()
                    && event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).isEmpty()
                    || event.getFrom().getItem() == ModItems.GEM_CHESTPLATE.get()
                    && event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).isEmpty()
                    || event.getFrom().getItem() == ModItems.GEM_LEGGINGS.get()
                    && event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).isEmpty()
                    || event.getFrom().getItem() == ModItems.GEM_BOOTS.get()
                    && event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).isEmpty()) {
                player.abilities.invulnerable = false;
                System.out.println("vulnerable");
            }
        }
    }

}
