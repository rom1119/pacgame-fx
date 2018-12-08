package com.pacgame.provider.db;

import com.pacgame.provider.db.types.PaintType;

public class PaintEntity extends Entity {

    private PaintType type;

    public void setType(PaintType type) {
        this.type = type;
    }
}
