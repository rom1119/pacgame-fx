package com.pacgame.provider.stage;

import com.pacgame.provider.Stage;

public class PrimaryStage extends Stage {

    public PrimaryStage() {
        super();
    }

    void setProxyObject(javafx.stage.Stage stage)
    {
        this.getProxy().setProxyObject(stage);
    }
}
