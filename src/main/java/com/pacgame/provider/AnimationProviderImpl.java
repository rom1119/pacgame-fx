package com.pacgame.provider;

import com.pacgame.provider.animation.AnimationBuilder;

public class AnimationProviderImpl implements AnimationProvider {

    private AnimationBuilder animationBuilder;

    public AnimationProviderImpl() {
        animationBuilder = new AnimationBuilder();
    }

    @Override
    public AnimationBuilder animationBuilder() {
        return animationBuilder;
    }
}
