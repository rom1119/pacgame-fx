package com.pacgame.uiElement.alignment;

import com.pacgame.provider.AlignmentProvider;

public class Left extends HorizontalAlignment {

    public Left(AlignmentProvider provider) {
        providedObject = provider.getLeft();
    }
}
