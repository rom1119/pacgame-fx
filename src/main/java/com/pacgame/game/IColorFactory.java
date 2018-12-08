package com.pacgame.game;

public interface IColorFactory {

    IColor createRed();
    IColor createBlue();
    IColor createGreen();
    IColor createYellow();
    IColor createCustom(int red, int green, int blue);
    IColor createCustom(int red, int green, int blue, double alpha);
    IColor createImage(String imgPath);
}
