package com.pacgame.provider.property;

import com.pacgame.provider.IProperty;
import com.pacgame.provider.event.ChangeListener;

public class TranslateXProperty implements IProperty<Integer> {

    private int property;
    private ChangeListener<Integer> changeListener;

    @Override
    public Integer get() {
        return property;
    }

    @Override
    public void set(Integer val) {
        changeListener.onChange(property, val);
        property = val;
    }

    @Override
    public void setOnChangeProperty(ChangeListener val) {
        changeListener = val;
    }
}
