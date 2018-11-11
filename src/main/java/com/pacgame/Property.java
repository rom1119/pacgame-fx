package com.pacgame;

import com.pacgame.provider.event.ChangeListener;

public abstract class Property<T> {

    protected T property;
    protected ChangeListener<T> changeListener;

    public Property(T property) {
        this.property = property;
    }

    public T get() {
        return property;
    }

    public void set(T val) {
        property = val;
    }

    public void setOnChangeProperty(ChangeListener val) {
        changeListener = val;
    }

    private void onChange(T val)
    {
        if (changeListener != null) {
            changeListener.onChange(property, val);

        }
    }
}
