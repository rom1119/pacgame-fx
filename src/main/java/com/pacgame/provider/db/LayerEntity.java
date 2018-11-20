package com.pacgame.provider.db;

import com.pacgame.provider.db.types.LayerType;

public class LayerEntity extends Entity {

    private LayerType type;

    public void setType(LayerType type) {
        this.type = type;
    }
}
