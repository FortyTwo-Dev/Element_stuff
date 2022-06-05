package fr.titi.elementstuff.init.Items.client;

import fr.titi.elementstuff.init.Items.custom.GemPickaxe;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class GemPickaxeRenderer extends GeoItemRenderer<GemPickaxe> {
    public GemPickaxeRenderer() {
        super(new GemPickaxeModel());
    }
}
