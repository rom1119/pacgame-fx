package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

public abstract class Paint {

    protected com.pacgame.provider.Paint paint;

    public Paint(PaintProvider provider) {

    }

    public com.pacgame.provider.Paint getalue()
    {
        return paint;
    }
}
