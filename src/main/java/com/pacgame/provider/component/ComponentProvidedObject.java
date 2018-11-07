package com.pacgame.provider.component;

import com.pacgame.provider.IProperty;
import com.pacgame.provider.ViewProvidedObject;

abstract class ComponentProvidedObject extends ViewProvidedObject {
    protected IProperty<Integer> width;
    protected IProperty<Integer> height;
    protected IProperty<Integer> x;
    protected IProperty<Integer> y;

    IProperty<Integer> getWidth() {
        return width;
    }

    IProperty<Integer> getHeight() {
        return height;
    }

    IProperty<Integer> getX() {
        return x;
    }

    IProperty<Integer> getY() {
        return y;
    }
}
