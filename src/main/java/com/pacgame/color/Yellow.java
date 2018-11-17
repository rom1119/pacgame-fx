package com.pacgame.color;

import com.pacgame.provider.ColorProvider;

class Yellow extends Color {
    public Yellow(ColorProvider provider) {
        this.providedObject = provider.getYellow();
    }
}
