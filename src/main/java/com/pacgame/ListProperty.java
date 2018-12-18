package com.pacgame;

import com.pacgame.event.listener.ChangeListener;
import com.pacgame.provider.component.ui.text.Label;

import java.util.ArrayList;
import java.util.List;

public abstract class ListProperty<T> {

    protected List<T> property;
    protected ChangeListener<T> changeListener;

    public ListProperty() {
        property = new ArrayList<>();
    }

    public ListProperty(List<T> property) {
        this.property = property;
    }

    public T get(int index) {
        return property.get(index);
    }

    public List<T> getAll()
    {
        return property;
    }

    public void add(T val) {
        property.add(val);
    }

    public void remove(T val) {
        property.remove(val);
    }

    public void remove(int index) {
        property.remove(index);
    }

    public int size()
    {
        return property.size();
    }

    public boolean isEmpty()
    {
        return property.isEmpty();
    }

    public void setOnChangeProperty(ChangeListener val) {
        changeListener = val;
    }

    private void onChange(List<T> val)
    {
        if (changeListener != null) {
//            changeListener.onChange(property, val);

        }
    }

    public int indexOf(T target)
    {
        return property.indexOf(target);
    }
}