package com.pacgame.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Player extends Component {

    protected int checkedDirection = 0;

    public int getCheckedDirection() {
        return checkedDirection;
    }

    public void setCheckedDirection(int checkedDirection) {
        if (checkedDirection < 0 || checkedDirection > 3) {
            throw new IllegalArgumentException();
        }

        this.checkedDirection = checkedDirection;
    }

    public void moveLeft(int step) {

        int x = (int) point.getX();
        x = x - step;

        int currentPointY = (int) point.getY();

        point = point.add(x, currentPointY);
        collider.setTranslateX(x);
        icon.setTranslateX(x);
    }

    public void moveRight(int step) {

        int x = (int) point.getX();
        x = x + step;

        int currentPointY = (int) point.getY();


        point = point.add(x, currentPointY);
        collider.setTranslateX(x);
        icon.setTranslateX(x);
    }

    public void moveUp(int step) {
        int y = (int) point.getY();
        y = y - step;

        int currentPointX = (int) point.getX();


        point = point.add(currentPointX, y);
        collider.setTranslateY(y);
        icon.setTranslateY(y);
    }

    public void moveDown(int step) {



        int y = (int) point.getY();
        y = y - step;

        int currentPointX = (int) point.getX();


        point = point.add(currentPointX, y);
        collider.setTranslateY(y);
        icon.setTranslateY(y);

    }


}
