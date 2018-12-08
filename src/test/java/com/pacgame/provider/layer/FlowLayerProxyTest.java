package com.pacgame.provider.layer;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowLayerProxyTest extends TestCase {

    private FlowLayerProxy flowLayerProxy;

    @BeforeEach
    public void setUp() {
        flowLayerProxy = new FlowLayerProxy();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void getProxyObject() {
        Assert.assertNotNull(flowLayerProxy.getProxyObject());
    }

    @Test
    void addChildren() {
        FlowLayerProxy child = new FlowLayerProxy();
        flowLayerProxy.addChildren(child);
        Assert.assertTrue(flowLayerProxy.hasChildren(child));
    }

    @Test
    void removeChildren() {
        FlowLayerProxy child = new FlowLayerProxy();
        flowLayerProxy.addChildren(child);
        Assert.assertTrue(flowLayerProxy.hasChildren(child));
        flowLayerProxy.removeChildren(child);
        Assert.assertFalse(flowLayerProxy.hasChildren(child));
    }

    @Test
    void setWidth() {
        flowLayerProxy.setWidth(200);
        Assert.assertEquals(200, flowLayerProxy.getWidth());
    }

    @Test
    void setHeight() {
        flowLayerProxy.setHeight(200);
        Assert.assertEquals(200, flowLayerProxy.getHeight());
    }

    @Test
    void setBackground() {
    }

    @Test
    void setBorder() {
    }

    @Test
    void hasChildren() {
    }
    @Test
    void setParent() {
        FlowLayerProxy parent = new FlowLayerProxy();
        flowLayerProxy.setParent(parent);
        Assert.assertEquals(parent, flowLayerProxy.getParent());
        Assert.assertTrue(parent.hasChildren(flowLayerProxy));
    }

    @Test
    void getParent() {
        Assert.assertEquals(null, flowLayerProxy.getParent());
    }

    @Test
    void isVisible() {
        Assert.assertEquals(true, flowLayerProxy.isVisible());
        flowLayerProxy.hide();
        Assert.assertEquals(false, flowLayerProxy.isVisible());
        flowLayerProxy.show();
        Assert.assertEquals(true, flowLayerProxy.isVisible());

    }

    @Test
    void show() {
        Assert.assertEquals(true, flowLayerProxy.isVisible());
        flowLayerProxy.show();
        Assert.assertEquals(true, flowLayerProxy.isVisible());
    }

    @Test
    void hide() {
        Assert.assertEquals(true, flowLayerProxy.isVisible());
        flowLayerProxy.hide();
        Assert.assertEquals(false, flowLayerProxy.isVisible());
    }




    @Test
    void setPadding() {
    }

    @Test
    void setPadding1() {
    }

    @Test
    void setPadding2() {
    }


    @Test
    void compareTo() {
    }
    @Test
    void getX() {
        Assert.assertEquals(0, flowLayerProxy.getX());
        flowLayerProxy.setX(100);
        Assert.assertEquals(100, flowLayerProxy.getX());
    }

    @Test
    void getY() {
        Assert.assertEquals(0, flowLayerProxy.getY());
        flowLayerProxy.setY(100);
        Assert.assertEquals(100, flowLayerProxy.getY());
    }

    @Test
    void XProperty() {
        Assert.assertNotNull( flowLayerProxy.XProperty());

    }

    @Test
    void YProperty() {
        Assert.assertNotNull( flowLayerProxy.YProperty());

    }

    @Test
    void setX() {
        Assert.assertEquals(0, flowLayerProxy.getX());
        flowLayerProxy.setX(3456);
        Assert.assertEquals(3456, flowLayerProxy.getX());
    }

    @Test
    void setY() {
        Assert.assertEquals(0, flowLayerProxy.getY());
        flowLayerProxy.setY(3456);
        Assert.assertEquals(3456, flowLayerProxy.getY());
    }

}