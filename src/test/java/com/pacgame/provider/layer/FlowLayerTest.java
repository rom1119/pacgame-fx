package com.pacgame.provider.layer;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowLayerTest extends TestCase {

    private FlowLayer flowLayer;

    @BeforeEach
    public void setUp() {
        flowLayer = new FlowLayer();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void getProxy() {
        Assert.assertTrue(flowLayer.getProxy() != null);
    }

    @Test
    void setWidth() {
        flowLayer.setWidth(200);
        Assert.assertEquals(200, flowLayer.getWidth());
    }

    @Test
    void setHeight() {
        flowLayer.setHeight(200);
        Assert.assertEquals(200, flowLayer.getHeight());
    }

    @Test
    void setBorder() {
    }

    @Test
    void addChildren() {
        FlowLayer child = new FlowLayer();
        flowLayer.addChildren(child);
        Assert.assertTrue(flowLayer.hasChildren(child));
    }

    @Test
    void removeChildren() {
        FlowLayer child = new FlowLayer();
        flowLayer.addChildren(child);
        Assert.assertTrue(flowLayer.hasChildren(child));
        flowLayer.removeChildren(child);
        Assert.assertFalse(flowLayer.hasChildren(child));
    }


    @Test
    void hasChildren() {
    }

    @Test
    void setParent() {
        FlowLayer parent = new FlowLayer();
        flowLayer.setParent(parent);
        Assert.assertEquals(parent, flowLayer.getParent());
        Assert.assertTrue(parent.hasChildren(flowLayer));
    }

    @Test
    void getParent() {
        Assert.assertEquals(null, flowLayer.getParent());
    }

    @Test
    void isVisible() {
        Assert.assertEquals(true, flowLayer.isVisible());
        flowLayer.hide();
        Assert.assertEquals(false, flowLayer.isVisible());
        flowLayer.show();
        Assert.assertEquals(true, flowLayer.isVisible());

    }

    @Test
    void show() {
        Assert.assertEquals(true, flowLayer.isVisible());
        flowLayer.show();
        Assert.assertEquals(true, flowLayer.isVisible());
    }

    @Test
    void hide() {
        Assert.assertEquals(true, flowLayer.isVisible());
        flowLayer.hide();
        Assert.assertEquals(false, flowLayer.isVisible());
    }

    @Test
    void setBackground() {
    }

    @Test
    void setPadding() {
    }

    @Test
    void compareTo() {
    }


    @Test
    void getX() {
        Assert.assertEquals(0, flowLayer.getX());
        flowLayer.setX(100);
        Assert.assertEquals(100, flowLayer.getX());
    }

    @Test
    void getY() {
        Assert.assertEquals(0, flowLayer.getY());
        flowLayer.setY(100);
        Assert.assertEquals(100, flowLayer.getY());
    }

    @Test
    void XProperty() {
        Assert.assertNotNull( flowLayer.XProperty());

    }

    @Test
    void YProperty() {
        Assert.assertNotNull( flowLayer.YProperty());

    }

    @Test
    void setX() {
        Assert.assertEquals(0, flowLayer.getX());
        flowLayer.setX(3456);
        Assert.assertEquals(3456, flowLayer.getX());
    }

    @Test
    void setY() {
        Assert.assertEquals(0, flowLayer.getY());
        flowLayer.setY(3456);
        Assert.assertEquals(3456, flowLayer.getY());
    }

}