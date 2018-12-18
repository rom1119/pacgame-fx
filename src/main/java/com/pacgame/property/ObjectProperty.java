package com.pacgame.property;

import com.pacgame.Property;

public class ObjectProperty<T extends Object> extends Property<T> {

    public ObjectProperty() {

    }

    public ObjectProperty(T property) {
        super(property);
    }
}
