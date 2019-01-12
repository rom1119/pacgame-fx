package com.pacgame.game.adapter.board;

import com.pacgame.View;
import com.pacgame.game.adapter.ViewAdapter;

public abstract class GameElement extends ViewAdapter {


    @Override
    public abstract com.pacgame.gameElement.GameElement getProvidedObject();
}
