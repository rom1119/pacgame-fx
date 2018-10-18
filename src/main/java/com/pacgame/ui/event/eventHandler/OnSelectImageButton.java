package com.pacgame.ui.event.eventHandler;

import com.pacgame.data.model.Token;
import com.pacgame.data.service.ApiService;
import com.pacgame.ui.component.mainmenu.UserAccount;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OnSelectImageButton implements EventHandler<ActionEvent> {

    private UserAccount userAccount;
    private Stage stage;
    private ApiService apiService;

    public OnSelectImageButton(UserAccount userAccount, Stage stage, ApiService apiService) {
        this.userAccount = userAccount;
        this.stage = stage;
        this.apiService = apiService;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg")
//                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//                new ExtensionFilter("All Files", "*.*")
        );
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            userAccount.resetErrors();
            Token token = apiService.updateUserImage(selectedFile);
            if (token.getErrorType() == Token.CREDENTIALS_ERROR) {
                userAccount.getImageError().setText(token.getResponseError().getErrors().iterator().next().getMessage());
                userAccount.getImageError().setVisible(true);
            } else if (token.getErrorType() == Token.SERVER_ERROR) {
                userAccount.getImageError().setText("Problem z serwerem");
                userAccount.getImageError().setVisible(true);
            } else {
                userAccount.updateImage(apiService.getImageUser(token.getBody()));
            }

//            stage.display(selectedFile);
        }
    }
}
