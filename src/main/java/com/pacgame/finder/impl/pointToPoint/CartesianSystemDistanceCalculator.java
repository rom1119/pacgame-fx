package com.pacgame.finder.impl.pointToPoint;

import com.pacgame.finder.DistanceCalculator;
import com.pacgame.finder.FindPoint;

public class CartesianSystemDistanceCalculator implements DistanceCalculator {
    @Override
    public int calculate(FindPoint from, FindPoint to) {
        return (int) Math.sqrt(Math.pow((to.getX() - from.getX()), 2) + Math.pow((to.getY() - from.getY()), 2));
    }
}
