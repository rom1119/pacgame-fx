package com.pacgame;

public interface IBuilder<T> {

    T build() throws IllegalAccessException, InstantiationException;
}
