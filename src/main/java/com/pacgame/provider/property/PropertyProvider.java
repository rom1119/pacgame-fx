package com.pacgame.provider.property;

import com.pacgame.provider.event.listener.ChangeListener;

public abstract class PropertyProvider<T> {

    protected T property;
    protected ChangeListener<T> changeListener;

    public PropertyProvider() {
    }

    public PropertyProvider(T property) {
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
