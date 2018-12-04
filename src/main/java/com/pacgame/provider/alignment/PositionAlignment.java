package com.pacgame.provider.alignment;

import com.pacgame.provider.ProvidedObject;

public class PositionAlignment extends ProvidedObject {

    public static final PositionAlignment TOP_LEFT = new PositionAlignment(new Top(), new Left());
    public static final PositionAlignment TOP_RIGHT = new PositionAlignment(new Top(), new Right());
    public static final PositionAlignment TOP_CENTER = new PositionAlignment(new Top(), new HCenter());

    public static final PositionAlignment CENTER = new PositionAlignment(new VCenter(), new HCenter());
    public static final PositionAlignment CENTER_LEFT = new PositionAlignment(new VCenter(), new Left());
    public static final PositionAlignment CENTER_RIGHT = new PositionAlignment(new VCenter(), new Right());

    public static final PositionAlignment BOTTOM_LEFT = new PositionAlignment(new Bottom(), new Left());
    public static final PositionAlignment BOTTOM_CENTER = new PositionAlignment(new Bottom(), new HCenter());
    public static final PositionAlignment BOTTOM_RIGHT = new PositionAlignment(new Bottom(), new Right());


    private PositionAlignmentProxy proxy;

    private PositionAlignment(VerticalAlignmentProvidedObject vAlignment, HorizontalAlignmentProvidedObject hAlignment) {

        proxy = new PositionAlignmentProxy(vAlignment.getProxy(), hAlignment.getProxy());
    }

    public PositionAlignmentProxy getProxy()
    {
        return proxy;
    }


}
