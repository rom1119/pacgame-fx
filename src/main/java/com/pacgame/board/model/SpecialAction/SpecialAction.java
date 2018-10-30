package com.pacgame.board.model.SpecialAction;

import com.pacgame.board.Controller;
import com.pacgame.board.model.Player;

public abstract class SpecialAction {

    private Controller objectControllerToModify;

    public SpecialAction(Controller objectControllerToModify) {
        this.objectControllerToModify = objectControllerToModify;
    }

    public Controller getObjectControllerToModify() {
        return objectControllerToModify;
    }

    public void setObjectControllerToModify(Controller objectControllerToModify) {
        this.objectControllerToModify = objectControllerToModify;
    }

    public abstract void startAction();
    public abstract void backAction();
    public abstract void endAction();
    public abstract boolean tryStartAction();
    public abstract boolean isClone();
}
