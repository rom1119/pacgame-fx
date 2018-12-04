package com.pacgame.provider.alignment;

import com.pacgame.provider.Proxy;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;

public class PositionAlignmentProxy extends Proxy {

    protected Pos proxyObject;

    private VerticalAlignmentProxy verticalAlignmentProxy;
    private HorizontalAlignmentProxy horizontalAlignmentProxy;


    PositionAlignmentProxy(VerticalAlignmentProxy verticalAlignmentProxy, HorizontalAlignmentProxy horizontalAlignmentProxy) {
        if (verticalAlignmentProxy == null || horizontalAlignmentProxy == null) {
            throw new NullPointerException();
        }
        this.verticalAlignmentProxy = verticalAlignmentProxy;
        this.horizontalAlignmentProxy = horizontalAlignmentProxy;
        proxyObject = createProxyObject();
    }

    public Pos getProxyObject() {
        return proxyObject;
    }

    private Pos createProxyObject()
    {
        if ( isVerticalTop() && isHorizontalCenter() ) {
            return Pos.TOP_CENTER;
        } else if (isVerticalTop() && isHorizontalLeft()) {
            return Pos.TOP_LEFT;
        } else if (isVerticalTop() && isHorizontalRight()) {
            return Pos.TOP_RIGHT;
        } else if (isVerticalCenter() && isHorizontalCenter()) {
            return Pos.CENTER;
        } else if (isVerticalCenter() && isHorizontalLeft()) {
            return Pos.CENTER_LEFT;
        } else if (isVerticalCenter() && isHorizontalRight()) {
            return Pos.CENTER_RIGHT;
        } else if (isVerticalBottom() && isHorizontalLeft()) {
            return Pos.BOTTOM_LEFT;
        } else if (isVerticalBottom() && isHorizontalCenter()) {
            return Pos.BOTTOM_CENTER;
        } else {
            return Pos.BOTTOM_RIGHT;
        }
    }

    private boolean isHorizontalCenter() {
        return horizontalAlignmentProxy.getProxyObject().equals(HPos.CENTER);
    }

    private boolean isHorizontalLeft() {
        return horizontalAlignmentProxy.getProxyObject().equals(HPos.LEFT);
    }

    private boolean isHorizontalRight() {
        return horizontalAlignmentProxy.getProxyObject().equals(HPos.RIGHT);
    }


    private boolean isVerticalCenter()
    {
        return verticalAlignmentProxy.getProxyObject().equals(VPos.CENTER);
    }

    private boolean isVerticalTop()
    {
        return verticalAlignmentProxy.getProxyObject().equals(VPos.TOP);
    }

    private boolean isVerticalBottom()
    {
        return verticalAlignmentProxy.getProxyObject().equals(VPos.BOTTOM);
    }

}
