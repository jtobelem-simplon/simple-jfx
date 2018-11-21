package composition.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import list.control.EquipeControl;
import twoProperties.control.TwoPropertiesControl;

public class MainControl implements Initializable {

	private EquipeControl equipeControl;
	private TwoPropertiesControl twoPropControl;
	
    @FXML
    private BorderPane twoProp;
	
    @FXML
    private BorderPane list;

    
	public MainControl() {
		equipeControl = new EquipeControl();
		twoPropControl = new TwoPropertiesControl();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		equipeControl.initialize(location, resources);
		twoPropControl.initialize(location, resources);
		
	}

}
