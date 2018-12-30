package com.pacgame.gameElement.movingElement;

import com.pacgame.color.ColorFactory;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.component.shape.Rectangle;

public class RedMaze extends Maze {

    public static final String PREFIX_IMAGE_URL = "./enemy/red/";

    public RedMaze(Rectangle providedObject, ColorFactory colorFactory) {
        super(providedObject, colorFactory);
    }


    @Override
    public String getUpBackgroundUrl() {
        return PREFIX_IMAGE_URL + "up.png";
    }

    @Override
    public String getDownBackgroundUrl() {
        return PREFIX_IMAGE_URL + "down.png";
    }

    @Override
    public String getLeftBackgroundUrl() {
        return PREFIX_IMAGE_URL + "left.png";
    }

    @Override
    public String getRightBackgroundUrl() {
        return PREFIX_IMAGE_URL + "right.png";
    }

    @Override
    public String getCenterBackgroundUrl() {
        return PREFIX_IMAGE_URL + "main.png";
    }
}
