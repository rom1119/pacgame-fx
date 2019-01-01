package com.pacgame.provider.animation;

import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WritableValueProvider;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.util.Duration;

import java.util.*;

class IntegerValueAnimationProxy extends AnimationProxy {


    private IntegerValueAnimationProxy(Builder builder) {
        super();
        Collection<KeyValue> keyValues = new ArrayList<>();
        builder.properties.forEach(( key , el) -> {
             keyValues.add(newIntegerKeyValue(el, key, defaultInterpolator));
        });

        addAnimationFrame(builder.duration, keyValues);
        proxyObject.setDelay(builder.delay);
        proxyObject.setAutoReverse(builder.autoReverse);
        proxyObject.setCycleCount(builder.cycleCount);

    }

    private KeyValue newIntegerKeyValue(WritableValueProvider<Integer> property, int endValue, Interpolator interpolator)
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

    private void addAnimationFrame(Duration duration, Collection<? extends KeyValue> values)
    {
        values.forEach(el -> {
            KeyFrame keyFrame = new KeyFrame(duration, el);
            this.keyFrames.add(keyFrame);

        });

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

    @Override
    protected Timeline getProxyObject() {
        return proxyObject;
    }

    public static class Builder {

        public Duration duration = Duration.millis(1000);
        private Map<Integer, PropertyProvider<Integer>> properties = new HashMap<>();
        private int endValue;
        private int cycleCount = 1;
        private Duration delay = Duration.millis(0);
        private boolean autoReverse = false;
        private PropertyProvider<Integer> property;

        public Builder addAnimateProperty(PropertyProvider<Integer> property, int endVal){
            properties.put(endVal, property);

            return this;
        }

        public Builder delayMilis(int miliseconds)
        {
            delay = Duration.millis(miliseconds);

            return this;
        }

        public Builder delaySeconds(int seconds)
        {
            delay = Duration.seconds(seconds);

            return this;
        }

        public Builder durationMilis(int miliseconds)
        {
            duration = Duration.millis(miliseconds);

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

    }
}
