package com.pacgame.uiElement.alignment;

import com.pacgame.provider.PositionAlignmentProvider;
import com.pacgame.provider.ProvidedObject;
import com.pacgame.provider.alignment.PositionAlignment;

public class Position {

//    private Position TOP_LEFT ;
//    private Position TOP_RIGHT ;
//    private Position TOP_CENTER ;
//    private Position CENTER ;
//    private Position CENTER_LEFT ;
//    private Position CENTER_RIGHT ;
//    private Position BOTTOM_LEFT ;
//    private Position BOTTOM_CENTER ;
//    private Position BOTTOM_RIGHT ;

    private PositionAlignment providedObject;

    Position(PositionAlignment positionAlignment) {

        providedObject = positionAlignment;
    }

    public PositionAlignment getProvidedObject() {
        return providedObject;
    }
}
