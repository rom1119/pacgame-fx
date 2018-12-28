package com.pacgame.game.adapter.event;

import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;
import com.pacgame.game.event.ui.ButtonAction;

public class ButtonActionAdapter extends ButtonAction {
    public ButtonActionAdapter(Source source, Target target) {
        super(source, target);
    }
}
