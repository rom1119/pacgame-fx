package com.pacgame.provider.color;


public class Red extends ColorProvidedObject {

    public Red() {
        proxy = new RedProxy();
    }
}
