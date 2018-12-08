package com.pacgame.provider;

import com.pacgame.provider.color.*;

public class PaintProviderImpl implements PaintProvider {
    @Override
    public Paint createRed() {
        return new Red();
    }

    @Override
    public Paint createGreen() {
        return new Green();
    }

    @Override
    public Paint createBlue() {
        return new Blue();
    }

    @Override
    public Paint createYellow() {
        return new Yellow();
    }

    @Override
    public Paint createCustom(int red, int green, int blue) {
        return new CustomColor(red, green, blue);
    }

    @Override
    public Paint createCustom(int red, int green, int blue, double alpha) {
        return new CustomColor(red, green, blue, alpha);
    }

    @Override
    public Paint createImage(String imgPath) {
        return new ImageFill(imgPath);
    }
}
