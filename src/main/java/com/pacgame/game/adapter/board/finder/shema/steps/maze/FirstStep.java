package com.pacgame.game.adapter.board.finder.shema.steps.maze;

import com.pacgame.finder.FindPoint2D;
import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.adapter.board.MapPointAdapter;
import com.pacgame.game.adapter.board.finder.FindPoint2DAdapter;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.scheme.SchemeStep;
import com.pacgame.scheme.SchemeStepHandler;

import java.util.Random;

public class FirstStep implements SchemeStep<ObjectToFind2D> {
    private int countSteps = 10;
    private SchemeStepHandler onCompleteHandler;

    private ObjectToFind2D target;
    private IMaze finderObject;


    public FirstStep(ObjectToFind2D el, IMaze finderObject) {
        this.target = el;
        this.finderObject = finderObject;
    }

    @Override
    public ObjectToFind2D getTargetElement() {
        if (countSteps > 0) {
            return createRandomPoint();
        }

        return target;
    }

    private ObjectToFind2D createRandomPoint()
    {
        Random generator = new Random();
        ObjectToFind2D returnObj = null;

        while (returnObj == null) {
            int i = generator.nextInt(1);

            switch (i) {
                case 0:
                    if (((MapPointAdapter) finderObject.getCurrentPoint()).getLeft() != null) {
                        returnObj = new ObjectToFind2D() {
                            @Override
                            public FindPoint2D getPoint() {
                                return new FindPoint2DAdapter((MapPointAdapter) ((MapPointAdapter) finderObject.getCurrentPoint()).getLeft());
                            }
                        };
                    }
                case 1:
                    if (((MapPointAdapter) finderObject.getCurrentPoint()).getRight() != null) {
                        returnObj = new ObjectToFind2D() {
                            @Override
                            public FindPoint2D getPoint() {
                                return new FindPoint2DAdapter((MapPointAdapter) ((MapPointAdapter) finderObject.getCurrentPoint()).getRight());
                            }
                        };
                    }
            }
        }

        return returnObj;

    }

    @Override
    public boolean isComplete() {
        if (countSteps > 0) {
            return false;
        }
//                System.out.println(finderObject.getCurrentPoint().getX());
//                System.out.println(el.getPoint().getX());
//                System.out.println(finderObject.getCurrentPoint().getY());
//                System.out.println(el.getPoint().getY());
        return finderObject.getCurrentPoint().getX() == target.getPoint().getX() && finderObject.getCurrentPoint().getY() == target.getPoint().getY();
    }

    @Override
    public void update() {
        countSteps--;
    }

    @Override
    public void onComplete() {
        if (onCompleteHandler != null) {
            onCompleteHandler.handle();
        }
    }

    @Override
    public void setOnComplete(SchemeStepHandler handler) {
        this.onCompleteHandler = handler;
    }
}
