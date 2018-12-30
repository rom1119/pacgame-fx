package com.pacgame.game.board.model.pacman;


import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.exception.EatYourSelfException;
import com.pacgame.game.property.BaseProperty;
import com.pacgame.game.Eatable;
import com.pacgame.game.property.ScoreProperty;
import com.pacgame.game.property.ValueProperty;

public class Pacman implements IPacman {

    private static int INITIAL_VALUE = 10;
    private BaseProperty<Integer> score;
    private BaseProperty<Integer> value;

    private void initialize()
    {
        score = new ScoreProperty(0);
        value = new ValueProperty(INITIAL_VALUE);
    }

    public void turnLeft()
    {

    }

    @Override
    public void addScore(int scoreArg) {
        score.set(score.get() + scoreArg);
    }

    @Override
    public void eat(Eatable eatableEl) throws EatYourSelfException {
        if (eatableEl.equals(this)) {
            throw new EatYourSelfException();
        }

        addScore(eatableEl.getValue());
        eatableEl.changeToEaten();
    }

    @Override
    public int getValue() {
        return value.get();
    }

    @Override
    public void changeToEaten() {

    }

    @Override
    public void setPosition(IMapPoint pacmanInitPosition) {

    }
}
