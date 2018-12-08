package com.pacgame.provider.db.types;

public enum PaintType {

    COLOR(0),
    IMAGE(1)
    ;

    int type;

    PaintType(int type) {
        this.type = type;
    }

    public int getValue()
    {
        return type;
    }
}
