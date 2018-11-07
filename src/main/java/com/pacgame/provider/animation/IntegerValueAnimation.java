package com.pacgame.provider.animation;

import com.pacgame.provider.IProperty;
import com.pacgame.provider.IProxy;

class IntegerValueAnimation extends Animation {

    public IntegerValueAnimation(IProperty<Integer> property, int endVal) {
        this.proxy = new IntegerValueAnimationProxy
                        .Builder()
                        .animateProperty(property)
                        .to(endVal)
                        .build();
    }

    @Override
    public IProxy getProxy() {
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
