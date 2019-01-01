package com.pacgame.provider.animation;

import com.pacgame.provider.Proxy;
import com.pacgame.provider.property.PropertyProvider;

class IntegerValueAnimation extends Animation {

    public IntegerValueAnimation(AnimationBuilder animationBuilder) {
        IntegerValueAnimationProxy.Builder builder = new IntegerValueAnimationProxy
                .Builder()
                .durationMilis(animationBuilder.durationMilis)
                .delayMilis(animationBuilder.delayMilis);

        if (animationBuilder.autoReverse == true) {
            builder.autoReverse();
        } else {
            builder.notAutoReverse();
        }

        if (animationBuilder.cycleCount == -1) {
            builder.infiniteAnimation();
        } else {
            builder.setCycleCount(animationBuilder.cycleCount);
        }

        animationBuilder.properties.forEach((endVal, prop) -> {
            builder.addAnimateProperty(prop, endVal);
        });

        this.proxy = builder.build();
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
