package com.pacgame.uiElement.menu.element;

import com.pacgame.provider.*;
import com.pacgame.provider.alignment.PositionAlignment;
import com.pacgame.testEnv.JavaFxThread;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalMenuElementTest extends TestCase {

    private NormalMenuElement menuElement;

    public NormalMenuElementTest()
    {

    }

    @BeforeEach
    public void setUp() {
        UIProvider uiProvider = new UIProviderImpl();
        PositionAlignmentProvider positionAlignment = new PositionAlignmentProviderImpl();
        PaintProvider paintProvider = new PaintProviderImpl();
        JavaFxThread.run(()-> {

            menuElement = new NormalMenuElement(uiProvider, positionAlignment, paintProvider, "Example");
        });

    }
//
//    @AfterEach
//    public void tearDown() {
//
//    }

    @Test
    void setText() {
    }

    @Test
    void getText() {
        Assert.assertEquals("Example", menuElement.getText());
        menuElement.setText("example234 example234");
        Assert.assertEquals("example234 example234", menuElement.getText());
    }

    @Test
    void setBorder() {

    }

    @Test
    void isVisible() {
        Assert.assertEquals(true, menuElement.isVisible());
        menuElement.hide();
        Assert.assertEquals(false, menuElement.isVisible());
        menuElement.show();
        Assert.assertEquals(true, menuElement.isVisible());

    }

    @Test
    void show() {
        Assert.assertEquals(true, menuElement.isVisible());
        menuElement.show();
        Assert.assertEquals(true, menuElement.isVisible());
    }

    @Test
    void hide() {
        Assert.assertEquals(true, menuElement.isVisible());
        menuElement.hide();
        Assert.assertEquals(false, menuElement.isVisible());
    }

    @Test
    void setBackground() {
    }

    @Test
    void getProvidedObject() {
    }

//    @Test
//    void toString() {
//        System.out.println("asds");
//    }

    @Test
    void setBackground1() {
    }

    @Test
    void getProvidedObject1() {
    }

    @Test
    void setBorder1() {
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
    void dispatchEvent() {
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
    void compareTo() {
    }

    @Test
    void getX() {
    }

    @Test
    void getY() {
    }

    @Test
    void XProperty() {
        Assert.assertNotNull( menuElement.XProperty());

    }

    @Test
    void YProperty() {
        Assert.assertNotNull( menuElement.YProperty());

    }

    @Test
    void setX() {
        Assert.assertEquals(0, menuElement.getX());
        menuElement.setX(3456);
        Assert.assertEquals(3456, menuElement.getX());
    }

    @Test
    void setY() {
        Assert.assertEquals(0, menuElement.getX());

    }

    @Test
    void setBackground2() {
    }

    @Test
    void getProvidedObject2() {
    }
}