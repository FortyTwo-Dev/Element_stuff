package fr.titi.elementstuff.entity.client.armor;

import fr.titi.elementstuff.init.Items.armor.custom.GemArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class GemArmorRenderer extends GeoArmorRenderer<GemArmorItem> {

    public GemArmorRenderer() {
        super(new GemArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}

