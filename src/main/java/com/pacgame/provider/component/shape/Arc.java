package com.pacgame.provider.component.shape;

import com.pacgame.provider.component.ShapeProvidedObject;

public class Arc extends ShapeProvidedObject {

    protected ArcProxy proxy;


    public Arc(int radius) {
        proxy = new ArcProxy(radius);
    }

}
