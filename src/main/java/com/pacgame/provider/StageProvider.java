package com.pacgame.provider;

import com.pacgame.provider.stage.PrimaryStage;

public abstract class StageProvider extends Provider {

    public abstract Stage createFromExternalStage(PrimaryStage stage);
}
