package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OneModel {
	
	StringProperty mot;
	
	IntegerProperty nb;
	
	public OneModel() {
		mot = new SimpleStringProperty();
		nb = new SimpleIntegerProperty();
	}
	
	public StringProperty getMot() {
		return mot;
	}
	
	public IntegerProperty getNb() {
		return nb;
	}
	
	public void setNb(int newVal) {
		this.nb.set(newVal);
	}
	
	public void setMot(String newVal) {
		this.mot.set(newVal);
	}
	
	public void randomizeMot() {
		if (mot.get() == null) {
			mot.set("random");
		}
		
		List<String> chars = mot.get().chars().mapToObj(e->((char) e +"")).collect(Collectors.toList());

		Collections.shuffle(chars);
		mot.set(String.join("", chars));
	}
	
	public void multiplyNb() {
		nb.set(nb.get()*2);
	}
	

}
