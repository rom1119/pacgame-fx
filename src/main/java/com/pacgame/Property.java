package com.pacgame;


import com.pacgame.event.listener.ChangeListener;

public abstract class Property<T> {

    protected T property;
    protected ChangeListener<T> changeListener;

    public Property() {
    }

    public Property(T property) {
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

    public void setOnChangeProperty(ChangeListener val) {
        changeListener = val;
    }

    private void onChange(T oldVal, T newVal)
    {
        if (changeListener != null) {
            changeListener.onChange(oldVal, newVal);

        }
    }
}
