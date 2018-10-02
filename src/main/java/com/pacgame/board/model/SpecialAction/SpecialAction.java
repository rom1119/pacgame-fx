package com.pacgame.board.model.SpecialAction;

import com.pacgame.board.model.Player;

public abstract class SpecialAction {

    private Player objectToModify;

    public SpecialAction(Player objectToModify) {
        this.objectToModify = objectToModify;
    }

    public Player getObjectToModify() {
        return objectToModify;
    }

    public void setObjectToModify(Player objectToModify) {
        this.objectToModify = objectToModify;
    }

    public abstract void startAction();
    public abstract void endAction();
}
