package com.pacgame.provider;

import com.pacgame.provider.alignment.HorizontalAlignmentProvidedObject;
import com.pacgame.provider.alignment.VerticalAlignmentProvidedObject;

public interface AlignmentProvider {

    VerticalAlignmentProvidedObject getTop();
    VerticalAlignmentProvidedObject getVCenter();
    VerticalAlignmentProvidedObject getBottom();

    HorizontalAlignmentProvidedObject getLeft();
    HorizontalAlignmentProvidedObject getHCenter();
    HorizontalAlignmentProvidedObject getRight();
}
