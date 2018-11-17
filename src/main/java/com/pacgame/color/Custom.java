package com.pacgame.color;

import com.pacgame.provider.ColorProvider;

class Custom extends Color {
    public Custom(ColorProvider provider, int red, int green, int blue) {
        this.providedObject = provider.getCustom(red, green, blue);
    }

    public Custom(ColorProvider provider, int red, int green, int blue, double alpha) {
        this.providedObject = provider.getCustom(red, green, blue, alpha);
        Boolean aBoolean = new Boolean(true);
    }


}
