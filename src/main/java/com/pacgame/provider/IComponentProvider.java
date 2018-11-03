package com.pacgame.provider;

public interface IComponentProvider extends IProvider {

    @Override
    ComponentProvidedObject provide();
}
