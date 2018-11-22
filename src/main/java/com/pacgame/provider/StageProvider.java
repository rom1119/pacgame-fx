package com.pacgame.provider;

import com.pacgame.provider.stage.PrimaryStage;

public interface StageProvider {

    Stage createFromExternalStage(PrimaryStage stage);
}
