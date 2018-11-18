package com.pacgame.provider.animation;

import com.pacgame.provider.IBuilderProvider;
import com.pacgame.Property;
import com.pacgame.provider.property.PropertyProvider;

public class AnimationBuilder implements IBuilderProvider<Animation> {

    private Animation buildedInstance;


    public AnimationBuilder createAnimation(PropertyProvider<Integer> property, int endVal)
    {
        buildedInstance = new IntegerValueAnimation(property, endVal);

        return this;
    }

    @Override
    public Animation build() {
        return buildedInstance;
    }

}
