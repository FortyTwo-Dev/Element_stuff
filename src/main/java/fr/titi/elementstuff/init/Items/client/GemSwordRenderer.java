package fr.titi.elementstuff.init.Items.client;

import fr.titi.elementstuff.init.Items.custom.GemSword;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class GemSwordRenderer extends GeoItemRenderer<GemSword> {
    public GemSwordRenderer() {
        super(new GemSwordModel());
    }
}
