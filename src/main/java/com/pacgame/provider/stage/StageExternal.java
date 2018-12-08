package com.pacgame.provider.stage;

import com.pacgame.provider.stage.PrimaryStage;
import javafx.stage.Stage;

public class StageExternal {

    public PrimaryStage getStage(Stage stage)
    {
        PrimaryStage primaryStage = new PrimaryStage();
        primaryStage.setProxyObject(stage);

        return primaryStage;
    }
}
