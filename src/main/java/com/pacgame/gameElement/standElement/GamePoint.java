package com.pacgame.gameElement.standElement;

import com.pacgame.Property;
import com.pacgame.gameElement.StandComponent;
import com.pacgame.gameElement.Valuable;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.component.ShapeProvidedObject;

public abstract class GamePoint extends StandComponent implements Valuable {

    protected int value = 1;
    protected boolean isVisible = true;
    protected Property<Integer> width;
    protected Property<Integer> height;


    public GamePoint(int width, int height, ShapeProvidedObject providedObject) {
        this( providedObject);

    }

    public GamePoint(ShapeProvidedObject providedObject) {
        super(providedObject);
        this.width = new WidthProperty(0);
        this.height = new HeightProperty(0);
    }

    public int getWidth() {
        return (int) this.width.get();
    }

    public void setWidth(int width) {
        this.width.set(width);
    }

    public int getHeight() {
        return (int) this.height.get();
    }

    public void setHeight(int height) {
        this.height.set(height);
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
