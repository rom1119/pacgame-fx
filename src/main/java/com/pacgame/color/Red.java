package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

class Red extends Color {

    public Red(PaintProvider provider) {
        super(provider);
        this.providedObject = provider.createRed();
    }
}
