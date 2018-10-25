package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import model.OneModel;

public class OneControler implements Initializable {
	
	@FXML
    private Button motButton;

    @FXML
    private Button nbButton;

    @FXML
    private TextField motLabel;
    
    @FXML
    private TextField nbLabel;
    
    private OneModel model;
    
    public OneControler() {
    	model = new OneModel();
	}

    @FXML
    void onMotClicked(ActionEvent event) {
    	model.randomizeMot();
    }

    @FXML
    void onNbClicked(ActionEvent event) {
    	model.multiplyNb();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		motLabel.textProperty().bindBidirectional(model.getMot());
		nbLabel.textProperty().bindBidirectional(model.getNb(), new NumberStringConverter());
//		model.getNb().bind(nbLabel.textProperty());
	}

}
