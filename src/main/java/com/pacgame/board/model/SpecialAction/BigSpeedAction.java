package com.pacgame.board.model.SpecialAction;

import com.pacgame.board.model.Player;

public class BigSpeedAction extends SpecialAction {

    private static final int SPEED_MULTIPLIER = 5;
    private Player player;

    public BigSpeedAction(Player objectToModify) {
        super(objectToModify);
    }


    @Override
    public void startAction() {


    }

    @Override
    public void endAction() {

    }
}
