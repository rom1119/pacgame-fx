package com.pacgame.game.adapter.board;

import com.pacgame.View;
import com.pacgame.game.adapter.ViewAdapter;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.gameElement.movingElement.Maze;

public class MazeAdapter extends ViewAdapter implements IMaze {

    private Maze providedObject;

    public MazeAdapter(Maze providedObject) {
        this.providedObject = providedObject;
    }

    @Override
    public int getValue() {
        return providedObject.getValue();
    }

    @Override
    public void changeToEaten() {

    }

    @Override
    public void setPosition(IMapPoint pacmanInitPosition) {
        providedObject.setX(pacmanInitPosition.getX());
        providedObject.setY(pacmanInitPosition.getY());
    }

    @Override
    public void changeToNormalCharacter() {

    }

    @Override
    public View getProvidedObject() {
        return providedObject;
    }
}
