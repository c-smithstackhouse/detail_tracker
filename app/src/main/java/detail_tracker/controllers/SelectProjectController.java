package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Group;


public class SelectProjectController {

    @FXML
    private ScrollPane mainScrollPane;

    @FXML
    private TitledPane mainTitledPane;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label title;

    @FXML
    private VBox dropdownVBox;

    @FXML
    private Group activeProjGroup;

    @FXML
    private Label activeProjLabel;

    @FXML
    private ChoiceBox activeProjChoiceBox;

    @FXML
    private Group archivedProjGroup;

    @FXML
    private Label archivedProjLabel;

    @FXML
    private ChoiceBox archivedProjChoiceBox;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button goBtn;

    @FXML
    private Button homeBtn;

    @FXML
    public void handleGoButtonAction() {
        // Implement your logic here
    }

    @FXML
    public void handleHomeButtonAction() {
        // Implement your logic here
    }
}