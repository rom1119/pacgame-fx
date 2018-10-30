package com.pacgame.board.model.SpecialAction;

import com.pacgame.board.Controller;
import com.pacgame.board.model.Maze;
import com.pacgame.board.model.Player;

public class BlueEnemyAction extends SpecialAction {

    public BlueEnemyAction(Controller objectControllerToModify) {
        super(objectControllerToModify);
    }

    @Override
    public void startAction() {

        String blueBackgroundSrc = "./enemy/blue/main.png";
//        Maze objectModify = (Maze) this.getObjectToModify();
//        objectModify.setIconBackground(blueBackgroundSrc);
//        objectModify.setEatable(true);

    }

    @Override
    public void backAction() {

    }

    @Override
    public void endAction() {

    }

    @Override
    public boolean tryStartAction() {
        return false;
    }

    @Override
    public boolean isClone() {
        return false;
    }
}
