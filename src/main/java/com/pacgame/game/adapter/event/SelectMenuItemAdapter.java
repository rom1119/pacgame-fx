package com.pacgame.game.adapter.event;

import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;
import com.pacgame.game.event.ui.SelectMenuItem;

public class SelectMenuItemAdapter extends SelectMenuItem {


    public SelectMenuItemAdapter(Source source, Target target) {
        super(source, target);
    }
}
