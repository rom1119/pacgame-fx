package com.pacgame.provider.db;

public abstract class Entity {

    public int getId()
    {
        return hashCode();
    }

}
