package com.pacgame.provider.animation;

import com.pacgame.provider.IBuilder;
import com.pacgame.provider.IProperty;

public class AnimationBuilder implements IBuilder<Animation> {

    private Animation buildedInstance;


    public AnimationBuilder createAnimation(IProperty<Integer> property, int endVal)
    {
        buildedInstance = new IntegerValueAnimation(property, endVal);

        return this;
    }

    @Override
    public Animation build() {
        return buildedInstance;
    }

    @Override
    public Animation buildedObject() {
        return buildedInstance;
    }
}
