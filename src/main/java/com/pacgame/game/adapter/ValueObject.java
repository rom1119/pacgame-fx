package com.pacgame.game.adapter;

public class ValueObject<T> {

    private T oldValue;

    private T value;

    public ValueObject() {
    }

    public T getOldValue() {
        return oldValue;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        if (oldValue == null) {
            oldValue = value;
        } else {
            oldValue = this.value;
        }
        this.value = value;
    }
}
