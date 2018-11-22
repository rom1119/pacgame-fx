package com.pacgame.gameElement.standElement;

import com.pacgame.gameElement.StandComponent;
import com.pacgame.gameElement.Valuable;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.component.ShapeProvidedObject;

public abstract class EatableElement extends StandComponent implements Valuable {

    protected int value = 1;
    protected boolean isVisible = true;
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    protected ShapeProvidedObject providedObject;


    public EatableElement(int width, int height, ShapeProvidedObject providedObject) {
        super(width, height, providedObject);
        this.providedObject = providedObject;
    }

    public EatableElement(ComponentProvidedObject providedObject) {
        super(WIDTH, HEIGHT, providedObject);
    }

    protected void initPosition()
    {
//        providedObject.setX(point.getX());
//        collider.setTranslateY(point.getY());
//
//        collider.setLayoutX(0);
//        collider.setLayoutY(0);

    }
}
