package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

class Yellow extends Color {
    public Yellow(PaintProvider provider) {
        super(provider);
        this.paint = provider.createYellow();
    }
}
