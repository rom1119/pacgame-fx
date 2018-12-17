package com.pacgame.game;

public interface ILayoutFactory {
    ILayer createGroupLayer(int width, int height);
    ILayer createFlowLayer(int width, int height);
    IVerticalLayer createVerticalLayer(int width, int height);

    IVerticalLayer createCenteredVerticalLayer(int width, int height);
}
