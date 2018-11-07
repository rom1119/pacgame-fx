package com.pacgame.provider;

public interface IMovementProvider2D extends IMovementProvider {

    void moveLeft(ComponentProvidedObject component, int x);
    void moveRight(ComponentProvidedObject component, int x);
    void moveUp(ComponentProvidedObject component, int y);
    void moveDown(ComponentProvidedObject component, int y);
}
