package com.pacgame.game.adapter.factory;

import com.pacgame.color.ColorFactory;
import com.pacgame.game.IColor;
import com.pacgame.game.IColorFactory;
import com.pacgame.game.adapter.ColorAdapter;

public class ColorFactoryAdapter implements IColorFactory {

    private ColorFactory colorFactory;

    public ColorFactoryAdapter(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public IColor createRed() {
        return new ColorAdapter(colorFactory.red());
    }

    @Override
    public IColor createBlue() {
        return new ColorAdapter(colorFactory.blue());
    }

    @Override
    public IColor createGreen() {
        return new ColorAdapter(colorFactory.green());
    }


    @Override
    public IColor createYellow() {
        return new ColorAdapter(colorFactory.yellow());
    }

    @Override
    public IColor createCustom(int red, int green, int blue) {
        return new ColorAdapter(colorFactory.custom(red, green, blue));
    }

    @Override
    public IColor createCustom(int red, int green, int blue, double alpha) {
        return new ColorAdapter(colorFactory.custom(red, green, blue, alpha));
    }

    @Override
    public IColor createImage(String imgPath) {
        return new ColorAdapter(colorFactory.image(imgPath));
    }
}
