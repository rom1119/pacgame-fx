package com.pacgame.map.levels;

import com.pacgame.map.LevelMapPath;
import com.pacgame.map.point.MapPoint;

import java.util.HashMap;
import java.util.Map;

class FirstLevelMapPath extends LevelMapPath {

    private static Map<String, MapPoint> points;
    private static int firstX = 35;
    private static int xStep = 95;
    private static int firstY = 30;
    private static int yStep = 88;

    private static int changeXA = 0;
    private static int changeBA = 0;

    public FirstLevelMapPath() {
        createMapPoints();

    }

    private void createMapPoints() {

        points = new HashMap<>();

//        1 row
        MapPoint a1 = new MapPoint(firstX- 4, firstY);
        MapPoint a2 = null;
        MapPoint a3 = new MapPoint((firstX + (xStep * 1) - 3), firstY);
        MapPoint a4 = null;
        MapPoint a5 = new MapPoint((firstX + (int)(xStep * 2) - 3), firstY);
        MapPoint a6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), firstY);
        MapPoint a7 = null;
        MapPoint a8 = new MapPoint((firstX + (int)(xStep * 3) + (int)(xStep / 2) + (5) - 3), firstY);
        MapPoint a9 = null;
        MapPoint a10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), firstY);

//    2 row
        MapPoint b1 = new MapPoint(firstX- 4, (firstY + yStep) - (15));
        MapPoint b2 = null;
        MapPoint b3 = new MapPoint((firstX + (xStep * 1) - 3), (firstY + yStep) - (15));
        MapPoint b4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep) - (15));
        MapPoint b5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep) - (15));


        MapPoint b6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep) - (15));
        MapPoint b7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep) - (15));


        MapPoint b8 = new MapPoint((firstX + (int)(xStep * 3) + (int)(xStep / 2) + (5) - 3), (firstY + yStep) - (15));
        MapPoint b9 = null;
        MapPoint b10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), (firstY + yStep) - (15));

//    3 row
        MapPoint c1 = new MapPoint(firstX- 4, (firstY + yStep + (yStep / 2 * 1) -  (5)));
        MapPoint c2 = null;
        MapPoint c3 = new MapPoint((firstX + (xStep * 1) - 3), (firstY + yStep  + (yStep / 2 * 1) -  (5)));
        MapPoint c4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 1) -  (5)));
        MapPoint c5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep  + (yStep / 2 * 1) -  (5)));


        MapPoint c6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 1) -  (5)));
        MapPoint c7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep  + (yStep / 2 * 1) -  (5)));


        MapPoint c8 = new MapPoint((firstX + (int)(xStep * 3) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 1) -  (5)));
        MapPoint c9 = null;
        MapPoint c10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 1) -  (5)));

//    4 row
        MapPoint d1 = null;
        MapPoint d2 = null;
        MapPoint d3 = null;
        MapPoint d4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 2) - (10)));
        MapPoint d5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep + (yStep / 2 * 2) - (10)));
        MapPoint d5A = new MapPoint((firstX + (int)(xStep * 2) - 3 + 22), (firstY + yStep + (yStep / 2 * 2) - (10)));


        MapPoint d6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 2) - (10)));
        MapPoint d7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep + (yStep / 2 * 2) - (10)));


        MapPoint d8 = null;

        MapPoint d9 = null;
        MapPoint d10 = null;

//        5 row
        MapPoint e1 = new MapPoint(firstX- 4, (firstY + yStep + (yStep / 2 * 3)));
        MapPoint e2 = null;
        MapPoint e3 = new MapPoint((firstX + (xStep * 1) - 3), (firstY + yStep + (yStep / 2 * 3)));
        MapPoint e4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 3)));
        MapPoint e5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep + (yStep / 2 * 3)));
        MapPoint e5A = new MapPoint((firstX + (int)(xStep * 2) - 3 + 22), (firstY + yStep + (yStep / 2 * 3)));


        MapPoint e6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 3)));
        MapPoint e7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep + (yStep / 2 * 3)));


        MapPoint e8 = new MapPoint((firstX + (int)(xStep * 3) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 3)));
        MapPoint e9 = null;
        MapPoint e10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 3)));

//        6 row
        MapPoint f1 = null;
        MapPoint f2 = null;
        MapPoint f3 = null;
        MapPoint f4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 4) - (8)));
        MapPoint f5 = null;


        MapPoint f6 = null;
        MapPoint f7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep + (yStep / 2 * 4) - (8)));


        MapPoint f8 = null;

        MapPoint f9 = null;
        MapPoint f10 = null;
//        7 row
        MapPoint g1 = new MapPoint(firstX- 4, (firstY + yStep + (yStep / 2 * 5)));
        MapPoint g2 = null;
        MapPoint g3 = new MapPoint((firstX + (xStep * 1) - 3), (firstY + yStep  + (yStep / 2 * 5)));
        MapPoint g4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 5)));
        MapPoint g5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep  + (yStep / 2 * 5)));


        MapPoint g6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 5)));
        MapPoint g7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep  + (yStep / 2 * 5)));


        MapPoint g8 = new MapPoint((firstX + (int)(xStep * 3) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 5)));
        MapPoint g9 = null;
        MapPoint g10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 5)));

//        8 row
        MapPoint h1 = new MapPoint(firstX- 4, (firstY + yStep + (yStep / 2 * 6)));
        MapPoint h2 = new MapPoint((firstX + (int)(xStep / 2)), (firstY + yStep + (yStep / 2 * 6)));
        MapPoint h3 = new MapPoint((firstX + (xStep * 1) - 3), (firstY + yStep  + (yStep / 2 * 6)));
        MapPoint h4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 6)));
        MapPoint h5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep  + (yStep / 2 * 6)));
        MapPoint h5A = new MapPoint((firstX + (int)(xStep * 2) - 3 + 30), (firstY + yStep  + (yStep / 2 * 6)));


        MapPoint h6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 6)));
        MapPoint h7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep  + (yStep / 2 * 6)));


        MapPoint h8 = new MapPoint((firstX + (int)(xStep * 3) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 6)));
        MapPoint h9 = new MapPoint((firstX + (int)(xStep * 3) + (int)((xStep / 2) * 2) - 3), (firstY + yStep  + (yStep / 2 * 6)));
        MapPoint h10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 6)));


//        9 row
        MapPoint i1 = new MapPoint((firstX- 4 ), (firstY + yStep + (yStep / 2 * 7) + (8)));
        MapPoint i2 = new MapPoint((firstX + (int)(xStep / 2)), (firstY + yStep + (yStep / 2 * 7) + (8)));
        MapPoint i3 = new MapPoint((firstX + (xStep * 1) - 3), (firstY + yStep  + (yStep / 2 * 7) + (8)));
        MapPoint i4 = new MapPoint((firstX + (int)(xStep * 1) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 7) + (8)));
        MapPoint i5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep  + (yStep / 2 * 7) + (8)));


        MapPoint i6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 7) + (8)));
        MapPoint i7 = new MapPoint((firstX + (int)(xStep * 3) - 3), (firstY + yStep  + (yStep / 2 * 7) + (8)));


        MapPoint i8 = new MapPoint((firstX + (int)(xStep * 3) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 7) + (8)));
        MapPoint i9 = new MapPoint((firstX + (int)(xStep * 3) + (int)((xStep / 2) * 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 7) + (8)));
        MapPoint i10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 7) + (8)));

//        10 row
        MapPoint j1 = new MapPoint(firstX - 4, (firstY + yStep + (yStep / 2 * 8)));
        MapPoint j2 = null;
        MapPoint j3 = null;
        MapPoint j4 = null;

        MapPoint j5 = new MapPoint((firstX + (int)(xStep * 2) - 3), (firstY + yStep  + (yStep / 2 * 8)));
        MapPoint j6 = new MapPoint((firstX + (int)(xStep * 2) + (int)(xStep / 2) + (5) - 3), (firstY + yStep + (yStep / 2 * 8)));

        MapPoint j7 = null;
        MapPoint j8 = null;
        MapPoint j9 = null;

        MapPoint j10 = new MapPoint((firstX + (int)(xStep * 4) + (int)(xStep / 2) + (5) - 3), (firstY + yStep  + (yStep / 2 * 8)));

        // set A Row

        a1.setUpPoint(null);
        a1.setDownPoint(b1);
        a1.setLeftPoint(null);
        a1.setRightPoint(a3);
        a1.setName("a1");

        a3.setUpPoint(null);
        a3.setDownPoint(b3);
        a3.setLeftPoint(a1);
        a3.setRightPoint(a5);
        a3.setName("a3");


        a5.setUpPoint(null);
        a5.setDownPoint(b5);
        a5.setLeftPoint(a3);
        a5.setRightPoint(null);
        a5.setName("a5");


        a6.setUpPoint(null);
        a6.setDownPoint(b6);
        a6.setLeftPoint(null);
        a6.setRightPoint(a8);
        a6.setName("a6");


        a8.setUpPoint(null);
        a8.setDownPoint(b8);
        a8.setLeftPoint(a6);
        a8.setRightPoint(a10);
        a8.setName("a8");


        a10.setUpPoint(null);
        a10.setDownPoint(b10);
        a10.setLeftPoint(a8);
        a10.setRightPoint(null);
        a10.setName("a10");


        // set B Row

        b1.setUpPoint(a1);
        b1.setDownPoint(c1);
        b1.setLeftPoint(null);
        b1.setRightPoint(b3);
        b1.setName("b1");


        b3.setUpPoint(a3);
        b3.setDownPoint(c3);
        b3.setLeftPoint(b1);
        b3.setRightPoint(b4);
        b3.setName("b3");


        b4.setUpPoint(null);
        b4.setDownPoint(c4);
        b4.setLeftPoint(b3);
        b4.setRightPoint(b5);
        b4.setName("b4");


        b5.setUpPoint(a5);
        b5.setDownPoint(null);
        b5.setLeftPoint(b4);
        b5.setRightPoint(b6);
        b5.setName("b5");


        b6.setUpPoint(a6);
        b6.setDownPoint(null);
        b6.setLeftPoint(b5);
        b6.setRightPoint(b7);
        b6.setName("b6");


        b7.setUpPoint(null);
        b7.setDownPoint(c7);
        b7.setLeftPoint(b6);
        b7.setRightPoint(b8);
        b7.setName("b7");


        b8.setUpPoint(a8);
        b8.setDownPoint(c8);
        b8.setLeftPoint(b7);
        b8.setRightPoint(b10);
        b8.setName("b8");


        b10.setUpPoint(a10);
        b10.setDownPoint(c10);
        b10.setLeftPoint(b8);
        b10.setRightPoint(null);
        b10.setName("b10");


        // set C Row

        c1.setUpPoint(b1);
        c1.setDownPoint(null);
        c1.setLeftPoint(null);
        c1.setRightPoint(c3);
        c1.setName("c1");


        c3.setUpPoint(b3);
        c3.setDownPoint(e3);
        c3.setLeftPoint(c1);
        c3.setRightPoint(null);
        c3.setName("c3");


        c4.setUpPoint(b4);
        c4.setDownPoint(null);
        c4.setLeftPoint(null);
        c4.setRightPoint(c5);
        c4.setName("c4");


        c5.setUpPoint(null);
        c5.setDownPoint(d5);
        c5.setLeftPoint(c4);
        c5.setRightPoint(null);
        c5.setName("c5");


        c6.setUpPoint(null);
        c6.setDownPoint(d6);
        c6.setLeftPoint(null);
        c6.setRightPoint(c7);
        c6.setName("c6");


        c7.setUpPoint(b7);
        c7.setDownPoint(null);
        c7.setLeftPoint(c6);
        c7.setRightPoint(null);
        c7.setName("c7");


        c8.setUpPoint(b8);
        c8.setDownPoint(e8);
        c8.setLeftPoint(null);
        c8.setRightPoint(c10);
        c8.setName("c8");


        c10.setUpPoint(b10);
        c10.setDownPoint(null);
        c10.setLeftPoint(c8);
        c10.setRightPoint(null);
        c10.setName("c10");


        // set D Row


        d4.setUpPoint(null);
        d4.setDownPoint(e4);
        d4.setLeftPoint(null);
        d4.setRightPoint(d5);
        d4.setName("d4");


        d5.setUpPoint(c5);
        d5.setDownPoint(null);
        d5.setLeftPoint(d4);
        d5.setRightPoint(d5A);
        d5.setName("d5");


        d5A.setUpPoint(null);
        d5A.setDownPoint(e5A);
        d5A.setLeftPoint(d5);
        d5A.setRightPoint(d6);
        d5A.setName("d5A");


        d6.setUpPoint(c6);
        d6.setDownPoint(null);
        d6.setLeftPoint(d5A);
        d6.setRightPoint(d7);
        d6.setName("d6");


        d7.setUpPoint(null);
        d7.setDownPoint(e7);
        d7.setLeftPoint(d6);
        d7.setRightPoint(null);
        d7.setName("d7");


        // set E Row

        e1.setUpPoint(null);
        e1.setDownPoint(null);
        e1.setLeftPoint(null);
        e1.setRightPoint(e3);
        e1.setName("e1");


        e3.setUpPoint(c3);
        e3.setDownPoint(g3);
        e3.setLeftPoint(e1);
        e3.setRightPoint(e4);
        e3.setName("e3");


        e4.setUpPoint(d4);
        e4.setDownPoint(f4);
        e4.setLeftPoint(e3);
        e4.setRightPoint(null);
        e4.setName("e4");


        e5.setUpPoint(null);
        e5.setDownPoint(null);
        e5.setLeftPoint(null);
        e5.setRightPoint(e5A);
        e5.setName("e5");


        e5A.setUpPoint(d5A);
        e5A.setDownPoint(null);
        e5A.setLeftPoint(e5);
        e5A.setRightPoint(e6);
        e5A.setName("e5A");
        e5A.setDoor(true);


        e6.setUpPoint(null);
        e6.setDownPoint(null);
        e6.setLeftPoint(e5A);
        e6.setRightPoint(null);
        e6.setName("e6");


        e7.setUpPoint(d7);
        e7.setDownPoint(f7);
        e7.setLeftPoint(null);
        e7.setRightPoint(e8);
        e7.setName("e7");


        e8.setUpPoint(c8);
        e8.setDownPoint(g8);
        e8.setLeftPoint(e7);
        e8.setRightPoint(e10);
        e8.setName("e8");


        e10.setUpPoint(null);
        e10.setDownPoint(null);
        e10.setLeftPoint(e8);
        e10.setRightPoint(null);
        e10.setName("e10");



        // set F Row


        f4.setUpPoint(e4);
        f4.setDownPoint(g4);
        f4.setLeftPoint(null);
        f4.setRightPoint(f7);
        f4.setName("f4");



        f7.setUpPoint(e7);
        f7.setDownPoint(g7);
        f7.setLeftPoint(f4);
        f7.setRightPoint(null);
        f7.setName("f7");


        // set G Row

        g1.setUpPoint(null);
        g1.setDownPoint(h1);
        g1.setLeftPoint(null);
        g1.setRightPoint(g3);
        g1.setName("g1");


        g3.setUpPoint(e3);
        g3.setDownPoint(h3);
        g3.setLeftPoint(g1);
        g3.setRightPoint(g4);
        g3.setName("g3");


        g4.setUpPoint(f4);
        g4.setDownPoint(null);
        g4.setLeftPoint(g3);
        g4.setRightPoint(g5);
        g4.setName("g4");


        g5.setUpPoint(null);
        g5.setDownPoint(h5);
        g5.setLeftPoint(g4);
        g5.setRightPoint(null);
        g5.setName("g5");


        g6.setUpPoint(null);
        g6.setDownPoint(h6);
        g6.setLeftPoint(null);
        g6.setRightPoint(g7);
        g6.setName("g6");


        g7.setUpPoint(f7);
        g7.setDownPoint(null);
        g7.setLeftPoint(g6);
        g7.setRightPoint(g8);
        g7.setName("g7");


        g8.setUpPoint(e8);
        g8.setDownPoint(h8);
        g8.setLeftPoint(g7);
        g8.setRightPoint(g10);
        g8.setName("g8");


        g10.setUpPoint(null);
        g10.setDownPoint(h10);
        g10.setLeftPoint(g8);
        g10.setRightPoint(null);
        g10.setName("g10");


        // set H Row

        h1.setUpPoint(g1);
        h1.setDownPoint(null);
        h1.setLeftPoint(null);
        h1.setRightPoint(h2);
        h1.setName("h1");


        h2.setUpPoint(null);
        h2.setDownPoint(i2);
        h2.setLeftPoint(h1);
        h2.setRightPoint(null);
        h2.setName("h2");


        h3.setUpPoint(g3);
        h3.setDownPoint(i3);
        h3.setLeftPoint(null);
        h3.setRightPoint(h4);
        h3.setName("h3");


        h4.setUpPoint(null);
        h4.setDownPoint(i4);
        h4.setLeftPoint(h3);
        h4.setRightPoint(h5);
        h4.setName("h4");


        h5.setUpPoint(g5);
        h5.setDownPoint(null);
        h5.setLeftPoint(h4);
        h5.setRightPoint(h5A);
        h5.setName("h5");

        h5A.setUpPoint(null);
        h5A.setDownPoint(null);
        h5A.setLeftPoint(h5);
        h5A.setRightPoint(h6);
        h5A.setName("h5");


        h6.setUpPoint(g6);
        h6.setDownPoint(null);
        h6.setLeftPoint(h5A);
        h6.setRightPoint(h7);
        h6.setName("h6");


        h7.setUpPoint(null);
        h7.setDownPoint(i7);
        h7.setLeftPoint(h6);
        h7.setRightPoint(h8);
        h7.setName("h7");


        h8.setUpPoint(g8);
        h8.setDownPoint(i8);
        h8.setLeftPoint(h7);
        h8.setRightPoint(null);
        h8.setName("h8");


        h9.setUpPoint(null);
        h9.setDownPoint(i9);
        h9.setLeftPoint(null);
        h9.setRightPoint(h10);
        h9.setName("h9");


        h10.setUpPoint(g10);
        h10.setDownPoint(null);
        h10.setLeftPoint(h9);
        h10.setRightPoint(null);
        h10.setName("h10");


        // set I Row

        i1.setUpPoint(null);
        i1.setDownPoint(j1);
        i1.setLeftPoint(null);
        i1.setRightPoint(i2);
        i1.setName("i1");


        i2.setUpPoint(h2);
        i2.setDownPoint(null);
        i2.setLeftPoint(i1);
        i2.setRightPoint(i3);
        i2.setName("i2");


        i3.setUpPoint(h3);
        i3.setDownPoint(null);
        i3.setLeftPoint(i2);
        i3.setRightPoint(null);
        i3.setName("i3");


        i4.setUpPoint(h4);
        i4.setDownPoint(null);
        i4.setLeftPoint(null);
        i4.setRightPoint(i5);
        i4.setName("i4");


        i5.setUpPoint(null);
        i5.setDownPoint(j5);
        i5.setLeftPoint(i4);
        i5.setRightPoint(null);
        i5.setName("i5");


        i6.setUpPoint(null);
        i6.setDownPoint(j6);
        i6.setLeftPoint(null);
        i6.setRightPoint(i7);
        i6.setName("i6");


        i7.setUpPoint(h7);
        i7.setDownPoint(null);
        i7.setLeftPoint(i6);
        i7.setRightPoint(null);
        i7.setName("i7");


        i8.setUpPoint(h8);
        i8.setDownPoint(null);
        i8.setLeftPoint(null);
        i8.setRightPoint(i9);
        i8.setName("i8");


        i9.setUpPoint(h9);
        i9.setDownPoint(null);
        i9.setLeftPoint(i8);
        i9.setRightPoint(i10);
        i9.setName("i9");


        i10.setUpPoint(null);
        i10.setDownPoint(j10);
        i10.setLeftPoint(i9);
        i10.setRightPoint(null);
        i10.setName("i10");


        // set J Row

        j1.setUpPoint(i1);
        j1.setDownPoint(null);
        j1.setLeftPoint(null);
        j1.setRightPoint(j5);
        j1.setName("j1");


        j5.setUpPoint(i5);
        j5.setDownPoint(null);
        j5.setLeftPoint(j1);
        j5.setRightPoint(j6);
        j5.setName("j5");


        j6.setUpPoint(i6);
        j6.setDownPoint(null);
        j6.setLeftPoint(j5);
        j6.setRightPoint(j10);
        j6.setName("j6");


        j10.setUpPoint(i10);
        j10.setDownPoint(null);
        j10.setLeftPoint(j6);
        j10.setRightPoint(null);
        j10.setName("j10");


//      add A row
        points.put("a1", a1);
        points.put("a2", a2);
        points.put("a3", a3);
        points.put("a4", a4);
        points.put("a5", a5);
        points.put("a6", a6);
        points.put("a7", a7);
        points.put("a8", a8);
        points.put("a9", a9);
        points.put("a10", a10);

//      add B row
        points.put("b1", b1);
        points.put("b2", b2);
        points.put("b3", b3);
        points.put("b4", b4);
        points.put("b5", b5);
        points.put("b6", b6);
        points.put("b7", b7);
        points.put("b8", b8);
        points.put("b9", b9);
        points.put("b10",b10);

//      add C row
        points.put("c1", c1);
        points.put("c2", c2);
        points.put("c3", c3);
        points.put("c4", c4);
        points.put("c5", c5);
        points.put("c6", c6);
        points.put("c7", c7);
        points.put("c8", c8);
        points.put("c9", c9);
        points.put("c10",c10);

//      add D row
        points.put("d1", d1);
        points.put("d2", d2);
        points.put("d3", d3);
        points.put("d4", d4);
        points.put("d5", d5);
        points.put("d5A", d5A);
        points.put("d6", d6);
        points.put("d7", d7);
        points.put("d8", d8);
        points.put("d9", d9);
        points.put("d10",d10);

//      add E row
        points.put("e1", e1);
        points.put("e2", e2);
        points.put("e3", e3);
        points.put("e4", e4);
        points.put("e5", e5);
        points.put("e5A", e5A);
        points.put("e6", e6);
        points.put("e7", e7);
        points.put("e8", e8);
        points.put("e9", e9);
        points.put("e10",e10);

//      add F row
        points.put("f1", f1);
        points.put("f2", f2);
        points.put("f3", f3);
        points.put("f4", f4);
        points.put("f5", f5);
        points.put("f6", f6);
        points.put("f7", f7);
        points.put("f8", f8);
        points.put("f9", f9);
        points.put("f10",f10);

//      add G row
        points.put("g1", g1);
        points.put("g2", g2);
        points.put("g3", g3);
        points.put("g4", g4);
        points.put("g5", g5);
        points.put("g6", g6);
        points.put("g7", g7);
        points.put("g8", g8);
        points.put("g9", g9);
        points.put("g10",g10);

//      add H row
        points.put("h1", h1);
        points.put("h2", h2);
        points.put("h3", h3);
        points.put("h4", h4);
        points.put("h5", h5);
        points.put("h5A", h5A);
        points.put("h6", h6);
        points.put("h7", h7);
        points.put("h8", h8);
        points.put("h9", h9);
        points.put("h10",h10);

//      add I row
        points.put("i1", i1);
        points.put("i2", i2);
        points.put("i3", i3);
        points.put("i4", i4);
        points.put("i5", i5);
        points.put("i6", i6);
        points.put("i7", i7);
        points.put("i8", i8);
        points.put("i9", i9);
        points.put("i10",i10);

//      add J row
        points.put("j1", j1);
        points.put("j2", j2);
        points.put("j3", j3);
        points.put("j4", j4);
        points.put("j5", j5);
        points.put("j6", j6);
        points.put("j7", j7);
        points.put("j8", j8);
        points.put("j9", j9);
        points.put("j10",j10);


        int xToChange = 0;
        int yToChange = 40;


//

    }

    @Override
    public Map<String, MapPoint> getAllPoints()
    {
        return points;
    }

}
