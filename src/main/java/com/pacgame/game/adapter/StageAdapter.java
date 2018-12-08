package com.pacgame.game.adapter;

import com.pacgame.game.IScene;
import com.pacgame.game.IStage;
import com.pacgame.provider.StageProvider;
import com.pacgame.provider.StageProviderImpl;
import javafx.stage.Stage;

public class StageAdapter implements IStage {

    private com.pacgame.stage.Stage stage;

    public StageAdapter(Stage stage) {
        StageProvider stageProvider = new StageProviderImpl();
        com.pacgame.provider.Stage fromExternalStage = stageProvider.createFromExternalStage(stage);
        this.stage = new com.pacgame.stage.Stage(fromExternalStage);
    }

    @Override
    public void setResizable(boolean b) {
        stage.setResizable(b);
    }

    @Override
    public void setTitle(String s) {
        stage.setTitle(s);
    }

    @Override
    public void show() {
        stage.show();
    }

    @Override
    public void setScene(IScene scene) {
        stage.setScene(((com.pacgame.game.adapter.SceneAdapter) scene).getProvidedObject());
    }
}
