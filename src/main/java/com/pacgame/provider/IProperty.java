package com.pacgame.provider;

import com.pacgame.provider.event.ChangeListener;

public interface IProperty<T> {

    T get();

    void set(T val);
    void setOnChangeProperty(ChangeListener val);
}
