package com.pacgame.game.adapter.board.finder;

import com.pacgame.finder.FindPoint2D;
import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.IView;
import com.pacgame.game.adapter.board.MapPointAdapter;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.board.model.level.IMapPoint;

public class ObjectToFindFactory {

    public ObjectToFind2D createObjectToFind2D(IView view)
    {
        return new ObjectToFind2D() {
            private IView el = view;

            @Override
            public FindPoint2D getPoint() {
                return new FindPoint2DAdapter((MapPointAdapter) el);

            }

        };
    }

    public ObjectToFind2D createObjectToFind2D(IMapPoint view)
    {
        return new ObjectToFind2D() {
            private IMapPoint el = view;

            @Override
            public FindPoint2D getPoint() {
                return new FindPoint2DAdapter((MapPointAdapter) el);

            }
        };
    }

    public ObjectToFind2D createObjectToFind2D(Moveable view)
    {
        return new ObjectToFind2D() {
            private Moveable moveable = view;
            @Override
            public FindPoint2D getPoint() {
                return new FindPoint2DAdapter((MapPointAdapter) moveable.getCurrentPoint());
            }
        };
    }
}
