package com.pacgame.uiElement.alignment;

import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.alignment.VerticalAlignmentProvidedObject;

public class VCenter extends VerticalAlignment {
    public VCenter(AlignmentProvider provider) {
        providedObject = provider.getVCenter();
    }
}
