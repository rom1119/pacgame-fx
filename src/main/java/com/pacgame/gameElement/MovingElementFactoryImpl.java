package com.pacgame.gameElement;

import com.pacgame.color.ColorFactory;
import com.pacgame.gameElement.movingElement.*;
import com.pacgame.provider.ShapeProvider;

import java.util.Random;

public class MovingElementFactoryImpl implements MovingElementFactory {
    private static final int SIZE = 10;

    private ShapeProvider shapeProvider;
    private ColorFactory colorFactory;

    public MovingElementFactoryImpl(ShapeProvider shapeProvider, ColorFactory colorFactory) {
        this.shapeProvider = shapeProvider;
        this.colorFactory = colorFactory;
    }

    @Override
    public Maze createRandomMaze() {
        Random generator = new Random();
        int i = generator.nextInt(10) + 1;
        switch (i) {
            case 0:
                return new RedMaze(shapeProvider.createRectangle(SIZE, SIZE), colorFactory);
            case 1:
                return new BlueMaze(shapeProvider.createRectangle(SIZE, SIZE), colorFactory);
            case 2:
                return new GreenMaze(shapeProvider.createRectangle(SIZE, SIZE), colorFactory);
            case 3:
                return new AquaMaze(shapeProvider.createRectangle(SIZE, SIZE), colorFactory);
        }
        return null;
    }

    @Override
    public Pacman createPacman() {
        Pacman pacman = new Pacman(SIZE, shapeProvider.createArc(SIZE));
        pacman.setBackground(colorFactory.yellow());

        return pacman;
    }
}
