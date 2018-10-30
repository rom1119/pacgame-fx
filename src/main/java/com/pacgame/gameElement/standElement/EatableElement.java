package com.pacgame.gameElement.standElement;

import com.pacgame.gameElement.StandComponent;
import com.pacgame.gameElement.Valuable;

public abstract class EatableElement extends StandComponent implements Valuable {

    protected int value = 1;
    protected boolean isVisible = true;
}
