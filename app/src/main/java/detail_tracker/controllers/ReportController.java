package detail_tracker.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class ReportController {

    @FXML
    private VBox roomInfoVBox;

    @FXML
    private Label roomInfoLabel;

    @FXML
    private Label electricalDetailsLabel;

    @FXML
    private TableView<?> electricalDetailsTable;

    @FXML
    private TableColumn<?, ?> elecTypeCol;
    @FXML
    private TableColumn<?, ?> elecLocationCol;
    @FXML
    private TableColumn<?, ?> elecBrandCol;
    @FXML
    private TableColumn<?, ?> elecModelCol;
    @FXML
    private TableColumn<?, ?> elecNoteCol;

    @FXML
    private Label finishDetailsLabel;

    @FXML
    private TableView<?> finishDetailsTable;

    @FXML
    private TableColumn<?, ?> finMaterialCol;
    @FXML
    private TableColumn<?, ?> finLocationCol;
    @FXML
    private TableColumn<?, ?> finColorCol;
    @FXML
    private TableColumn<?, ?> finSheenCol;
    @FXML
    private TableColumn<?, ?> finBrandCol;
    @FXML
    private TableColumn<?, ?> finNoteCol;

    @FXML
    private Label flooringDetailsLabel;

    @FXML
    private TableView<?> flooringDetailsTable;

    @FXML
    private TableColumn<?, ?> flrMaterialCol;
    @FXML
    private TableColumn<?, ?> flrLocationCol;
    @FXML
    private TableColumn<?, ?> flrDimensionsCol;
    @FXML
    private TableColumn<?, ?> flrBrandCol;
    @FXML
    private TableColumn<?, ?> flrNoteCol;

    @FXML
    private Label plumbingDetailsLabel;

    @FXML
    private TableView<?> plumbingDetailsTable;

    @FXML
    private TableColumn<?, ?> plumTypeCol;
    @FXML
    private TableColumn<?, ?> plumLocationCol;
    @FXML
    private TableColumn<?, ?> plumBrandCol;
    @FXML
    private TableColumn<?, ?> plumbModelCol;
    @FXML
    private TableColumn<?, ?> plumNoteCol;

    @FXML
    private Label trimDetailsLabel;

    @FXML
    private TableView<?> trimDetailsTable;

    @FXML
    private TableColumn<?, ?> trimTypeCol;
    @FXML
    private TableColumn<?, ?> trimLocationCol;
    @FXML
    private TableColumn<?, ?> trimMaterialCol;
    @FXML
    private TableColumn<?, ?> trimDimensionsCol;
    @FXML
    private TableColumn<?, ?> trimBrandCol;
    @FXML
    private TableColumn<?, ?> trimNoteCol;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button printButton;

    @FXML
    private Button backButton;

    @FXML
    private void initialize() {
        setupTable(finishDetailsTable, finMaterialCol, finLocationCol, finColorCol, finSheenCol, finBrandCol, finNoteCol);
        // Do the same for the other tables
    }

    private void setupTable(TableView<?> finishDetailsTable2, TableColumn<?, ?> finMaterialCol2,
            TableColumn<?, ?> finLocationCol2, TableColumn<?, ?> finColorCol2, TableColumn<?, ?> finSheenCol2,
            TableColumn<?, ?> finBrandCol2, TableColumn<?, ?> finNoteCol2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setupTable'");
    }

    private <T> void setupTable(TableView<T> table, TableColumn<T, ?>... columns) {
        // Set up the table and columns here
    }

    @FXML
    private void handleBackButtonAction() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/path/to/back/scene.fxml"));
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handlePrintButtonAction() {
        // Print the report
    }   

    // Other methods
}