package com.pacgame;


import com.pacgame.provider.IProvider;
import com.pacgame.provider.ProvidedObject;

public abstract class View {

    protected ProvidedObject providedObject;


    abstract IProvider getProvider();

}
