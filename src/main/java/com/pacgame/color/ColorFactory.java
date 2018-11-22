package com.pacgame.color;

public interface ColorFactory {

    Red red();
    Green green();
    Blue blue();
    Yellow yellow();
    Custom custom(int red, int green, int blue);
    Custom custom(int red, int green, int blue, double alpha);
    ImageFill image(String imgPath);
}
