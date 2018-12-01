package com.pacgame;


import com.pacgame.color.Paint;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;

public abstract class View implements Positionable, Colorable, Comparable<View>, Visible  {

    protected int id;

    protected Property<Integer> x;
    protected Property<Integer> y;
    protected int order;


    public View() {
    }

    public int getId() {
        return id;
    }

    @Override
    public abstract boolean isVisible();

    @Override
    public void show(){
        getProvidedObject().show();
    }


    @Override
    public void hide()
    {
        getProvidedObject().show();
    }

    @Override
    public int compareTo(View o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }


    @Override
    public int getX() {
        return x.get();
    }

    @Override
    public int getY() {
        return y.get();
    }

    @Override
    public Property<Integer> XProperty() {
        return x;
    }

    @Override
    public Property<Integer> YProperty() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x.set(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
    }

    @Override
    public void setBackground(Paint color)
    {
        getProvidedObject().setBackground(color.getValue());
    }

    protected abstract ViewProvidedObject getProvidedObject();
}
