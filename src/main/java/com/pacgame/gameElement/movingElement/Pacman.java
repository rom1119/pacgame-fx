package com.pacgame.gameElement.movingElement;

import com.pacgame.Property;
import com.pacgame.color.Paint;
import com.pacgame.gameElement.Eatable;
import com.pacgame.gameElement.MovedComponent;
import com.pacgame.gameElement.exception.EatYourSelfException;
import com.pacgame.property.RadiusProperty;
import com.pacgame.property.ScoreProperty;
import com.pacgame.property.ValueProperty;
import com.pacgame.provider.AnimationProvider;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.animation.Animation;
import com.pacgame.provider.animation.AnimationBuilder;
import com.pacgame.provider.component.shape.Arc;
import com.pacgame.provider.event.listener.ChangeListener;
import com.pacgame.provider.property.PropertyProvider;
import javafx.application.Platform;

public class Pacman extends MovedComponent implements Eatable {

    private static int INITIAL_VALUE = 10;
    protected Arc providedObject;
    protected Property<Integer> radius;
    private Property<Integer> score;
    private Property<Integer> value;
    private Animation eatAnimation;

    private AnimationBuilder animationBuilder;

    @Override
    public int getX() {
        return providedObject.getX();
    }

    @Override
    public int getY() {
        return providedObject.getY();
    }

    public Pacman(int radius, Arc providedObject, AnimationBuilder animationBuilder) {
        super(providedObject);
        this.providedObject = providedObject;
        this.animationBuilder = animationBuilder;
        this.radius = new RadiusProperty(radius);
        score = new ScoreProperty(0);
        value = new ValueProperty(INITIAL_VALUE);
        this.providedObject.setRadius(radius);
        this.providedObject.setStartAngle(45);
        this.providedObject.setLength(270);

        createEatAnimation();

    }

    private void createEatAnimation()
    {
        eatAnimation = animationBuilder
                .addAnimateProperty(providedObject.startAngleProperty(), 0)
                .addAnimateProperty(providedObject.lengthProperty(), 360)
                .infiniteAnimation()
                .autoReverse()
                .durationMilis(300)
                .build();
    }

    public void playEatAnimation()
    {

        eatAnimation.play();


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

    public void addScore(int scoreArg) {
        score.set(score.get() + scoreArg);
    }

    public void eat(Eatable eatableEl) throws EatYourSelfException {
        if (eatableEl.equals(this)) {
            throw new EatYourSelfException();
        }

        addScore(eatableEl.getValue());
        eatableEl.changeToEaten();
    }


    public void turnLeft() {
        getProvidedObject().setRotate(180);
    }

    public void turnRight() {
        getProvidedObject().setRotate(0);
    }

    public void turnUp() {
        getProvidedObject().setRotate(270);
    }

    public void turnDown() {
        getProvidedObject().setRotate(90);
    }



    @Override
    public int getValue() {
        return value.get();
    }

    @Override
    public void changeToEaten() {

    }
}
