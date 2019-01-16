package com.pacgame.finder.impl.pointToPoint;

import com.pacgame.finder.*;

import java.util.*;

public class FinderPointToPoint implements Finder {

    private DistanceCalculator distanceCalculator;
    private FinderObject2D finderObject;
    private List<FinderRule> rules;

    public FinderPointToPoint(FinderObject2D finderObject) {
        this.distanceCalculator = new CartesianSystemDistanceCalculator();
        this.finderObject = finderObject;
        this.rules = new ArrayList<>();
    }

    @Override
    public void find(ObjectToFind objectToFind) {
        ObjectToFind2D toFind = (ObjectToFind2D) objectToFind;

        finderObject.moveTo(findNearestDirectionToMove(toFind));

    }

    private FindPoint2D findNearestDirectionToMove(ObjectToFind2D objectToFind)
    {
        Map<FindPoint2D, Integer> calculateWays = new HashMap<>();

        for(FindPoint2D el : finderObject.getAvailablePoints()) {

            if (el == null) {
                continue;
            }

            if (!el.isSatisfiedByRules(rules)) {
                continue;
            }

            int calculate = distanceCalculator.calculate(el, objectToFind.getPoint());

            calculateWays.put(el, calculate);

        }
        System.out.println(calculateWays.size());

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

    @Override
    public void addRule(FinderRule rule)
    {
        rules.add(rule);
    }

    @Override
    public void removeRule(FinderRule rule)
    {
        rules.remove(rule);
    }
}
