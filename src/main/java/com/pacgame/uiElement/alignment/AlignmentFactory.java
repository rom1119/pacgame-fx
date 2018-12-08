package com.pacgame.uiElement.alignment;

public interface AlignmentFactory {

    Top getTop();
    Bottom getBottom();
    Left getLeft();
    Right getRight();

    HCenter getHCenter();
    VCenter getVCenter();
}
