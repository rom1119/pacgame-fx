package com.pacgame.map;

import org.apache.commons.collections.BidiMap;

abstract class Populator {

    abstract void populate(BidiMap allPoints);
    abstract void depopulate();
}
