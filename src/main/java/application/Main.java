package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			System.out.println("Working Directory = " + System.getProperty("user.dir"));

			URL url = new File("src/main/java/view/OneGUI.fxml" ).toURI().toURL();

			loader . setLocation ( url );
			System.out.println(loader.getLocation());
			BorderPane root = new BorderPane();
			root= loader.load() ;
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
