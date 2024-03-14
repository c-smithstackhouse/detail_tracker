package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import detail_tracker.entities.Project;
import detail_tracker.service.ClientService;
import java.io.IOException;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Parent;
import detail_tracker.service.ProjectService;


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
    private Label activeProjLabel;

    @FXML
    private ChoiceBox<String> activeProjChoiceBox;

    @FXML
    private Label archivedProjLabel;

    @FXML
    private ChoiceBox<String> archivedProjChoiceBox;

    @FXML
    private RadioButton createNewProjectRadioButton;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button goBtn;

    @FXML
    private Button homeBtn;

    private ProjectService projectService;

    @FXML
    private void initialize() {
        this.projectService = new ProjectService();

        List<String> activeProjects = projectService.getActiveProjects();
        activeProjChoiceBox.setItems(FXCollections.observableArrayList(activeProjects));

        List<String> archivedProjects = projectService.getArchivedProjects();
        archivedProjChoiceBox.setItems(FXCollections.observableArrayList(archivedProjects));

        // Add listeners to the selectedItemProperty of each ChoiceBox
        activeProjChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                archivedProjChoiceBox.setDisable(true);
                createNewProjectRadioButton.setDisable(true);
            } else {
                archivedProjChoiceBox.setDisable(false);
                createNewProjectRadioButton.setDisable(false);
            }
        });

        archivedProjChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                activeProjChoiceBox.setDisable(true);
                createNewProjectRadioButton.setDisable(true);
            } else {
                activeProjChoiceBox.setDisable(false);
                createNewProjectRadioButton.setDisable(false);
            }
        });

        createNewProjectRadioButton.selectedProperty().addListener((obs, wasPreviouslySelected, isNowSelected) -> {
            if (isNowSelected) {
                activeProjChoiceBox.setDisable(true);
                archivedProjChoiceBox.setDisable(true);
            } else {
                activeProjChoiceBox.setDisable(false);
                archivedProjChoiceBox.setDisable(false);
            }
        });
    }

    @FXML
    private void handleCreateNewProjectRadioButtonAction(ActionEvent event) {
        // Check if the radio button is selected
        boolean selected = createNewProjectRadioButton.isSelected();

        // Enable or disable the choice boxes based on the radio button's selected state
        activeProjChoiceBox.setDisable(selected);
        archivedProjChoiceBox.setDisable(selected);
    }

    @FXML
    private void handleGoButtonAction(ActionEvent event) {
        String activeProject = activeProjChoiceBox.getSelectionModel().getSelectedItem();
        String archivedProject = archivedProjChoiceBox.getSelectionModel().getSelectedItem();
        boolean createNewProject = createNewProjectRadioButton.isSelected();

        if (activeProject != null) {
            try {
                // Load the FXML for the ProjMain view
                FXMLLoader loader = new FXMLLoader(getClass().getResource("app/src/main/java/detail_tracker/views/ProjMain.fxml"));
                Parent root = loader.load();

                // Get the controller and pass the active project to it
                ProjectMainController controller = loader.getController();
                controller.setProject(activeProject);

                // Create a new scene and show it in a new stage
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                }
            System.out.println("Going to active project: " + activeProject);
        } else if (archivedProject != null) {
            try {
                // Load the FXML for the ProjMain view
                FXMLLoader loader = new FXMLLoader(getClass().getResource("app/src/main/java/detail_tracker/views/ProjMain.fxml"));
                Parent root = loader.load();

                // Get the controller and pass the active project to it
                ProjectMainController controller = loader.getController();
                controller.setProject(archivedProject);

                // Create a new scene and show it in a new stage
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                }
            System.out.println("Going to archived project: " + archivedProject);
        } else if (createNewProject) {
            try {
                // Load the FXML for the CreateNewProject view
                FXMLLoader loader = new FXMLLoader(getClass().getResource("app/src/main/java/detail_tracker/views/CreateNewProject.fxml"));
                Parent root = loader.load();
    
                // Get the controller
                CreateNewProjectController controller = loader.getController();
    
                // Create a new scene and show it in a new stage
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Going to create new project view");
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make a selection before proceeding.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) {
        try {
            // Load the FXML for the Login view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("app/src/main/java/detail_tracker/views/Login.fxml"));
            Parent root = loader.load();
    
            // Get the controller
            LoginController controller = loader.getController();
    
            // Create a new scene and show it in a new stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Stage currentStage = (Stage) homeBtn.getScene().getWindow();
            currentStage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}