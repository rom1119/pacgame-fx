package com.pacgame.map;

public abstract class Map implements IMap {

    protected String imgUrl;

    public Map(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
