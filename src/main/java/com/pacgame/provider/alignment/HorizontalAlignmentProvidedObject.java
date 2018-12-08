package com.pacgame.provider.alignment;


import com.pacgame.provider.AlignmentProvidedObject;

public abstract class HorizontalAlignmentProvidedObject extends AlignmentProvidedObject {

    protected HorizontalAlignmentProxy proxy;

    @Override
    public HorizontalAlignmentProxy getProxy()
    {
        return proxy;
    }
}
