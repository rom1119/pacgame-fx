package com.pacgame.scheme;

public interface SchemeStep<T> {

    T getTargetElement();

    boolean isComplete();

    void update();

    void onComplete();

    void setOnComplete(SchemeStepHandler handler);
}
