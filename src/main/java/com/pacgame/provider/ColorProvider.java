package com.pacgame.provider;

import com.pacgame.provider.color.*;

public abstract class ColorProvider extends Provider {

    public Red getRed()
    {
        return new Red();
    }

    public Green getGreen()
    {
        return new Green();
    }

    public Blue getBlue()
    {
        return new Blue();
    }

    public Yellow getYellow()
    {
        return new Yellow();
    }

    public CustomColor getCustom(int red, int green, int blue)
    {
        return new CustomColor(red, green, blue);
    }

    public CustomColor getCustom(int red, int green, int blue, double alpha)
    {
        return new CustomColor(red, green, blue, alpha);
    }
}
