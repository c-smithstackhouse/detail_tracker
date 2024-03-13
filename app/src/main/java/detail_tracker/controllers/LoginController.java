package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class LoginController {

    @FXML
    private ScrollPane mainScrollPane;

    @FXML
    private TitledPane mainTitledPane;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label title;

    @FXML
    private VBox loginTextfieldVBox;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button loginButton;

/*     @FXML
    public void handleUsernameAction() {
        // TODO: Implement business logic here
    } */

/*     @FXML
    public void handlePasswordAction() {
        // TODO: Implement business logic here
    } */

    @FXML
    public void handleLoginButtonAction(ActionEvent event) {
    try {
        // Load the SelectProject view via the relative path
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app/src/main/java/detail_tracker/views/SelectProject.fxml"));
        Parent root = loader.load();

        // Get the current stage and set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

        // Optional: Set the title of the stage
        stage.setTitle("Select Project");

        // Show the new scene
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}