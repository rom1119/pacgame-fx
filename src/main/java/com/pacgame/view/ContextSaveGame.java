package com.pacgame.view;

import com.pacgame.controller.MazeController;
import com.pacgame.controller.PacmanController;
import com.pacgame.event.eventHandler.menu.OnBackToMenu;
import com.pacgame.event.eventHandler.menu.OnSaveGame;
import com.pacgame.model.SavedGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContextSaveGame extends SubView {
    private Label nameLabel;
    private TextField nameEl;
    private ListView<SavedGame> savesList;
    private ObservableList<SavedGame> savesCollection;

    private Button backBtn;
    private Button readGameBtn;

    private Menu menu;

    private PacmanController pacmanController;
    private ObservableList<MazeController> mazeCollection;

    public ContextSaveGame() {
        savesCollection = FXCollections.observableArrayList();
    }

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
        vBox.getChildren().add(createNameLabel());
        vBox.getChildren().add(createNameEl());
        vBox.getChildren().add(createSavesList());

        BorderPane buttons = new BorderPane();
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        buttons.setPrefWidth(width);
        buttons.setPrefHeight(height);

        buttons.setLeft(createBackButton());
        buttons.setRight(createSaveButton());

        vBox.getChildren().add(buttons);


        hide();

        pane.toFront();

        return pane;
    }

    public Label createNameLabel()
    {
        nameLabel = new Label("Nazwa: ");
        nameLabel.setFont(new Font(30));
        nameLabel.setTextFill(Color.WHITE);

        return nameLabel;
    }

    public TextField createNameEl()
    {
        nameEl = new TextField();
        nameEl.setMaxWidth(250);

        return nameEl;
    }

    public ListView createSavesList()
    {
        savesList = new ListView<>();
        savesList.setItems(savesCollection);
        savesList.setEditable(false);
//        nameEl.setMaxWidth(250);

        return savesList;
    }

    public Button createBackButton()
    {
        backBtn = new Button("Powrót");
        backBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnBackButton();

        return backBtn;
    }

    public Button createSaveButton()
    {
        readGameBtn = new Button("Zapisz");
        readGameBtn.setFont(new Font(20));

        setOnSaveButton();

//        backBtn.setTextFill(Color.WHITE);

        return readGameBtn;
    }

    public void addListElement()
    {
        SavedGame savedGame = createSavedGame();

        savesCollection.add(savedGame);
    }

    private SavedGame createSavedGame()
    {
        SavedGame savedGame = new SavedGame();

        savedGame.setName(nameEl.getText());
        savedGame.setLives(Integer.parseInt(pacmanController.getControlledObject().getLives()));
        savedGame.setScore(Integer.parseInt(pacmanController.getScore()));
        savedGame.setPacmanMapPoint(pacmanController.getMovementManager().getCurrentPoint());
        savedGame.setMazeCollection(mazeCollection);

        return savedGame;
    }

    private void setOnBackButton()
    {
        backBtn.setOnAction(new OnBackToMenu(this, getMenu()));
    }

    private void setOnSaveButton()
    {
        readGameBtn.setOnAction(new OnSaveGame(this));
    }


    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ObservableList<MazeController> getMazeCollection() {
        return mazeCollection;
    }

    public void setMazeCollection(ObservableList<MazeController> mazeCollection) {
        this.mazeCollection = mazeCollection;
    }

    public PacmanController getPacmanController() {
        return pacmanController;
    }

    public void setPacmanController(PacmanController pacmanController) {
        this.pacmanController = pacmanController;
    }
}
