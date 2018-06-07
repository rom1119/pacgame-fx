package com.pacgame;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

public abstract class View {

    protected FlowPane pane;

    public FlowPane getPane() {
        return pane;
    }

    public void setPane(FlowPane pane) {
        this.pane = pane;
    }

    public void visible()
    {
        pane.setVisible(true);
    }

    public void invisible()
    {
        pane.setVisible(false);
    }

    public boolean isVisible()
    {
        return pane.isVisible();
    }

    public abstract Node getView(int width, int height);
}
