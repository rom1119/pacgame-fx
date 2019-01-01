package com.pacgame.provider.property;

public interface WritableValueProvider<T> {

    /**
     * Get the wrapped value.
     *
     * @return The current value
     */
    T get();

    /**
     * Set the wrapped value.
     *
     * @param value
     *            The new value
     */
    void set(T value);

}