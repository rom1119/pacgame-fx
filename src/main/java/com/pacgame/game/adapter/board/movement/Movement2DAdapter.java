package com.pacgame.game.adapter.board.movement;

import com.pacgame.game.IView;
import com.pacgame.game.adapter.ViewAdapter;
import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.movement.*;
import com.pacgame.movement.impl.betweenPoints.MoverBetweenPoints;
import com.pacgame.provider.animation.AnimationBuilder;

public class Movement2DAdapter implements IMovement {

    private Movement2D providedObject;
    private AnimationBuilder animationBuilder;
    private MovePointsCreator2D movePointsCreator2D;

    public Movement2DAdapter(AnimationBuilder animationBuilder, MovePointsCreator2D movePointsCreator2D) {
        this.animationBuilder = animationBuilder;
        this.movePointsCreator2D = movePointsCreator2D;
    }

    private MovePoint2D findMovePointFromCoordinates(int x, int y)
    {
        return movePointsCreator2D.getFromPosition(x, y);
    }

    public void init(IMapPoint initPoint, IView view)
    {
        MovePoint2D movePoint = findMovePointFromCoordinates(initPoint.getX(), initPoint.getY());

        this.providedObject = new MoverBetweenPoints(animationBuilder, movePoint, new ObjectMoving2D() {
            @Override
            public MovementProperty XAxisProperty() {
                return new MovementProperty() {
                    @Override
                    public int get() {
//                        System.out.println("qw");

                        return view.getX();
                    }

                    @Override
                    public void set(int val) {
                        System.out.println("X");
                        view.setX(val);
                    }
                };
            }

            @Override
            public MovementProperty YAxisProperty() {
                return new MovementProperty() {
                    @Override
                    public int get() {
//                        System.out.println("qw");

                        return view.getY();
                    }

                    @Override
                    public void set(int val) {
                        System.out.println("Y");

                        view.setY(val);
                    }
                };
            };
        });
    }



    @Override
    public void start() {
        providedObject.start();
    }

    @Override
    public void stop() {
        providedObject.stop();
    }

    @Override
    public void pause() {
        providedObject.pause();
    }

    @Override
    public void skipTo(IMapPoint point) {
        MovePoint2D movePoint = findMovePointFromCoordinates(point.getX(), point.getY());

        providedObject.skipTo(movePoint);
    }

    @Override
    public void moveUp() {
        providedObject.moveUp();
    }

    @Override
    public void moveDown() {
        providedObject.moveDown();
    }

    @Override
    public void moveLeft() {
        providedObject.moveLeft();
    }

    @Override
    public void moveRight() {
        providedObject.moveRight();
    }
}
