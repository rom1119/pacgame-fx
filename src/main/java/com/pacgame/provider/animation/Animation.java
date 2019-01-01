package com.pacgame.provider.animation;

import com.pacgame.provider.ProvidedObject;

public abstract class Animation extends ProvidedObject {

    protected AnimationProxy proxy;


    public abstract void play();
    public abstract void pause();
    public abstract void stop();

}
