package com.pacgame.game.adapter.board.finder.shema;

import com.pacgame.finder.FindPoint2D;
import com.pacgame.finder.Finder;
import com.pacgame.finder.FinderRule;
import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.adapter.board.MapPointAdapter;
import com.pacgame.game.adapter.board.MazeAdapter;
import com.pacgame.game.adapter.board.finder.FindPoint2DAdapter;
import com.pacgame.game.adapter.board.finder.ObjectToFindFactory;
import com.pacgame.game.adapter.board.finder.rules.NotTurnAroundRule;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.scheme.Scheme;
import com.pacgame.scheme.SchemeStep;
import com.pacgame.scheme.SchemeStepHandler;
import com.pacgame.scheme.impl.FinderScheme;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MazeFinderSchema implements Scheme<ObjectToFind2D> {

    private FinderScheme<ObjectToFind2D> finderScheme;
    private IMaze finderObject;
    private Map<String, FinderRule> rules;

    public MazeFinderSchema(IMaze finderObject) {
        createFinderSchema();
        this.finderObject = finderObject;
        this.rules = new HashMap<>();
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
                return finderObject.getCurrentPoint().getX() == target.getPoint().getX() && finderObject.getCurrentPoint().getY() == target.getPoint().getY();
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
        schemeStep.setOnComplete(() -> {
            addRule(new com.pacgame.game.adapter.board.finder.rules.DoorCloseRule());
            addRule(new NotTurnAroundRule(((MazeAdapter) finderObject).getCurrentPointValueObject()));
        });


        finderScheme.addStep(1, schemeStep);

        return schemeStep;

    }

    private void addRule(FinderRule rule) {
        rules.put(rule.getClass().getSimpleName(), rule);
        ((MazeAdapter) finderObject).getFinder().addRule(rule);
    }

    private void removeRule(Class<FinderRule> ruleClass) {
        if (rules.containsKey(ruleClass.getSimpleName())) {
            FinderRule finderRule = rules.remove(ruleClass.getSimpleName());
            ((MazeAdapter) finderObject).getFinder().removeRule(finderRule);
        }
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
                return finderObject.getCurrentPoint().getX() == target.getPoint().getX() && finderObject.getCurrentPoint().getY() == target.getPoint().getY();
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

    public void toFirstStep() {
        finderScheme.toFirstStep();
    }
}
