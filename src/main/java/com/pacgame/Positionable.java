package com.pacgame;

import com.pacgame.provider.property.PropertyProvider;

public interface Positionable {

    int getX();

    int getY();

    Property<Integer> XProperty();

    Property<Integer> YProperty();

    void setX(int x);

    void setY(int y);
}
