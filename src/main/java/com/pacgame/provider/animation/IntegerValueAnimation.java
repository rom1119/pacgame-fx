package com.pacgame.provider.animation;

import com.pacgame.Property;
import com.pacgame.provider.Proxy;

class IntegerValueAnimation extends Animation {

    public IntegerValueAnimation(Property<Integer> property, int endVal) {
        this.proxy = new IntegerValueAnimationProxy
                        .Builder()
                        .animateProperty(property)
                        .to(endVal)
                        .build();
    }

    @Override
    public Proxy getProxy() {
        return proxy;
    }

    @Override
    public void play() {
        proxy.play();
    }

    @Override
    public void pause() {
        proxy.pause();
    }

    @Override
    public void stop() {

    }
}
