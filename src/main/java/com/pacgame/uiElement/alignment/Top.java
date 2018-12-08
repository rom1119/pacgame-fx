package com.pacgame.uiElement.alignment;

import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.alignment.VerticalAlignmentProvidedObject;

public class Top extends VerticalAlignment {

    public Top(AlignmentProvider provider) {
        providedObject = provider.getTop();
    }
}
