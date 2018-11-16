package com.pacgame.provider.animation;

import com.pacgame.provider.property.PropertyProvider;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class IntegerValueAnimationProxy extends AnimationProxy {


    private IntegerValueAnimationProxy(Builder builder) {
        super();
        Collection<KeyValue> keyValues = new ArrayList<>();
        builder.properties.stream().forEach((el) -> {
             keyValues.add(newIntegerKeyValue(el, builder.endValue, defaultInterpolator));
        });

        addAnimationFrame(Duration.millis(DEFAULT_SPEED_MILIS), keyValues);
        proxyObject.setDelay(builder.delay);
        proxyObject.setAutoReverse(builder.autoReverse);
        proxyObject.setCycleCount(builder.cycleCount);

    }

    private KeyValue newIntegerKeyValue(PropertyProvider<Integer> property, int endValue, Interpolator interpolator)
    {
        KeyValue val = new KeyValue(new WritableValue<Integer>() {
            @Override
            public Integer getValue() {
                return property.get();
            }

            @Override
            public void setValue(Integer value) {
                property.set(value);
            }
        }, endValue, interpolator);


//        KeyFrame labelText = new KeyFrame(Duration.millis(calculateAnimationDuration()), new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (score != null) {
//                    Platform.runLater(new Runnable() {
//                        public void run() {
//                            double translateYObject = getObjectToMove().getCollider().getTranslateX();
//                            double pointY = getObjectToMove().getIcon().getTranslateY();
//                            score.setText(String.valueOf("X = " + translateYObject + "Y = " + pointY));
//                        }
//                    });
//                }
//            }
//        });

        return val;


    }

    private KeyFrame addAnimationFrame(Duration duration, KeyValue... values)
    {
        KeyFrame keyFrame = new KeyFrame(duration, values);
        this.keyFrames.add(keyFrame);

        return keyFrame;
    }

    private KeyFrame addAnimationFrame(Duration duration, Collection<KeyValue> values)
    {
        KeyFrame keyFrame = new KeyFrame(duration);
        keyFrame.getValues().addAll(values);
        this.keyFrames.add(keyFrame);

        return keyFrame;
    }

    @Override
    public void play()
    {
        proxyObject.getKeyFrames().clear();
        proxyObject.getKeyFrames().addAll(keyFrames);
        proxyObject.play();
    }

    @Override
    public void pause() {
        proxyObject.pause();
    }

    @Override
    public void stop() {
        proxyObject.stop();
    }

    public static class Builder {

        private List<PropertyProvider<Integer>> properties;
        private int endValue;
        private int cycleCount = 1;
        private Duration delay = Duration.millis(0);
        private boolean autoReverse = false;
        private PropertyProvider<Integer> property;

        public Builder animateProperty(PropertyProvider<Integer> property){
            properties.add(property);

            return this;
        }

        public Builder to(int val)
        {
            endValue = val;

            return this;
        }

        public Builder delayMilis(int miliseconds)
        {
            delay = Duration.millis(miliseconds);

            return this;
        }

        public Builder autoReverse()
        {
            autoReverse = true;

            return this;
        }

        public Builder setCycleCount(int count)
        {
            cycleCount = count;

            return this;
        }

        public Builder infiniteAnimation()
        {
            cycleCount = Timeline.INDEFINITE;

            return this;
        }

        public Builder notAutoReverse()
        {
            autoReverse = false;

            return this;
        }

        public IntegerValueAnimationProxy build()
        {
            return new IntegerValueAnimationProxy(this);
        }

        public Builder setProperty(PropertyProvider<Integer> property) {
            this.property = property;
            return this;
        }

        public PropertyProvider createProperty() {
            return new Property(property);
        }
    }
}
