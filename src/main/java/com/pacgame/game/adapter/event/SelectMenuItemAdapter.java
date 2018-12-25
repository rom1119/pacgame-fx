package com.pacgame.game.adapter.event;

import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;
import com.pacgame.game.event.ui.SelectMenuItem;

public class SelectMenuItemAdapter implements SelectMenuItem {

    private Source source;
    private Target target;

    public SelectMenuItemAdapter(Source source, Target target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public Source getSource() {
        return source;
    }

    @Override
    public Target getTarget() {
        return target;
    }
}
