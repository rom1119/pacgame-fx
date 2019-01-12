package com.pacgame.game.property;

import com.pacgame.game.ChangePropertyListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class ListProperty<T> {

    protected List<T> property;
    protected ChangePropertyListener<T> changeListener;

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

    public void addAll(List<T> val) {
        property.addAll(val);
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

    public Stream<T> stream()
    {
        return property.stream();
    }

    public void setOnChangeProperty(ChangePropertyListener val) {
        changeListener = val;
    }

    private void onChange(T oldVal, T newVal)
    {
        if (changeListener != null) {
            changeListener.onChange(oldVal, newVal);

        }
    }

    public int indexOf(T target)
    {
        return property.indexOf(target);
    }
}
