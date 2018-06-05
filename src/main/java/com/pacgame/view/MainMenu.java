package com.pacgame.view;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.controller.MazeController;
import com.pacgame.event.eventHandler.OnExitSelect;
import com.pacgame.event.eventHandler.OnStartGameSelect;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Collection;
import java.util.function.Consumer;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;

public class MainMenu extends View {
    private FlowPane pane;
    private Label startGameLabel;
    private Label settingsLabel;
    private Label exitLabel;
    private SimpleObjectProperty<Label> checkedMenuOption;
    private Scene scene;
    public static ObservableList<Node> menuOptions;
    private int iterator;

    public MainMenu(Scene scene) {
        this.scene = scene;
        menuOptions = FXCollections.observableArrayList();
        checkedMenuOption = new SimpleObjectProperty<>();
        iterator = 0;
        setOnChangeCheckedOption();
        setOnKeyPress();
    }

    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();
//        pane.setPadding(new Insets(100));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        pane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.setTranslateX();
//        vBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(vBox);
        vBox.getChildren().add(createStartGameLabel());
        vBox.getChildren().add(createSettingsLabel());
        vBox.getChildren().add(createExitLabel());


        menuOptions.addAll(startGameLabel, settingsLabel, exitLabel);
        removeBorderColorManuOptions();
        checkMenuOption((Label) menuOptions.get(0));

        pane.toFront();

        return pane;
    }

    public Label createStartGameLabel()
    {
        startGameLabel = new Label("Rozpocznij");
        startGameLabel.setFont(new Font(40));
        startGameLabel.setTextFill(Color.WHITE);
        pane.getChildren().add(startGameLabel);

        setOnStartGameSelect();

        return startGameLabel;
    }

    public Label createSettingsLabel()
    {
        settingsLabel = new Label("Ustawienia");
        settingsLabel.setFont(new Font(40));
        settingsLabel.setTextFill(Color.WHITE);
        pane.getChildren().add(settingsLabel);

        return settingsLabel;
    }

    public Label createExitLabel()
    {
        exitLabel = new Label("Wyjście");
        exitLabel.setFont(new Font(40));
        exitLabel.setTextFill(Color.WHITE);
        pane.getChildren().add(exitLabel);

        setOnExitSelect();

        return exitLabel;
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

    private void setOnKeyPress()
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == UP && !App.isRunning()) {
                Label prev = (Label) getPrevMenuOption();
                removeBorderColorManuOptions();
                checkMenuOption(prev);
            } else if (e.getCode() == DOWN && !App.isRunning()) {
                Label next = (Label) getNextMenuOption();
                removeBorderColorManuOptions();
                checkMenuOption(next);
            }
        });

    }

    private void checkMenuOption(Label opt) {
        setCheckedMenuOption(opt);
        if (opt != null) {
            opt.requestFocus();

        }
    }

    private void setOnChangeCheckedOption()
    {
        checkedMenuOption.addListener(new ChangeListener<Label>() {
            @Override
            public void changed(ObservableValue<? extends Label> observable, Label oldValue, Label newValue) {
                Label menuOption = newValue;
                menuOption.setBorder(new Border(new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, null, new BorderWidths(10))));
            }
        });
    }

    private Node getNextMenuOption()
    {
        if (menuOptions.isEmpty()) {
            return null;
        }
//        System.out.println(iterator);
//        System.out.println(menuOptions.size());
        if ( iterator == menuOptions.size() - 1 ) {
            iterator = 0;
            return menuOptions.get(iterator);
        } else {
            iterator++;
            return menuOptions.get(iterator);
        }
    }

    private Node getPrevMenuOption()
    {
        if (menuOptions.isEmpty()) {
            return null;
        }

        if (iterator == 0) {
            iterator = menuOptions.size() - 1;
            return menuOptions.get(iterator);
        } else {
            iterator--;
            return menuOptions.get(iterator);
        }
    }

    private void removeBorderColorManuOptions()
    {
        for (Node el: menuOptions) {
            Label label = (Label) el;
            label.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, null, new BorderWidths(10))));

        }
    }

    public Label getCheckedMenuOption() {
        return checkedMenuOption.get();
    }

    public SimpleObjectProperty<Label> checkedMenuOptionProperty() {
        return checkedMenuOption;
    }

    public void setCheckedMenuOption(Label checkedMenuOption) {
        this.checkedMenuOption.set(checkedMenuOption);
    }

    private void setOnStartGameSelect()
    {
        startGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnStartGameSelect(this));
    }

    private void setOnExitSelect()
    {
        exitLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnExitSelect(this));
    }

    public void updateFocusMenuOption()
    {
        getCheckedMenuOption().requestFocus();
    }
}
