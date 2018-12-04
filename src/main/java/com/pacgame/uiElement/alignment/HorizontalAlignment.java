package com.pacgame.uiElement.alignment;


import com.pacgame.provider.alignment.HorizontalAlignmentProvidedObject;

public abstract class HorizontalAlignment extends Alignment {

    protected HorizontalAlignmentProvidedObject providedObject;

    @Override
    public HorizontalAlignmentProvidedObject getProvidedObject()
    {
        return providedObject;
    }
}
