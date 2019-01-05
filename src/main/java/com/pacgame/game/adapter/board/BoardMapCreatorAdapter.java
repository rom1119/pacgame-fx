package com.pacgame.game.adapter.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.adapter.LayerAdapter;
import com.pacgame.game.adapter.board.movement.MovementFactory;
import com.pacgame.game.board.BoardMap;
import com.pacgame.game.board.BoardMapCreator;
import com.pacgame.game.board.application.IMovement;
import com.pacgame.gameElement.GameElementFacade;
import com.pacgame.gameElement.PointFactory;
import com.pacgame.map.Level;
import com.pacgame.map.LevelsFacade;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.layer.GroupLayer;

public class BoardMapCreatorAdapter implements BoardMapCreator {

    private LevelsFacade levelsFacade;
    private GameElementFacade gameElementFacade;
    private LayerFactory layerFactory;
    private MovementFactory movementFactory;


    public BoardMapCreatorAdapter(LevelsFacade levelsFacade, GameElementFacade gameElementFacade, LayerFactory layerFactory) {
        this.levelsFacade = levelsFacade;
        this.gameElementFacade = gameElementFacade;
        this.layerFactory = layerFactory;
    }

    public void setMovementFactory(MovementFactory movementFactory) {
        this.movementFactory = movementFactory;
    }

    @Override
    public BoardMap createMap(ILayer layer, int width, int height) {
        GroupLayer groupLayer = layerFactory.groupLayerBuilder()
                .with(width, height)
                .build();
        Level level = levelsFacade.changeToFirstLevel(groupLayer, gameElementFacade.pointFactory());
        ((LayerAdapter) layer).getProvidedObject().addChildren(groupLayer);

        BoardMapAdapter boardMapAdapter = new BoardMapAdapter(level, gameElementFacade.movingElementFactory());
        if (movementFactory != null) {
            boardMapAdapter.setMovementFactory(movementFactory);
        }
        return boardMapAdapter;
    }
}
