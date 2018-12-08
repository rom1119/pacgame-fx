package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

public class ColorFactoryImpl implements ColorFactory {

    private PaintProvider provider;

    public ColorFactoryImpl(PaintProvider provider) {
        this.provider = provider;
    }

    @Override
    public Red red() {
        return new Red(provider);
    }

    @Override
    public Green green() {
        return new Green(provider);
    }

    @Override
    public Blue blue() {
        return new Blue(provider);
    }

    @Override
    public Yellow yellow() {
        return new Yellow(provider);
    }

    @Override
    public Custom custom(int red, int green, int blue) {
        return new Custom(provider, red, green, blue);
    }

    @Override
    public Custom custom(int red, int green, int blue, double alpha) {
        return new Custom(provider, red, green, blue, alpha);
    }

    @Override
    public ImageFill image(String imgPath) {
        return new ImageFill(provider, imgPath);
    }
}
