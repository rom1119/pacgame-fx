package com.pacgame.color;

import com.pacgame.provider.ColorProvider;

class Red extends Color {

    public Red(ColorProvider provider) {
        this.providedObject = provider.getRed();
    }
}
