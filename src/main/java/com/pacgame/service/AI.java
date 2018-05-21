package com.pacgame.service;

import com.pacgame.model.MapPoint;
import com.pacgame.model.Player;

public class AI {

    private final int countFreeSteps = 10;

    private Player observer;
    private Player observable;


    public AI(Player observer, Player observable) {
        this.observer = observer;
        this.observable = observable;
    }

    public MapPoint getNextMapPoint()
    {

    }
}
