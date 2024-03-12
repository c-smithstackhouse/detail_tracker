package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class HouseLayoutController {

    @FXML
    private TitledPane mainTitlePane;

    @FXML
    private ScrollPane mainScrollPane;

    @FXML
    private VBox mainVBox;

    @FXML
    private Label houseLayoutTitle;

    @FXML
    private VBox floorCountVBox;

    @FXML
    private Label floorCountLabel;

    @FXML
    private ChoiceBox<?> floorCountChoiceBox;

    @FXML
    private VBox floorTypeVBox;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    public void handleNextButtonAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleBackButtonAction() {
        // TODO: Implement business logic here
    }

    //A method to set the floorcountlabel
    public void setFloorCountLabel(String floorCountLabel) {
        this.floorCountLabel.setText(floorCountLabel);
    }

    //A method to set the floorcountchoicebox to a value from 1 to 50
    public void setFloorCountChoiceBox() {
        for (int i = 1; i <= 50; i++) {
            floorCountChoiceBox.getItems().add(i, null);
        }
    }   
    

    
}