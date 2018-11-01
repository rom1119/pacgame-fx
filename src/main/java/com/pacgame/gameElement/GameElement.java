package com.pacgame.gameElement;

import com.pacgame.Component;
import com.pacgame.event.IEvent;
import com.pacgame.event.target.IGameEventTarget;
import javafx.scene.shape.Shape;

public abstract class GameElement extends Component implements IGameEventTarget {
    protected Shape icon;

    public GameElement(int width, int height) {
        super(width, height);
    }

    protected void initPosition()
    {
        icon.setTranslateX(x);
        icon.setTranslateY(y);

        icon.setLayoutX(x);
        icon.setLayoutY(y);

    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
