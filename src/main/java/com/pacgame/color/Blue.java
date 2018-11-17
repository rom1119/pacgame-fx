package com.pacgame.color;

import com.pacgame.provider.ColorProvider;

class Blue extends Color {
    public Blue(ColorProvider provider) {
        this.providedObject = provider.getBlue();
    }
}
