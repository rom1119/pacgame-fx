package com.pacgame.finder.impl.pointToPoint;

import com.pacgame.finder.DistanceCalculator;
import com.pacgame.finder.FindPoint2D;
import com.pacgame.finder.Finder;
import com.pacgame.finder.ObjectToFind;

import java.util.*;

public class FinderPointToPoint implements Finder {

    private DistanceCalculator distanceCalculator;
    private FinderObjectImpl finderObject;

    public FinderPointToPoint() {
        this.distanceCalculator = new CartesianSystemDistanceCalculator();
    }

    @Override
    public void find(ObjectToFind objectToFind) {

    }

    private FindPoint2D findMostDirection(List<FindPoint2D> availableMapPoints)
    {
        Map<FindPoint2D, Integer> calculateWays = new HashMap<>();

        for(FindPoint2D el : availableMapPoints) {

            int calculate = distanceCalculator.calculate(el, finderObject.getPoint());

            calculateWays.put(el, calculate);

        }

        if (calculateWays.size() == 0) {
            System.out.println("brak dostepnych pkt");
        }

        return findNearestPoint(calculateWays);
    }

    private FindPoint2D findNearestPoint(Map<FindPoint2D, Integer> calculateWays)
    {
        Map.Entry<FindPoint2D, Integer> min = Collections.min(calculateWays.entrySet(), new Comparator<Map.Entry<FindPoint2D, Integer>>() {
            public int compare(Map.Entry<FindPoint2D, Integer> entry1, Map.Entry<FindPoint2D, Integer> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });

        return min.getKey();
    }

    public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
}
