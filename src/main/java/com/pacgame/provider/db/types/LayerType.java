package com.pacgame.provider.db.types;

public enum LayerType {

    GROUP_LAYER(0),
    BORDER_LAYER(1),
    FLOW_LAYER(2),
    VERTICAL_LAYER(3),
    HORIZONTAL_LAYER(4),
    ;

    int type;

    LayerType(int type) {
        this.type = type;
    }

    public int getValue()
    {
        return type;
    }
}
