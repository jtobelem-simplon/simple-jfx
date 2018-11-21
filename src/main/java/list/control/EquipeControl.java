package list.control;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import list.model.Employe;
import list.model.Employe.Role;
import list.model.Equipe;

public class EquipeControl implements Initializable {

	private Equipe equipe;
	private Employe current;

	@FXML
	private TableView<Employe> employeTable;

	@FXML
	private TableColumn<Employe, String> nomColumn;

	@FXML
	private TextField nomField;

	@FXML
	private TextField roleField;

	@FXML
	private TextField ancienneteField;

	boolean ancienneteControl() {
		// TODO call control when exiting the field
		try {
			Integer.parseInt(ancienneteField.getText());
			return true;
		} catch(IllegalArgumentException e) {
			ancienneteField.setText("");
			Alert alert = new Alert(AlertType.ERROR, "l'anciennete doit etre un nb entier");
			alert.show();
			return false;
		}
	}

	boolean roleControl() {
		// TODO call control when exiting the field
		try {
			Role.valueOf(roleField.getText().toUpperCase());
			return true;
		} catch(IllegalArgumentException e) {
			roleField.setText("");
			Alert alert = new Alert(AlertType.ERROR, "les roles valides sont : \n"+Arrays.toString(Role.values()));
			alert.show();
			return false;
		}
	}

	boolean controls() {
		return roleControl() && ancienneteControl();
	}

	@FXML
	void removeAction(ActionEvent event) {
		equipe.remove(current);
		current = null;
	}

	@FXML
	void clearAction(ActionEvent event) {
		current = null;
		this.employeTable.getSelectionModel().clearSelection();

		nomField.setText("");
		roleField.setText("");
		ancienneteField.setText("");
	}

	@FXML
	void addAction(ActionEvent event) {
		if (controls()) {
			current = new Employe(
					nomField.getText(), 
					Integer.parseInt(ancienneteField.getText()), 
					Role.valueOf(roleField.getText().toUpperCase()));

			equipe.add(current);
		}
	}

	@FXML
	void updateAction(ActionEvent event) {
		if (current != null && controls()) {
			current.setName(nomField.getText());
			current.setRole(Role.valueOf(roleField.getText().toUpperCase()));
			current.setAnciennete(Integer.parseInt(ancienneteField.getText()));
			this.employeTable.setItems(equipe.getEmployeList());
		}
	}

	public EquipeControl() {
		this.equipe = new Equipe();
		Employe toto = new Employe("toto",3, Role.GROUILLOT);
		equipe.add(toto);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.nomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));


		this.employeTable.setItems(equipe.getEmployeList());

		this.employeTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, 	oldValue, newValue)-> {
					afficherEmploye(newValue);
					current = newValue;
				});
	}

	private void afficherEmploye(Employe employe) {
		if (employe != null) {
			nomField.setText(employe.getName());
			roleField.setText(employe.getRole().toString());
			ancienneteField.setText(employe.getAnciennete()+"");
		}
	}


}
