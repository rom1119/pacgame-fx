package com.pacgame.game;

public interface ChangePropertyListener<T> {

    void onChange(T oldVal, T newVal);

}
