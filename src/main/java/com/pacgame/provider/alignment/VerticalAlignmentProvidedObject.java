package com.pacgame.provider.alignment;

import com.pacgame.provider.AlignmentProvidedObject;

public abstract class VerticalAlignmentProvidedObject extends AlignmentProvidedObject {

    protected VerticalAlignmentProxy proxy;

    @Override
    public VerticalAlignmentProxy getProxy()
    {
        return proxy;
    }
}
