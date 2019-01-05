package com.pacgame.provider.animation;

import com.pacgame.provider.Proxy;
import com.pacgame.provider.event.IEventHandlerProvider;
import com.pacgame.provider.event.type.ActionEvent;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.util.ArrayList;
import java.util.List;

abstract class AnimationProxy extends Proxy {
    protected Timeline proxyObject;
    protected List<KeyFrame> keyFrames;
    protected Interpolator defaultInterpolator = Interpolator.LINEAR;
    public final int DEFAULT_SPEED_MILIS = 10000;

    AnimationProxy() {
        this.proxyObject = new Timeline();
        this.keyFrames = new ArrayList<>();
    }

    public void setOnFinished(IEventHandlerProvider<ActionEvent> eventHandler, ActionEvent event)
    {

        getProxyObject().setOnFinished(e -> {

//            event.initTarget(e.getTarget().hashCode());
            event.getProxy().setProxyObject(e);
            eventHandler.handle(event);
        });
    }

    @Override
    protected Timeline getProxyObject() {
        return proxyObject;
    }

    public abstract void play();
    public abstract void pause();
    public abstract void stop();

}
