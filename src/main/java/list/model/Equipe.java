package list.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Equipe {

	ObservableList<Employe> employeList; // a list that rise events when change

	public Equipe() {
		employeList = FXCollections.observableArrayList();
	}
	
	public boolean remove(Employe employe) {
		return employeList.remove(employe);
	}
	
	public boolean add(Employe employe) {
		return employeList.add(employe);
	}
	
	public ObservableList<Employe> getEmployeList() {
		return employeList;
	}

}
