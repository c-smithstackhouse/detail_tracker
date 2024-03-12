package detail_tracker.controllers;

import java.util.List;

import detail_tracker.entities.Client;
import detail_tracker.service.ClientService;
import detail_tracker.entities.Project;
import detail_tracker.validation.NameValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class AddClientController {

    @FXML
    private TitledPane mainTitlePane;

    @FXML
    private ScrollPane mainScrollPane;

    @FXML
    private VBox mainVBox;

    @FXML
    private RadioButton existingClientRadioBtn;

    @FXML
    private ChoiceBox<Client> existingClientChoiceBox;

    @FXML
    private RadioButton newClientRadioBtn;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField middleInitialField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField address1Field;

    @FXML
    private TextField address2Field;

    @FXML
    private TextField cityField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private TextField mobilePhoneField;

    @FXML
    private TextField landLineField;

    @FXML
    private TextField emailField;

    @FXML
    private HBox addClientBtnHBox;

    @FXML
    private Button addClientButton;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    private ClientService clientService;

    private Project project;

    // Receive the Project entity from the preceding view
    public void setProject(Project project) {
        this.project = project;
    }

    // Create a ClientService object
    public void setClientService() {
        this.clientService = new ClientService();
    }

    // Initializer
    @FXML
    public void initialize() {
        existingClientRadioBtn.setSelected(false); // Set radio button to "off" by default
        newClientRadioBtn.setSelected(false); // Set radio button to "off" by default
        disableAddressFields(); // Disable the address fields by default
    }

    // Methods
    @FXML
    public void handleExistingClientRadioBtnAction() {
        // A function that imports the list of existing clients from the database and populates the choice box
        if (existingClientRadioBtn.isSelected()) {
            newClientRadioBtn.setSelected(false); // Set the new client radio button to "off"
            disableAddressFields();
            List<Client> clients = clientService.getAllClients();
            ObservableList<Client> observableClients = FXCollections.observableArrayList(clients);
            existingClientChoiceBox.setItems(observableClients); // Populate the choice box with the list of clients
            existingClientChoiceBox.setDisable(false); // Enable the choice box
        }
    }

    @FXML
    public void handleNewClientRadioBtnAction() {
        if (newClientRadioBtn.isSelected()) {
            existingClientRadioBtn.setSelected(false); // Set the existing client radio button to "off"
            existingClientChoiceBox.setDisable(true); // Disable the choice box
            //existingClientChoiceBox.setItems(null); // Clear the choice box
        }
        enableAddressFields();
    }

    @FXML
    public void handleFirstNameFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleMiddleInitialFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleLastNameFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleAddress1FieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleAddress2FieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleCityFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleZipCodeFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleMobilePhoneFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleLandLineFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleEmailFieldAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleAddClientButtonAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleBackButtonAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleNextButtonAction() {
        if (newClientRadioBtn.isSelected()) {
            // Create a new Client using the information in the text fields
            Client newClient = new Client();
            //newClient.setName(nameTextField.getText());
            //newClient.setAddress(addressTextField.getText());

            // Add the new Client to the Project
            //project.addClient(newClient);
        } else {
            // Add the selected Client from the ChoiceBox to the Project
            //Client selectedClient = clientChoiceBox.getSelectionModel().getSelectedItem();
            //project.addClient(selectedClient);
        }
    }

    private void disableAddressFields() {
        // Disable the text fields
        firstNameField.setDisable(true);
        middleInitialField.setDisable(true);
        lastNameField.setDisable(true);
        address1Field.setDisable(true);
        address2Field.setDisable(true);
        cityField.setDisable(true);
        zipCodeField.setDisable(true);
        mobilePhoneField.setDisable(true);
        landLineField.setDisable(true);
        emailField.setDisable(true);
    }

    private void enableAddressFields() {
        // Enable the text fields
        firstNameField.setDisable(false);
        middleInitialField.setDisable(false);
        lastNameField.setDisable(false);
        address1Field.setDisable(false);
        address2Field.setDisable(false);
        cityField.setDisable(false);
        zipCodeField.setDisable(false);
        mobilePhoneField.setDisable(false);
        landLineField.setDisable(false);
        emailField.setDisable(false);
    }
}