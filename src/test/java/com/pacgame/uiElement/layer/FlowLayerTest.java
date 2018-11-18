package com.pacgame.uiElement.layer;

import com.pacgame.provider.LayerProvidedObject;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FlowLayerTest extends TestCase {

    private FlowLayer flowLayer;

    @BeforeEach
    public void setUp() {
        LayerProvidedObject l = Mockito.mock(LayerProvidedObject.class);
        flowLayer = new FlowLayer(100, 100, l);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void isVisible() {
        Assert.assertEquals(true, flowLayer.isVisible());

    }

    @Test
    void getY() {
    }

    @Test
    void fill() {
    }

    @Test
    void fill1() {
    }

    @Test
    void fillGreen() {
    }

    @Test
    void fillWhite() {
    }
}