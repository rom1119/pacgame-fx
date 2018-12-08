package com.pacgame.provider.interfaces;

import com.pacgame.provider.property.PropertyProvider;

public interface PositionableProvider {

    int getX();

    int getY();

    PropertyProvider<Integer> XProperty();

    PropertyProvider<Integer> YProperty();

    void setX(int x);

    void setY(int y);
}
