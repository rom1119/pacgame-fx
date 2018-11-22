package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

class Green extends Color {
    public Green(PaintProvider provider) {
        super(provider);
        this.paint = provider.createGreen();
    }
}
