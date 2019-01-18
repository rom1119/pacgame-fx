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
import com.pacgame.game.adapter.board.finder.shema.steps.maze.FirstStep;
import com.pacgame.game.adapter.board.finder.shema.steps.maze.SecondStep;
import com.pacgame.game.adapter.board.finder.shema.steps.maze.ThirdStep;
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
        SchemeStep schemeStep = new FirstStep(el, finderObject);

        finderScheme.addStep(0, schemeStep);

        return schemeStep;
    }
    public SchemeStep setObjectForSecondStep(ObjectToFind2D el)
    {
        SchemeStep schemeStep = new SecondStep(el, finderObject);

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
        SchemeStep schemeStep = new ThirdStep(el, finderObject);

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
