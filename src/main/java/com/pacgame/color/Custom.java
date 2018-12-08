package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

class Custom extends Color {
    public Custom(PaintProvider provider, int red, int green, int blue) {
        super(provider);
        this.providedObject = provider.createCustom(red, green, blue);
    }

    public Custom(PaintProvider provider, int red, int green, int blue, double alpha) {
        super(provider);
        this.providedObject = provider.createCustom(red, green, blue, alpha);
    }


}
