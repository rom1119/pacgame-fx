package com.pacgame.provider.event;

import com.pacgame.provider.IProperty;

public interface ChangeListener<T> {

    void onChange(T oldVal, T newVal);
}
