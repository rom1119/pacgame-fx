package com.pacgame.game.adapter.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.adapter.LayerAdapter;
import com.pacgame.game.board.BoardMap;
import com.pacgame.game.board.BoardMapCreator;
import com.pacgame.gameElement.PointFactory;
import com.pacgame.map.Level;
import com.pacgame.map.LevelsFacade;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.layer.GroupLayer;

public class BoardMapCreatorAdapter implements BoardMapCreator {

    private LevelsFacade levelsFacade;
    private PointFactory pointFactory;
    private LayerFactory layerFactory;

    public BoardMapCreatorAdapter(LevelsFacade levelsFacade, PointFactory pointFactory, LayerFactory layerFactory) {
        this.levelsFacade = levelsFacade;
        this.pointFactory = pointFactory;
        this.layerFactory = layerFactory;
    }

    @Override
    public BoardMap createMap(ILayer layer, int width, int height) {
        GroupLayer groupLayer = layerFactory.groupLayerBuilder()
                .with(width, height)
                .build();
        Level level = levelsFacade.changeToFirstLevel(groupLayer, pointFactory);
        ((LayerAdapter) layer).getProvidedObject().addChildren(groupLayer);

        return new BoardMapAdapter(level);
    }
}
