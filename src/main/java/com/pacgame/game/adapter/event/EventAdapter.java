package com.pacgame.game.adapter.event;

import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public abstract class EventAdapter {

    protected Source source;
    protected Target target;

    public EventAdapter(Source source, Target target) {
        this.source = source;
        this.target = target;
    }

    public Source getSource() {
        return source;
    }

    public Target getTarget() {
        return target;
    }
}
