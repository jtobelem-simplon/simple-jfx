package twoProperties.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import twoProperties.model.TwoPropertiesModel;

public class TwoPropertiesControl implements Initializable {
	
	@FXML
    private Button motButton;

    @FXML
    private Button nbButton;

    @FXML
    private TextField motLabel;
    
    @FXML
    private TextField nbLabel;
    
    private TwoPropertiesModel model;
    
    public TwoPropertiesControl() {
    	model = new TwoPropertiesModel();
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
