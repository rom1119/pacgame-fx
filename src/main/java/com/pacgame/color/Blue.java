package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

class Blue extends Color {
    public Blue(PaintProvider provider) {
        super(provider);
        this.paint = provider.createBlue();
    }
}
