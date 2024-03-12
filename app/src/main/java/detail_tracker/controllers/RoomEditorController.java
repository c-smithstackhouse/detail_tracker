package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RoomEditorController {

    @FXML
    private TitledPane mainTitlePane;

    @FXML
    private ScrollPane mainScrollPane;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label floorNumLabel, commaLabel, roomNumLabel;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab infoTab, electricalTab, finishesTab, flooringTab, plumbingTab, trimTab;

    @FXML
    private ChoiceBox roomTypeChoiceBox;

    @FXML
    private TextField architecturalCodeTextField, roomNameTextField, squareFootageTextField;

    @FXML
    private TableView electricalTable, finTableView, flooringTableView, plumTableView, trimTableView;

    @FXML
    private Button nextButton, backButton, homeButton;

    @FXML
    public void handleArchCodeTextFieldAction() {
        // Implement business logic here
    }

    @FXML
    public void handleRoomNameTextFieldAction() {
        // Implement business logic here
    }

    @FXML
    public void handleSFTextFieldAction() {
        // Implement business logic here
    }

    @FXML
    public void handleNextButtonAction() {
        // Implement business logic here
    }

    @FXML
    public void handleBackButtonAction() {
        // Implement business logic here
    }

    @FXML
    public void handleHomeButtonAction() {
        // Implement business logic here
    }
}