package com.pacgame.provider.animation;

import com.pacgame.provider.IBuilderProvider;
import com.pacgame.Property;

public class AnimationBuilder implements IBuilderProvider<Animation> {

    private Animation buildedInstance;


    public AnimationBuilder createAnimation(Property<Integer> property, int endVal)
    {
        buildedInstance = new IntegerValueAnimation(property, endVal);

        return this;
    }

    @Override
    public Animation build() {
        return buildedInstance;
    }

}
