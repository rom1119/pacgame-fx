package com.pacgame.provider.interfaces;

import com.pacgame.provider.color.ColorProvidedObject;

public interface ColorableProvider {

    void fill(int red, int green, int blue, double alpha);
    void fill(int red, int green, int blue);
    void fillRed();
    void fillBlue();
    void fillGreen();
    void fillWhite();
    void setColor(ColorProvidedObject color);
}
