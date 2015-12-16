import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Controller {
	@FXML
	Label label = new Label();

	int labelText = 3;
	Timeline waitingForConnection;

	WaitThread waitThread = new WaitThread();

	public Controller() {
	}

	@FXML
	private void initialize() {
		showController("Waiting for connection...");
		waitThread.start();
	}

	void showController(String str) {
		label.setText(str);
	}

	void setConnected() {
		waitingForConnection = new Timeline(new KeyFrame(
				Duration.millis(500), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						if (!waitThread.checkConnection()) {
							switch (labelText) {
							case 3:
								showController("Waiting for connection.");
								labelText = 1;
								break;
							case 2:
								showController("Waiting for connection...");
								labelText = 3;
								break;
							case 1:
								showController("Waiting for connection..");
								labelText = 2;
								break;
							}
						} else {
							showController("Connected!");
						}
					}
				}));
		waitingForConnection.setCycleCount(Timeline.INDEFINITE);
		waitingForConnection.play();
	}
}
