package com.pacgame.scheme.impl;

import com.pacgame.scheme.Scheme;
import com.pacgame.scheme.SchemeStep;

import java.util.ArrayList;
import java.util.List;

public class FinderScheme<T> implements Scheme<T> {

    private List<SchemeStep<T>> steps;
    private int pointer = -1;

    public FinderScheme() {
        steps = new ArrayList<>();
    }

    public T check()
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

    private SchemeStep<T> thisStep()
    {
        return steps.get(pointer);
    }


    public void addStep(int index, SchemeStep<T> el){

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
