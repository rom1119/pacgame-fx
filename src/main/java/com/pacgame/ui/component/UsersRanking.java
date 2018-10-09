package com.pacgame.ui.component;

import com.pacgame.data.model.User;
import com.pacgame.data.model.UserDetails;
import com.pacgame.ui.event.eventHandler.OnBackToMenu;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class UsersRanking extends SubView {

    protected Menu menu;
    private Button backBtn;


    private TableView<User> table = new TableView<User>();
    private final ObservableList<User> data =
            FXCollections.observableArrayList(
            );

    @Override
    public Node getView(int width, int height) {

        pane = new FlowPane();

//        pane.setPadding(new Insets(100));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);

        final Label label = new Label("Ranking użytkowników");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                cell -> new SimpleLongProperty(Long.valueOf(((User)((TableColumn.CellDataFeatures)cell).getValue()).idProperty().get()))
        );

        TableColumn nickCol = new TableColumn("Nick");
        nickCol.setMinWidth(100);
        nickCol.setCellValueFactory(
                new PropertyValueFactory<UserDetails, String>("username"));

        TableColumn firstNameCol = new TableColumn("Imię");
        firstNameCol.setMinWidth(200);
        firstNameCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
                    @Override
                    public ObservableValue call(TableColumn.CellDataFeatures param) {

                        return ((User)param.getValue()).getUserDetails().firstNameProperty();
                    }
                });

        TableColumn lastNameCol = new TableColumn("Nazwisko");
        lastNameCol.setMinWidth(200);
        lastNameCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
                    @Override
                    public ObservableValue call(TableColumn.CellDataFeatures param) {

                        return ((User)param.getValue()).getUserDetails().lastNameProperty();
                    }
                });

        TableColumn scoreCol = new TableColumn("Punkty");
        scoreCol.setMinWidth(200);
        scoreCol.setCellValueFactory(
                 cell -> new SimpleLongProperty(Long.valueOf(((User)((TableColumn.CellDataFeatures)cell).getValue()).getUserDetails().scoreProperty().get()))
        );


        table.setItems(data);
        table.getColumns().addAll(idCol, nickCol, scoreCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPrefWidth(width);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, createBackButton());

        pane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.toFront();
//        vBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(vbox);
        hide();
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        return pane;
    }

    public Button createBackButton()
    {
        backBtn = new Button("Powrót");
        backBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnBackButton();

        return backBtn;
    }

    private void setOnBackButton()
    {
        backBtn.setOnAction(new OnBackToMenu(this, getMenu()));
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ObservableList<User> getData() {
        return data;
    }
}
