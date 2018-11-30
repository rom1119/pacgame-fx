package com.pacgame.gameElement.movingElement;

import com.pacgame.Property;
import com.pacgame.color.Paint;
import com.pacgame.gameElement.MovedComponent;
import com.pacgame.property.RadiusProperty;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.shape.Arc;

public class Pacman extends MovedComponent {

    protected Arc providedObject;
    protected Property<Integer> radius;

    public Pacman(int radius, Arc providedObject) {
        super(providedObject);
        this.providedObject = providedObject;
        this.radius = new RadiusProperty(radius);
        this.providedObject.setRadius(radius);
    }

    @Override
    public boolean isVisible() {
        return providedObject.isVisible();
    }

    @Override
    public void show() {
        providedObject.show();
    }

    @Override
    public void hide() {
        providedObject.hide();
    }

    @Override
    public void setBackground(Paint color) {
        providedObject.setBackground(color.getValue());
    }

    @Override
    protected Arc getProvidedObject() {
        return providedObject;
    }
}
