package com.pacgame.ui.component.mainmenu;

import com.pacgame.App;
import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import com.pacgame.data.model.ResponseError;
import com.pacgame.ui.component.Menu;
import com.pacgame.ui.component.SubView;
import com.pacgame.ui.event.eventHandler.OnBackToMenu;
import com.pacgame.ui.event.eventHandler.OnEditUserAccount;
import com.pacgame.ui.event.eventHandler.OnSelectImageButton;
import com.sun.tools.javac.comp.Flow;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserAccount extends SubView {

    private Label idLabel;
    private Label idEl;

    private Label usernameLabel;
    private Label usernameEl;

    private Label nameLabel;
    private Label nameEl;
    private TextField nameInput;
    private Label nameError;


    private Label lastNameLabel;
    private Label lastNameEl;
    private TextField lastNameInput;
    private Label lastNameError;


    private Label imageLabel;
    private ImageView imageEl;
    private Label imageError;
    private File image;

    private Label rolesLabel;
    private Label rolesEl;

    private Label fullScoreLabel;
    private Label fullScoreEl;

    private Button selectImageBtn;
    private FileChooser imageChooser;

    private Button backBtn;
    private Button editBtn;

    private com.pacgame.ui.component.Menu menu;

    private Stage mainStage;


    private PacmanController pacmanController;
    private ObservableList<MazeController> mazeCollection;
    private boolean editable;

    private Map<String, Label> formErrorsMap = new HashMap<>();
    private Map<String, TextField> formInputsMap = new HashMap<>();
    private VBox firstNamePane;
    private VBox lastNamePane;


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

        vBox.getChildren().add(createIdLabel());
        vBox.getChildren().add(createIdEl());

        FlowPane namePane = new FlowPane();

        firstNamePane =  new VBox();
        firstNamePane.setPrefWidth(width / 2);
//        firstNamePane.setPrefHeight(height / 2);

        firstNamePane.getChildren().addAll(createNameLabel(), createNameEl());

        lastNamePane =  new VBox();
        lastNamePane.setPrefWidth(width / 2);
//        lastNamePane.setPrefHeight(height / 2);

        lastNamePane.getChildren().addAll(createLastNameLabel(), createLastNameEl());

        namePane.getChildren().addAll(firstNamePane, lastNamePane);
        vBox.getChildren().add(namePane);

        vBox.getChildren().add(createEmailLabel());
        vBox.getChildren().add(createEmailEl());

        vBox.getChildren().add(createFullScoreLabel());
        vBox.getChildren().add(createFullScoreEl());

        vBox.getChildren().add(createRolesLabel());
        vBox.getChildren().add(createRolesEl());

        vBox.getChildren().add(createImageLabel());
        vBox.getChildren().add(createImageEl(width / 4, 100));

        vBox.getChildren().add(createSelectImageBtn());
        vBox.getChildren().add(createImageErrorLabel(width));

        BorderPane buttons = new BorderPane();
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        buttons.setPrefWidth(width);
        buttons.setPrefHeight(height);

        buttons.setLeft(createBackButton());
        buttons.setRight(createEditButton());

        vBox.getChildren().add(buttons);


        hide();

        pane.toFront();

        return pane;
    }

    private Label createLastNameLabel()
    {
        lastNameLabel = new Label("Nazwisko: ");
        lastNameLabel.setFont(new Font(20));
        lastNameLabel.setTextFill(Color.WHITE);

        return lastNameLabel;
    }

    private Label createLastNameEl()
    {
        if (lastNameEl == null) {
            lastNameEl = new Label();
        }
        lastNameEl.setMaxWidth(250);
        lastNameEl.setFont(new Font(20));
        lastNameEl.setTextFill(Color.WHITE);

        return lastNameEl;
    }

    private TextField createLastNameInput()
    {
        lastNameInput = new TextField();
        lastNameInput.setMaxWidth(250);
        lastNameInput.setVisible(false);

        formInputsMap.put("lastName", lastNameInput);

        return lastNameInput;
    }

    private Label createLastNameError()
    {
        lastNameError = new Label("Username incorrect");
        lastNameError.setFont(new Font(20));
        lastNameError.setTextFill(Color.RED);
        lastNameError.setVisible(false);

        formErrorsMap.put("lastName", lastNameError);

        return lastNameError;
    }

    private Label createNameLabel()
    {
        nameLabel = new Label("Imię: ");
        nameLabel.setFont(new Font(20));
        nameLabel.setTextFill(Color.WHITE);

        return nameLabel;
    }

    private Label createNameEl()
    {
        if (nameEl == null) {
            nameEl = new Label();
        }
        nameEl.setMaxWidth(250);
        nameEl.setFont(new Font(20));
        nameEl.setTextFill(Color.WHITE);
        nameEl.setVisible(true);

        return nameEl;
    }

    private TextField createNameInput()
    {
        nameInput = new TextField();
        nameInput.setMaxWidth(250);
        nameInput.setVisible(false);

        formInputsMap.put("firstName", nameInput);

        return nameInput;
    }

    private Label createNameError()
    {
        nameError = new Label("Username incorrect");
        nameError.setFont(new Font(20));
        nameError.setTextFill(Color.RED);
        nameError.setVisible(false);

        formErrorsMap.put("firstName", nameError);

        return nameError;
    }

    private Label createIdLabel()
    {
        idLabel = new Label("ID użytkownika: ");
        idLabel.setFont(new Font(20));
        idLabel.setTextFill(Color.WHITE);

        return idLabel;
    }

    private Label createIdEl()
    {
        idEl = new Label();
        idEl.setMaxWidth(250);
        idEl.setFont(new Font(20));
        idEl.setTextFill(Color.WHITE);

        return idEl;
    }

    private Label createRolesLabel()
    {
        rolesLabel = new Label("Role użytkownika w systemie: ");
        rolesLabel.setFont(new Font(20));
        rolesLabel.setTextFill(Color.WHITE);

        return rolesLabel;
    }

    private Label createRolesEl()
    {
        rolesEl = new Label();
        rolesEl.setMaxWidth(250);
        rolesEl.setFont(new Font(20));
        rolesEl.setTextFill(Color.WHITE);

        return rolesEl;
    }


    private Label createEmailLabel()
    {
        usernameLabel = new Label("Email: ");
        usernameLabel.setFont(new Font(20));
        usernameLabel.setTextFill(Color.WHITE);

        return usernameLabel;
    }

    private Label createEmailEl()
    {
        usernameEl = new Label();
        usernameEl.setMaxWidth(250);
        usernameEl.setFont(new Font(20));
        usernameEl.setTextFill(Color.WHITE);


        return usernameEl;
    }

    private Label createFullScoreLabel()
    {
        fullScoreLabel = new Label("Punkty: ");
        fullScoreLabel.setFont(new Font(20));
        fullScoreLabel.setTextFill(Color.WHITE);

        return fullScoreLabel;
    }

    private Label createFullScoreEl()
    {
        fullScoreEl = new Label();
        fullScoreEl.setMaxWidth(250);
        fullScoreEl.setFont(new Font(20));
        fullScoreEl.setTextFill(Color.WHITE);

        return fullScoreEl;
    }

    private FileChooser createImageChooserEl()
    {
        imageChooser = new FileChooser();
        imageChooser.setTitle("Wybierz zdjęcie");
        imageChooser.setSelectedExtensionFilter(
                new FileChooser.ExtensionFilter("dostępne są tyko zdjęcia",
                Arrays.asList("image/jpg", "image/jpeg", "image/png")
        ));

        return imageChooser;
    }

    private Button createEditButton()
    {
        editBtn = new Button("Edytuj profil");
        editBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnEditButton();

        return editBtn;
    }



    private Button createBackButton()
    {
        backBtn = new Button("Powrót do menu");
        backBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnBackButton();

        return backBtn;
    }

    private Label createImageLabel()
    {
        imageLabel = new Label("Awatar: ");
        imageLabel.setFont(new Font(20));
        imageLabel.setTextFill(Color.WHITE);

        return imageLabel;
    }

    private ImageView createImageEl(int width, int height)
    {
        imageEl = new ImageView();
        imageEl.setFitWidth(width);
        imageEl.setFitHeight(height);

        return imageEl;
    }

    private Button createSelectImageBtn()
    {
        selectImageBtn = new Button("Wybierz zdjęcie");
        selectImageBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnSelectImageBtn();

        return selectImageBtn;
    }

    private Label createImageErrorLabel(int width)
    {
        imageError = new Label("");
        imageError.setFont(new Font(18));
        imageError.setTextFill(Color.RED);
        imageError.setVisible(false);
        imageError.setMaxWidth(width);

        return imageError;
    }

    private void setOnEditButton() {
        editBtn.setOnAction(new OnEditUserAccount(this, App.ApiService));

    }
    private void setOnSelectImageBtn() {
        selectImageBtn.setOnAction(new OnSelectImageButton(this, getMainStage(), App.ApiService));
    }


    private void setOnBackButton()
    {
        backBtn.setOnAction(new OnBackToMenu(this, App.getMainMenu()));
    }



    @Override
    public com.pacgame.ui.component.Menu getMenu() {
        return menu;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Label getIdEl() {
        return idEl;
    }

    public void setIdEl(Label idEl) {
        this.idEl = idEl;
    }

    public Label getUsernameEl() {
        return usernameEl;
    }

    public void setUsernameEl(Label usernameEl) {
        this.usernameEl = usernameEl;
    }

    public Label getNameEl() {
        return nameEl;
    }

    public void setNameEl(Label nameEl) {
        this.nameEl = nameEl;
    }

    public Label getLastNameEl() {
        return lastNameEl;
    }

    public void setLastNameEl(Label lastNameEl) {
        this.lastNameEl = lastNameEl;
    }

    public ImageView getImageEl() {
        return imageEl;
    }

    public void setImageEl(ImageView imageEl) {
        this.imageEl = imageEl;
    }

    public Label getRolesEl() {
        return rolesEl;
    }

    public void setRolesEl(Label rolesEl) {
        this.rolesEl = rolesEl;
    }

    public Label getFullScoreEl() {
        return fullScoreEl;
    }

    public void setFullScoreEl(Label fullScoreEl) {
        this.fullScoreEl = fullScoreEl;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public Label getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(Label imageLabel) {
        this.imageLabel = imageLabel;
    }

    public void updateImage(Image image)
    {
        this.getImageEl().setImage(image);
    }

    public Label getImageError() {
        return imageError;
    }

    public void setImageError(Label imageError) {
        this.imageError = imageError;
    }

    public Label getNameError() {
        return nameError;
    }

    public void setNameError(Label nameError) {
        this.nameError = nameError;
    }

    public Label getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(Label lastNameError) {
        this.lastNameError = lastNameError;
    }

    public TextField getNameInput() {
        return nameInput;
    }

    public void setNameInput(TextField nameInput) {
        this.nameInput = nameInput;
    }

    public TextField getLastNameInput() {
        return lastNameInput;
    }

    public void setLastNameInput(TextField lastNameInput) {
        this.lastNameInput = lastNameInput;
    }

    public void changeLabelsOnInputs() {
        getNameEl().setVisible(false);
        getLastNameEl().setVisible(false);
        firstNamePane.getChildren().remove(getNameEl());
        lastNamePane.getChildren().remove(getLastNameEl());

        firstNamePane.getChildren().add(createNameInput());
        lastNamePane.getChildren().add(createLastNameInput());

        getNameInput().setVisible(true);
        getNameInput().setText(getNameEl().getText());
        getLastNameInput().setVisible(true);
        getLastNameInput().setText(getLastNameEl().getText());

    }

    public void changeInputsOnLabels() {
        firstNamePane.getChildren().add(getNameEl());
        lastNamePane.getChildren().add(getLastNameEl());
        getNameEl().setVisible(true);
        getLastNameEl().setVisible(true);

        firstNamePane.getChildren().remove(getNameInput());
        lastNamePane.getChildren().remove(getLastNameInput());

        getNameInput().setVisible(false);
        getNameInput().setText("");
        getLastNameInput().setVisible(false);
        getLastNameInput().setText("");

    }

    public void showFormErrors(ResponseError responseError) {
        responseError.getErrors().forEach(el -> {
            if (formErrorsMap.containsKey(el.getField())) {
                formErrorsMap.get(el.getField()).setVisible(true);
                formErrorsMap.get(el.getField()).setText(el.getMessage());
                switch (el.getField()) {
                    case "firstName":
                        firstNamePane.getChildren().add( formErrorsMap.get(el.getField()));
                        break;
                    case  "lastName":
                        lastNamePane.getChildren().add( formErrorsMap.get(el.getField()));
                        break;
                    default:
                        showMainError(el.getMessage());
                }
            }
        });
    }

    public void resetErrors()
    {
        formErrorsMap.forEach((key, el) -> {
            el.setText("");
            el.setVisible(false);
            switch (key) {
                case "firstName":
                    firstNamePane.getChildren().remove( formErrorsMap.get(key));
                    break;
                case  "lastName":
                    lastNamePane.getChildren().remove( formErrorsMap.get(key));
                    break;
                default:
            }
        });

        imageError.setText("");
        imageError.setVisible(false);

//        getMainError().setText("");
//        getMainError().setVisible(false);
    }

    public void showMainError(String msgError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Problem z zapisem");
        alert.setHeaderText(null);
        alert.setContentText(msgError);

        alert.showAndWait();
    }

    public void showSuccessSaveMsg() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Powiadomienie o zapisie");
        alert.setHeaderText(null);
        alert.setContentText("Zapisano");

        alert.showAndWait();
    }

//    public void resetFields() {
//        getEmailEl().setText("");
//        getPasswordEl().setText("");
//        getPasswordConfEl().setText("");
//        getAgreeTerms().setSelected(false);
//    }
}
