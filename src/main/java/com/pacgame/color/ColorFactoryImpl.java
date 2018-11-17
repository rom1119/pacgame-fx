package com.pacgame.color;

import com.pacgame.provider.ColorProvider;

public class ColorFactoryImpl implements ColorFactory {

    private ColorProvider colorProvider;

    public ColorFactoryImpl(ColorProvider colorProvider) {
        this.colorProvider = colorProvider;
    }

    @Override
    public Red red() {
        return new Red(colorProvider);
    }

    @Override
    public Green green() {
        return new Green(colorProvider);
    }

    @Override
    public Blue blue() {
        return new Blue(colorProvider);
    }

    @Override
    public Yellow yellow() {
        return new Yellow(colorProvider);
    }

    @Override
    public Custom custom(int red, int green, int blue) {
        return new Custom(colorProvider, red, green, blue);
    }

    @Override
    public Custom custom(int red, int green, int blue, double alpha) {
        return new Custom(colorProvider, red, green, blue, alpha);
    }
}
