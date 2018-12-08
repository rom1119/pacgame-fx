package com.pacgame.provider;

import com.pacgame.provider.animation.AnimationBuilder;

class Movement2D extends MovementProvider2D {

    private AnimationBuilder animationBuilder;

    public Movement2D() {
        animationBuilder = new AnimationBuilder();
    }

    @Override
    public void moveLeft(ComponentProvidedObject component, int x) {
        animationBuilder.createAnimation(component.XProperty(), x).build();
    }

    @Override
    public void moveRight(ComponentProvidedObject component, int x) {

    }

    @Override
    public void moveUp(ComponentProvidedObject component, int y) {

    }

    @Override
    public void moveDown(ComponentProvidedObject component, int y) {

    }
}
