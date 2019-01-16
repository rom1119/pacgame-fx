package com.pacgame.game.adapter.board.finder.shema;

import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.board.model.maze.IMaze;

import java.util.ArrayList;
import java.util.List;

public class FinderScheme {

    private Moveable finderObject;
    private List<SchemeStep> steps;
    private int pointer = -1;

    public FinderScheme(Moveable finderObject) {
        this.finderObject = finderObject;
        steps = new ArrayList<>();
    }

    public ObjectToFind2D find()
    {
        updateStep();
        if (thisStep().isComplete()) {
            thisStep().onComplete();
            changeStep();
        }

        return thisStep().getTargetElement();
    }

    private void changeStep()
    {
        if (pointer < steps.size() - 1) {
            nextStep();
        } else {
            prevStep();
        }
    }


    private void updateStep() {
        thisStep().update();
    }

    private SchemeStep thisStep()
    {
        return steps.get(pointer);
    }

    public void addStepTarget(int index, SchemeStep el){

        steps.add(index, el);

        pointer = 0;
    }

    public SchemeStep nextStep()
    {
        if (steps.size() >= pointer + 1) {
            pointer++;
        }

        return steps.get(pointer);
    }

    public SchemeStep prevStep()
    {
        if (pointer - 1 >= -1) {
            pointer--;
        }

        return steps.get(pointer);
    }

}
