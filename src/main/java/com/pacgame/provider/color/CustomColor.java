package com.pacgame.provider.color;

public class CustomColor extends ColorProvidedObject {


    public CustomColor(int red, int green, int blue, double alpha) {
         proxy = new CustomColorProxy(red, green, blue, alpha);
    }

    public CustomColor(int red, int green, int blue) {
        proxy = new CustomColorProxy(red, green, blue);
    }

}
