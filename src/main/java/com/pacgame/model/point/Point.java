package com.pacgame.model.point;

import com.pacgame.model.Component;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Point extends Component {

    protected int value = 1;

    public Point(Point2D point, int size, String imageSrc) {

        this.point = point;
        this.width = size;
        this.height = size;

        collider = new Rectangle(point.getX(), point.getY(), width, height);
//        icon = new Circle();

        collider.setFill(new Color(0, 1, 0, 0.7));

        Image image = new Image(imageSrc);

        this.icon = new Rectangle(point.getX(), point.getY(), width, height);

        this.icon.setFill(new ImagePattern(image));

//        this.icon.setStroke(Color.RED);


//        this.icon.setRotate(0);

//        this.icon.setFill(Color.YELLOW);

        initPosition();

        this.getIcon().setTranslateX(this.point.getX());
        this.getIcon().setTranslateY(this.point.getY());

        this.getCollider().setTranslateX(this.point.getX());
        this.getCollider().setTranslateY(this.point.getY());

        this.getIcon().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println(getIcon().getTranslateY());
            }
        });

        this.setPoint(this.point);
    }

    protected void initPosition()
    {
        collider.setTranslateX(point.getX());
        collider.setTranslateY(point.getY());

        collider.setLayoutX(0);
        collider.setLayoutY(0);

        icon.setTranslateX(point.getX() + (width));
        icon.setTranslateY(point.getY() + (height));

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
