package com.pacgame.board.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Component {

//    private Rectangle icon;
    
    public Block(Point2D point, int width, int height) {

        this.point = point;
        this.width = width;
        this.height = height;

        collider = new Rectangle(point.getX(), point.getY(), width, height);
//        icon = new Circle();

        collider.setFill(new Color(0, 1, 0, 0.7));

        this.icon = new Rectangle();


//        this.icon.setRotate(0);

        this.icon.setFill(Color.YELLOW);

        initPosition();

//        turnUp();

//        setCheckedDirection(Direction.UP);

//        moveDown(30);

//        this.icon.set

//        Image img = new Image("/image/rifat.jpg");
//        rectangle.setFill(new ImagePattern(img));

    }
}
