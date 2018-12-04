package com.pacgame.uiElement.alignment;

import com.pacgame.provider.ProvidedObject;
import com.pacgame.provider.alignment.PositionAlignment;

public class Position {

    public static final Position TOP_LEFT = new Position(new Top(), new Left());
    public static final PositionAlignment TOP_RIGHT = new PositionAlignment(new Top(), new Right());
    public static final PositionAlignment TOP_CENTER = new PositionAlignment(new Top(), new HCenter());
    public static final PositionAlignment CENTER = new PositionAlignment(new VCenter(), new HCenter());
    public static final PositionAlignment CENTER_LEFT = new PositionAlignment(new VCenter(), new Left());
    public static final PositionAlignment CENTER_RIGHT = new PositionAlignment(new VCenter(), new Right());
    public static final PositionAlignment BOTTOM_LEFT = new PositionAlignment(new Bottom(), new Left());
    public static final PositionAlignment BOTTOM_CENTER = new PositionAlignment(new Bottom(), new HCenter());
    public static final PositionAlignment BOTTOM_RIGHT = new PositionAlignment(new Bottom(), new Right());

    private PositionAlignment providedObject;

    private Position(VerticalAlignment vAlignment, HorizontalAlignment hAlignment) {

        proxy = new PositionAlignmentProxy(vAlignment.getProxy(), hAlignment.getProxy());
    }

    public PositionAlignment getProvidedObject() {
        return providedObject;
    }
}
