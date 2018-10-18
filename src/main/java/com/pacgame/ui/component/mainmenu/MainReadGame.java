package com.pacgame.ui.component.mainmenu;

import com.pacgame.App;
import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import com.pacgame.ui.component.Menu;
import com.pacgame.ui.component.SubView;
import com.pacgame.ui.event.eventHandler.OnBackToMenu;
import com.pacgame.ui.event.eventHandler.OnReadGameSelect;
import com.pacgame.board.model.SavedGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainReadGame extends SubView {

    private Label nameLabel;
    private ListView<SavedGame> savesList;
    private ObservableList<SavedGame> savesCollection;

    private Button backBtn;
    private Button readGameBtn;

    private Menu menu;

    private PacmanController pacmanController;
    private ObservableList<MazeController> mazeCollection;

    public MainReadGame() {
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
        readGameBtn = new Button("Wczytaj");
        readGameBtn.setFont(new Font(20));

        setOnReadGameButton();

//        backBtn.setTextFill(Color.WHITE);

        return readGameBtn;
    }

    public void addListElement()
    {

//        savesCollection.add(savedGame);
    }

    private SavedGame createReadGame()
    {
        SavedGame savedGame = new SavedGame();


        return savedGame;
    }

    private void setOnBackButton()
    {
        backBtn.setOnAction(new OnBackToMenu(this, App.getMainMenu()));
    }

    private void setOnReadGameButton()
    {
        readGameBtn.setOnAction(new OnReadGameSelect(this, App.getMainMenu()));
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
