package com.pacgame.provider;

import com.pacgame.provider.stage.PrimaryStage;
import com.pacgame.provider.stage.StageExternal;


public class StageProviderImpl implements StageProvider {

    @Override
    public Stage createFromExternalStage(javafx.stage.Stage stage) {
        return new StageExternal().getStage(stage);
    }
}
