package com.pacgame.provider.animation;

import com.pacgame.provider.Proxy;
import com.pacgame.provider.property.PropertyProvider;

class IntegerValueAnimation extends Animation {

    public IntegerValueAnimation(PropertyProvider<Integer> property, int endVal) {
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
