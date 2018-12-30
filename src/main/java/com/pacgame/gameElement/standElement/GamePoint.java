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



    public GamePoint(ShapeProvidedObject providedObject) {
        super( providedObject);

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
