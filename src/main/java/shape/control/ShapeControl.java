package shape.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import shape.model.ShapeModel;

public class ShapeControl implements Initializable {

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilePane;

	@FXML
	private Label xLabel;

	@FXML
	private Label yLabel;

	private ShapeModel shape;

	private ImageView imageView;
	
	private Timeline timeline;

	@FXML
	void playAction(ActionEvent event) throws InterruptedException {
		//create a timeline for moving the circle
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);


		//You can add a specific action when each frame is started.
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub

			}
		};

		//create a keyFrame, the keyValue is reached at time 2s
		Duration duration = Duration.millis(200);

		//one can add a specific action when the keyframe is reached
		EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				shape.move();
			}
		};

		KeyFrame keyFrame = new KeyFrame(duration, onFinished );

		//add the keyframe to the timeline
		timeline.getKeyFrames().add(keyFrame);

		timeline.play();
		timer.start();
	}

	@FXML
	void stopAction(ActionEvent event) {
		timeline.stop();
	}

	private int xMax = 15;
	private int yMax = 10;
	private int size = 20;

	public ShapeControl() {
		shape = new ShapeModel(xMax, yMax);

		Image img = new Image("file:img/ant.gif", 20, 20, true, true);
		imageView = new ImageView(img);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pane.getChildren().add(imageView);

		imageView.xProperty().bind(shape.getPosition().xProperty().multiply(size));
		imageView.yProperty().bind(shape.getPosition().yProperty().multiply(size));

		xLabel.textProperty().bind(shape.getPosition().xProperty().asString());
		yLabel.textProperty().bind(shape.getPosition().yProperty().asString());

		initializeGrid();
	}

	private void initializeGrid() {
		tilePane.setPrefColumns(xMax);
		tilePane.setPrefRows(yMax);

		tilePane.setPrefTileHeight(size);
		tilePane.setPrefTileWidth(size);

		for (int i = 0; i<xMax;i++) {
			for (int j = 0; j<yMax;j++) {
				Rectangle rect = new Rectangle(size,size);

				rect.setStroke(Color.BLACK);
				rect.setFill(Color.WHITE);

				tilePane.getChildren().add(rect);
			}
		}
	}

}
