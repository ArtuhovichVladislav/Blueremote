import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RemoteBluetoothServer extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("BlueRemote");

		initRootLayout();

		showServer();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RemoteBluetoothServer.class
					.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showServer() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RemoteBluetoothServer.class
					.getResource("Server.fxml"));
			AnchorPane serverOverview = (AnchorPane) loader.load();

			rootLayout.setCenter(serverOverview);

			Controller controller = loader.getController();
			controller.setConnected();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
