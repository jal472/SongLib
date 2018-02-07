package application;

import java.io.IOException;

import application.view.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {	

	public Stage primaryStage;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Song Library App");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		AnchorPane mainLayout = (AnchorPane)loader.load();
		
		MainController listController = loader.getController();
		listController.start(primaryStage);
		
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
