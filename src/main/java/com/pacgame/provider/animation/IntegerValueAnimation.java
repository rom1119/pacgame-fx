package com.pacgame.provider.animation;

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
    public AnimationProxy getProxy() {
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
        proxy.stop();
    }
}
