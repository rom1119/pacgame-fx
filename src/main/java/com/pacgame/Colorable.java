package com.pacgame;

import com.pacgame.color.Color;
import com.pacgame.provider.color.ColorProvidedObject;

public interface Colorable {

    void fill(int red, int green, int blue, double alpha);
    void fill(int red, int green, int blue);
    void fillRed();
    void fillBlue();
    void fillGreen();
    void fillWhite();
    void setColor(Color color);
}
