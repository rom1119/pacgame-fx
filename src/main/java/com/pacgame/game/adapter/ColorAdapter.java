package com.pacgame.game.adapter;

import com.pacgame.color.Paint;
import com.pacgame.game.IColor;

public class ColorAdapter implements IColor {

    private Paint paint;

    public ColorAdapter(Paint paint) {
        this.paint = paint;
    }

    Paint getValue()
    {
        return paint;
    }
}
