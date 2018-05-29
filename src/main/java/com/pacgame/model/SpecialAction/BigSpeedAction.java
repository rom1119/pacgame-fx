package com.pacgame.model.SpecialAction;

import com.pacgame.model.Player;

public class BigSpeedAction extends SpecialAction {

    private static final int SPEED_MULTIPLIER = 5;
    private Player player;

    public BigSpeedAction(Player objectToModify) {
        super(objectToModify);
    }


    @Override
    public void startAction() {

        int currentSpeed = player.getSpeedMove();
        player.speedMoveProperty().set(currentSpeed - SPEED_MULTIPLIER);
    }

    @Override
    public void endAction() {

    }
}
