package com.pacgame.game.board.infrastructure;

import com.pacgame.game.board.model.pacman.Pacman;

public interface PacmanCreator {

    Pacman createPacman();

    void addToMap();
}
