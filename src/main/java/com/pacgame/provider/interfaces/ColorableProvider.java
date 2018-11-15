package com.pacgame.provider.interfaces;

import com.pacgame.provider.color.Color;

public interface ColorableProvider {

    void fill(int red, int green, int blue, double alpha);
    void fill(int red, int green, int blue);
    void fillRed();
    void fillBlue();
    void fillGreen();
    void fillWhite();
    void setColor(Color color);
}
