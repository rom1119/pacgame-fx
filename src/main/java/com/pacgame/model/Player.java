package com.pacgame.model;

public abstract class Player extends Component {


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
