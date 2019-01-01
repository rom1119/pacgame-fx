package com.pacgame.gameElement;

import com.pacgame.color.ColorFactory;
import com.pacgame.gameElement.movingElement.*;
import com.pacgame.provider.AnimationProvider;
import com.pacgame.provider.ShapeProvider;

import java.util.Random;

public class MovingElementFactoryImpl implements MovingElementFactory {
    private static final int SIZE_PACMAN = 10;
    private static final int SIZE_MAZE = 20;

    private ShapeProvider shapeProvider;
    private ColorFactory colorFactory;
    private AnimationProvider animationProvider;

    public MovingElementFactoryImpl(ShapeProvider shapeProvider, ColorFactory colorFactory, AnimationProvider animationProvider) {
        this.shapeProvider = shapeProvider;
        this.colorFactory = colorFactory;
        this.animationProvider = animationProvider;
    }

    @Override
    public Maze createRandomMaze() {
        Random generator = new Random();
        int i = generator.nextInt(2);
        switch (i) {
            case 0:
                return new RedMaze(shapeProvider.createRectangle(SIZE_MAZE, SIZE_MAZE), colorFactory);
            case 1:
                return new YellowMaze(shapeProvider.createRectangle(SIZE_MAZE, SIZE_MAZE), colorFactory);
            case 2:
                return new AquaMaze(shapeProvider.createRectangle(SIZE_MAZE, SIZE_MAZE), colorFactory);
        }
        return null;
    }

    @Override
    public Pacman createPacman() {
        Pacman pacman = new Pacman(SIZE_PACMAN, shapeProvider.createArc(SIZE_PACMAN), animationProvider.animationBuilder());
        pacman.setBackground(colorFactory.yellow());

        return pacman;
    }
}
