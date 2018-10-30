package com.pacgame.board.model.SpecialAction;

import com.pacgame.board.Controller;
import com.pacgame.board.model.Player;

public class BigSpeedAction extends SpecialAction {

    private static final int SPEED_MULTIPLIER = 5;
    private Player player;

    public BigSpeedAction(Controller objectControllerToModify, Player player) {
        super(objectControllerToModify);
        this.player = player;
    }

    @Override
    public void startAction() {


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
