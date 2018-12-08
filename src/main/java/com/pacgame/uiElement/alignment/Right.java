package com.pacgame.uiElement.alignment;

import com.pacgame.provider.AlignmentProvider;

public class Right extends HorizontalAlignment {

    public Right(AlignmentProvider provider) {
        providedObject = provider.getRight();
    }
}
