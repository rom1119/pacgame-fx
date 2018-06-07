package com.pacgame.view;

import com.pacgame.model.Pacman;
import javafx.geometry.Point2D;
import javafx.scene.Scene;

public class Factory {

    public static Pacman createPacman(Point2D point2D, int radius)
    {
        return new Pacman(point2D, radius);
    }

    public static Map createMap(String imageUrl)
    {
        return new Map(imageUrl);
    }

    public static GameInfo createGameInfo()
    {
        return new GameInfo();
    }

    public static EntryTimer createEntryTimer()
    {
        return new EntryTimer();
    }

    public static MainMenu createMainMenu(Scene scene)
    {
        return new MainMenu(scene);
    }

    public static ContextMenu createContextMenu(Scene scene)
    {
        return new ContextMenu(scene);
    }

    public static MainSettings createMainSettings()
    {
        return new MainSettings();
    }

    public static ContextSettings createContextSettings()
    {
        return new ContextSettings();
    }


}
