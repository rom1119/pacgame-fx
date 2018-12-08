package com.pacgame.stage;

public class Stage implements IStage {

    private com.pacgame.provider.Stage providedObject;

    public Stage(com.pacgame.provider.Stage providedObject) {
        this.providedObject = providedObject;
    }

    @Override
    public void setResizable(boolean b) {
        providedObject.setResizable(b);
    }

    @Override
    public void setTitle(String s) {
        providedObject.setTitle(s);
    }

    @Override
    public void show() {
        providedObject.show();
    }

    @Override
    public void setScene(IScene scene) {
        providedObject.setScene(scene.getProvidedObject());
    }
}
