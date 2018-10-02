package com.pacgame.ui.component;

import com.pacgame.View;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Map extends View {

    protected String imgPath;

    public Map(String imgPath) {
        this.imgPath = imgPath;


    }

    public Node getView(int width, int height)
    {
        Canvas canvas = new Canvas(width, height);


        Image img = new Image(imgPath);
        ImageView imageView = new ImageView(img);

        GraphicsContext g = canvas.getGraphicsContext2D();


//        g.setFill(Color.AQUA);

        g.drawImage(img, 0, 0, width, height);
//        g.setGlobalBlendMode(BlendMode.SCREEN);

//        g.fillText("asdasd", 200, 200);

//        g.fillRect(100, 100, 100, 100);


        return canvas;
    }
}
