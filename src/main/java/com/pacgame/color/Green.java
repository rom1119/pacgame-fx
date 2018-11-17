package com.pacgame.color;

import com.pacgame.provider.ColorProvider;

class Green extends Color {
    public Green(ColorProvider provider) {
        this.providedObject = provider.getGreen();
    }
}
