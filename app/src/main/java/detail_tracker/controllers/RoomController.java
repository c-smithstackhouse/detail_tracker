package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;

public class RoomController {
    @FXML
    private TabPane roomTabPane;
    @FXML
    private ChoiceBox roomTypeChoiceBox;
    @FXML
    private TextField archCodeTextField;
    @FXML
    private TextField roomNameTextField;
    @FXML
    private TextField squareFootageTextField;
    @FXML
    private Tab elecTab;
    @FXML
    private TableView elecTable;
    @FXML
    private Tab finishesTab;
    @FXML
    private TableView finishesTable;
    @FXML
    private Tab flooringTab;
    @FXML
    private TableView flooringTable;
    @FXML
    private Tab plumbingTab;
    @FXML
    private TableView plumbTable;
    @FXML
    private Tab trimTab;
    @FXML
    private TableView trimTable;
    @FXML
    private HBox buttonHBox;
    @FXML
    private Button editButton;
    @FXML
    private Button backBtn;
    @FXML
    private Button homeBtn;

    @FXML
    public void handleEditButtonAction() {
        // Implement business action here
    }

    @FXML
    public void handleBackButtonAction() {
        // Implement business action here
    }

    @FXML
    public void handleHomeButtonAction() {
        // Implement business action here
    }
}