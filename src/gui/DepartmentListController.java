package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService departmentService;
	
	@FXML
	private TableView<Department> tableViewDepartments;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, Integer> tableColumnName;
	@FXML
	private Button buttonNew;
	
	private ObservableList<Department> observableList;
	
	@FXML
	public void onButtonNewAction() {
		System.out.println("onButtonNewAction");
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public void updateTableView() {
		if (departmentService == null) {
			throw new IllegalStateException("DepartmentService is null");
		}
		List<Department> list = departmentService.findAll();
		observableList = FXCollections.observableArrayList(list);
		tableViewDepartments.setItems(observableList);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		intializeNodes();
	}

	private void intializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartments.prefHeightProperty().bind(stage.heightProperty());
	}
}
