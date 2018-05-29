package com.pacgame.model.SpecialAction;

import com.pacgame.model.Maze;
import com.pacgame.model.Player;

public class BlueEnemyAction extends SpecialAction {
    public BlueEnemyAction(Player objectToModify) {
        super(objectToModify);
    }

    @Override
    public void startAction() {

        String blueBackgroundSrc = "./enemy/blue/main.png";
        Maze objectModify = (Maze) this.getObjectToModify();
        objectModify.setIconBackground(blueBackgroundSrc);
        objectModify.setEatable(true);

    }

    @Override
    public void endAction() {

    }
}
