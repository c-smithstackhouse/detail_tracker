package detail_tracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import detail_tracker.entities.Floor;
import detail_tracker.entities.Project;
import detail_tracker.service.ProjectService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;




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
    private TableView<Project> tableView;

    @FXML
    private VBox dropdownVBox;

    @FXML
    private Label chooseFloorLabel;

    @FXML
    private ChoiceBox<String> chooseFloorChoiceBox;

    @FXML
    private Label chooseRoomLabel;

    @FXML
    private ChoiceBox<Integer> chooseRoomChoiceBox;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button goButton;

    @FXML
    private Button exportButton;

    @FXML
    private Button homeButton;

    private Project project;

    private Floor floor;

    private ProjectService projectService;

    public void initialize() {
        this.projectService = new ProjectService();

        for (Floor floor : project.getFloors()) {
            chooseFloorChoiceBox.getItems().add(floor.getFloorType().name());
        }
        // disable room choice box
        chooseRoomChoiceBox.setDisable(true);


    }

    public void setProject(String projectName) {
        this.project = projectService.getProjectByName(projectName);
    }

    @FXML
    public void handleGoButtonAction() {
        // TODO: Implement business logic here
    }

    @FXML
    public void handleExportButtonAction() {
        try {
            // Create a temporary PDF file
            File tempFile = File.createTempFile("Report", ".pdf");
            tempFile.deleteOnExit();
    
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(tempFile));
            document.open();
    
            PdfPTable table = new PdfPTable(tableView.getColumns().size());
            for (TableColumn<Project, ?> column : tableView.getColumns()) {
                table.addCell(column.getText());
            }
    
            for (Project project : tableView.getItems()) {
                for (TableColumn<Project, ?> column : tableView.getColumns()) {
                    table.addCell(column.getCellData(project).toString());
                }
            }
    
            document.add(table);
            document.close();
    
            // Open the print dialog
            Desktop.getDesktop().print(tempFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleHomeButtonAction() {
        // TODO: Implement business logic here
    }

}
