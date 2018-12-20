package com.pacgame.game;

import com.pacgame.game.event.Target;

public interface Eatable extends Target {

    int getValue();

    void changeToEaten();

}
