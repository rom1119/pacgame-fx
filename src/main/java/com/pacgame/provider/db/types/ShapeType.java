package com.pacgame.provider.db.types;

public enum  ShapeType {

    RECTANGLE(0),
    ARC(1);

    private int type;

    ShapeType(int type) {
        this.type = type;
    }
}
