package com.pacgame.view;

import com.pacgame.model.Pacman;
import javafx.geometry.Point2D;

public class Factory {

    public static Pacman createPacman(Point2D point2D, int radius)
    {
        return new Pacman(point2D, radius);
    }

    public static Map createMap(String imageUrl)
    {
        return new Map(imageUrl);
    }
}
