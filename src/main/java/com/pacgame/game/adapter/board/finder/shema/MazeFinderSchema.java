package com.pacgame.game.adapter.board.finder.shema;

import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.adapter.board.finder.ObjectToFindFactory;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.scheme.Scheme;
import com.pacgame.scheme.SchemeStep;
import com.pacgame.scheme.SchemeStepHandler;
import com.pacgame.scheme.impl.FinderScheme;

public class MazeFinderSchema implements Scheme<ObjectToFind2D> {

    private FinderScheme<ObjectToFind2D> finderScheme;
    private Moveable finderObject;

    public MazeFinderSchema(Moveable finderObject) {
        createFinderSchema();
        this.finderObject = finderObject;
    }

    private void createFinderSchema() {
        finderScheme = new FinderScheme<>();
    }

    public Scheme<ObjectToFind2D> getFinderScheme() {
        return finderScheme;
    }

    public SchemeStep setObjectForFirstStep(ObjectToFind2D el)
    {
        SchemeStep schemeStep = new SchemeStep() {

            private int countSteps = 10;
            private SchemeStepHandler onCompleteHandler;

            private ObjectToFind2D target = el;

            @Override
            public ObjectToFind2D getTargetElement() {
                return target;
            }

            @Override
            public boolean isComplete() {
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
        };

        finderScheme.addStep(0, schemeStep);

        return schemeStep;
    }
    public SchemeStep setObjectForSecondStep(ObjectToFind2D el)
    {
        SchemeStep schemeStep = new SchemeStep() {
            private SchemeStepHandler onCompleteHandler;
            private ObjectToFind2D target = el;

            @Override
            public ObjectToFind2D getTargetElement() {
                return target;
            }

            @Override
            public boolean isComplete() {
                return finderObject.getCurrentPoint().getX() == el.getPoint().getX() && finderObject.getCurrentPoint().getY() == el.getPoint().getY();
            }

            @Override
            public void update() {
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
        };
        finderScheme.addStep(1, schemeStep);

        return schemeStep;

    }

    public SchemeStep setObjectForThirdStep(ObjectToFind2D el)
    {
        SchemeStep schemeStep = new SchemeStep() {

            private ObjectToFind2D target = el;
            private SchemeStepHandler onCompleteHandler;


            @Override
            public ObjectToFind2D getTargetElement() {
                return target;
            }

            @Override
            public boolean isComplete() {
                return finderObject.getCurrentPoint().getX() == el.getPoint().getX() && finderObject.getCurrentPoint().getY() == el.getPoint().getY();
            }

            @Override
            public void update() {
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
        };

        finderScheme.addStep(2, schemeStep);

        return schemeStep;
    }

    @Override
    public ObjectToFind2D check() {
        return finderScheme.check();
    }
}
