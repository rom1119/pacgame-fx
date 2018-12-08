package com.pacgame.provider;

public interface PaintProvider {

    Paint createRed();

    Paint createGreen();

    Paint createBlue();

    Paint createYellow();

    Paint createCustom(int red, int green, int blue);
    Paint createCustom(int red, int green, int blue, double alpha);
    Paint createImage(String imgPath);
}
