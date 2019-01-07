package com.pacgame.provider.animation;

import com.pacgame.provider.IBuilderProvider;
import com.pacgame.Property;
import com.pacgame.provider.property.PropertyProvider;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimationBuilder implements IBuilderProvider<Animation> {

    public Animation buildedInstance;
    public Map<Integer, PropertyProvider<Integer>> properties = new HashMap<>();
    public int cycleCount = 1;
    public int delayMilis = 0;
    public int durationMilis = 1000;
    public boolean autoReverse = false;

    void resetValues()
    {
        properties = new HashMap<>();
        durationMilis = 1000;
        cycleCount = 1;
        delayMilis = 0;
        autoReverse = false;
    }

    public AnimationBuilder addAnimateProperty(PropertyProvider<Integer> property, int endVal){
        properties.put(endVal, property);

        return this;
    }

    public AnimationBuilder delayMilis(int miliseconds)
    {
        delayMilis = miliseconds;

        return this;
    }

    public AnimationBuilder durationMilis(int miliseconds)
    {
        durationMilis = miliseconds;

        return this;
    }

    public AnimationBuilder autoReverse()
    {
        autoReverse = true;

        return this;
    }

    public AnimationBuilder setCycleCount(int count)
    {
        cycleCount = count;

        return this;
    }

    public AnimationBuilder infiniteAnimation()
    {
        cycleCount = -1;

        return this;
    }

    public AnimationBuilder notAutoReverse()
    {
        autoReverse = false;

        return this;
    }

    @Override
    public Animation build() {
        buildedInstance = new IntegerValueAnimation(this);
        resetValues();

        return buildedInstance;
    }

}
