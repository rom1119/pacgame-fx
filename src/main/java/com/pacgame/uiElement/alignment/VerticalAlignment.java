package com.pacgame.uiElement.alignment;

import com.pacgame.provider.alignment.VerticalAlignmentProvidedObject;

public abstract class VerticalAlignment extends Alignment {

    protected VerticalAlignmentProvidedObject providedObject;


    @Override
    public VerticalAlignmentProvidedObject getProvidedObject()
    {
        return providedObject;
    }
}
