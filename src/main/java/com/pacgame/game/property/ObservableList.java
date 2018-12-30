package com.pacgame.game.property;

import com.pacgame.game.event.Target;

import java.util.List;

public class ObservableList<T extends Target> extends ListProperty<T> {
    public ObservableList() {
    }

    public ObservableList(List<T> property) {
        super(property);
    }
}
