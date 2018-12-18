package com.pacgame.property;

import com.pacgame.ListProperty;
import com.pacgame.Property;
import com.pacgame.View;

import java.util.List;

public class ListViewProperty<T extends View> extends ListProperty<T> {

    public ListViewProperty() {
        super();
    }

    public ListViewProperty(List<T> property) {
        super(property);
    }
}
