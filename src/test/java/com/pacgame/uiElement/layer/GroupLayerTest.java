package com.pacgame.uiElement.layer;

import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.LayerProviderImpl;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GroupLayerTest extends TestCase {

    private GroupLayer layer;

    @BeforeEach
    public void setUp() {
//        LayerProvider l = Mockito.mock(LayerProvider.class);
//        com.pacgame.provider.layer.GroupLayer groupLayer = new com.pacgame.provider.layer.GroupLayer();
//        when(l.createGroupLayer()).thenReturn(groupLayer);
        LayerProviderImpl layerProvider = new LayerProviderImpl();
        layer = new GroupLayer(100, 100, layerProvider);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void setWidth() {
    }

    @Test
    void setHeight() {

    }

    @Test
    void getWidth() {
    }

    @Test
    void getHeight() {
        Assert.assertEquals(100, layer.getHeight());

    }

    @Test
    void addChildren() {
    }

    @Test
    void removeChildren() {
    }

    @Test
    void hasChildren() {
    }

    @Test
    void setParent() {
    }

    @Test
    void getParent() {
    }

    @Test
    void getProvidedObject() {

    }

    @Test
    void isVisible() {
        Assert.assertEquals(true, layer.isVisible());

    }

    @Test
    void show() {
        layer.show();
        Assert.assertEquals(true, layer.isVisible());

    }

    @Test
    void hide() {
        layer.hide();
        Assert.assertEquals(false, layer.isVisible());
    }

    @Test
    void compareTo() {
    }

    @Test
    void getId() {
    }

    @Test
    void isVisible1() {
    }

    @Test
    void show1() {
    }

    @Test
    void hide1() {
    }

    @Test
    void compareTo1() {
    }

    @Test
    void getX() {
    }

    @Test
    void getY() {
    }

    @Test
    void XProperty() {
    }

    @Test
    void YProperty() {
    }

    @Test
    void setX() {
    }

    @Test
    void setY() {
    }

    @Test
    void setBackground() {
    }

    @Test
    void getProvidedObject1() {
    }
}