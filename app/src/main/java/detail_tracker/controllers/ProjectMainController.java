package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class ProjectMainController {

    @FXML
    private ScrollPane mainScrollPane;

    @FXML
    private TitledPane mainTitledPane;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label title;

    @FXML
    private VBox tableVBox;

    @FXML
    private Label infoLabel;

    @FXML
    private ScrollPane tableScrollPane;

    @FXML
    private TableView<?> tableView;

    @FXML
    private VBox dropdownVBox;

    @FXML
    private Label chooseFloorLabel;

    @FXML
    private ChoiceBox<?> chooseFloorChoiceBox;

    @FXML
    private Label chooseRoomLabel;

    @FXML
    private ChoiceBox<?> chooseRoomChoiceBox;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button goButton;

    @FXML
    private Button exportButton;

    @FXML
    private Button homeButton;

    @FXML
    public void handleGoButtonAction() {
        // TODO: Implement your logic here
    }

    @FXML
    public void handleExportButton() {
        // TODO: Implement your logic here
    }

    @FXML
    public void handleHomeButtonAction() {
        // TODO: Implement your logic here
    }
}
