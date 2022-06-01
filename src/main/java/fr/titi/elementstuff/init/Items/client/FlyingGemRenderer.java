package fr.titi.elementstuff.init.Items.client;

import fr.titi.elementstuff.init.Items.FlyingGem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class FlyingGemRenderer extends GeoItemRenderer<FlyingGem> {
    public FlyingGemRenderer() {
        super(new FlyingGemModel());
    }
}
