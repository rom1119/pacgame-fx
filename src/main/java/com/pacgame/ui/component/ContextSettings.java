package com.pacgame.ui.component;

import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import com.pacgame.ui.event.eventHandler.OnBackToMenu;
import com.pacgame.ui.event.eventHandler.OnSaveContextSettings;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContextSettings extends SubView {

    private Label speedLabel;
    private Slider speedEl;

    private Button back;
    private Button save;

    private Menu menu;

    private PacmanController pacmanController;
    private ObservableList<MazeController> mazeCollection;

    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();

//        pane.setPadding(new Insets(100));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
//        pane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        pane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.toFront();
//        vBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(vBox);
        vBox.getChildren().add(createSpeedLabel());
        vBox.getChildren().add(createSpeedEl());

        BorderPane buttons = new BorderPane();

        buttons.setPrefWidth(width);
        buttons.setPrefHeight(height);

        buttons.setLeft(createBackButton());
        buttons.setRight(createSaveButton());

        vBox.getChildren().add(buttons);


        hide();

        pane.toFront();

        return pane;
    }

    public Label createSpeedLabel()
    {
        speedLabel = new Label("Prędkość: ");
        speedLabel.setFont(new Font(30));
        speedLabel.setTextFill(Color.WHITE);

        return speedLabel;
    }

    public Slider createSpeedEl()
    {
        speedEl = new Slider();
        speedEl.setShowTickMarks(true);
        speedEl.setShowTickLabels(true);
        speedEl.setMin(5);
        speedEl.setMax(20);
        speedEl.setValue(10);
        speedEl.setMajorTickUnit(50);
        speedEl.setMinorTickCount(5);
        speedEl.setBlockIncrement(10);

        return speedEl;
    }

    public Button createBackButton()
    {
        back = new Button("Powrót");
        back.setFont(new Font(20));
//        back.setTextFill(Color.WHITE);

        setOnBackButton();

        return back;
    }

    public Button createSaveButton()
    {
        save = new Button("Zapisz");
        save.setFont(new Font(20));

        setOnSaveButton();

//        back.setTextFill(Color.WHITE);

        return save;
    }

    public void changeGlobalSpeedMove()
    {
        int newSpeed = (int) speedEl.getValue();

        pacmanController.getControlledObject().setSpeedMove(newSpeed);
//        pacmanController.getMovementManager().changeSpeedAnimationMove();

        for (MazeController mazeController : getMazeCollection()) {
            mazeController.getControlledObject().setSpeedMove(newSpeed);
//            mazeController.getMovementManager().changeSpeedAnimationMove();
        }
    }

    private void setOnBackButton()
    {
        back.setOnAction(new OnBackToMenu(this, getMenu()));
    }

    private void setOnSaveButton()
    {
        save.setOnAction(new OnSaveContextSettings(this));
    }


    public PacmanController getPacmanController() {
        return pacmanController;
    }

    public void setPacmanController(PacmanController pacmanController) {
        this.pacmanController = pacmanController;
    }

    public ObservableList<MazeController> getMazeCollection() {
        return mazeCollection;
    }

    public void setMazeCollection(ObservableList<MazeController> mazeCollection) {
        this.mazeCollection = mazeCollection;
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
