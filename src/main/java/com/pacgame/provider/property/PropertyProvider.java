package com.pacgame.provider.property;

import com.pacgame.provider.event.listener.ChangeListener;

public abstract class PropertyProvider<T> implements WritableValueProvider<T> {

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
        T oldVal = property;
        property = val;
        onChange(oldVal, property);
    }

    public void setOnChangeProperty(ChangeListener<T> val) {
        changeListener = val;
    }

    private void onChange(T oldVal, T newVal)
    {
        if (changeListener != null) {
            changeListener.onChange(oldVal, newVal);

        }
    }
}
