package com.pacgame.game.property;

import com.pacgame.game.ChangePropertyListener;

public abstract class BaseProperty<T> {

    protected T property;
    protected ChangePropertyListener<T> changeListener;

    public BaseProperty(T property) {
        this.property = property;
    }

    public T get() {
        return property;
    }

    public void set(T val) {
        T oldVal = property;
        property = val;
        onChange(oldVal, property);
    }

    public void setOnChangeProperty(ChangePropertyListener val) {
        changeListener = val;
    }

    private void onChange(T oldVal, T newVal)
    {
        if (changeListener != null) {
            changeListener.onChange(oldVal, newVal);

        }
    }
}
