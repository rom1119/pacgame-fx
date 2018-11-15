package com.pacgame.provider.interfaces;

import com.pacgame.provider.property.PropertyProvider;

public interface PositionableProvider {

    PropertyProvider<Integer> getX();

    PropertyProvider<Integer> getY();
}
