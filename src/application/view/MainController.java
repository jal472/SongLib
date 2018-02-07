package application.view;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainController {
	@FXML         
	ListView<String> listView;
	
	private ObservableList<String> obsList;
	
//	@FXML
//	Button addButton;

	public void start(Stage primaryStage) {
		obsList = FXCollections.observableArrayList();
		listView.setItems(obsList);
		
//		// select the first item
		listView.getSelectionModel().select(0);
		
		//
		listView
		.getSelectionModel()
		.selectedIndexProperty()
		.addListener(
				(obs, oldVal, newVal) -> 
				//showItem(mainStage)
				showItemInputDialog(primaryStage)
				);
	}
	
	public void showItemInputDialog(Stage mainStage) {                
		String item = listView.getSelectionModel().getSelectedItem();
		int index = listView.getSelectionModel().getSelectedIndex();

		TextInputDialog dialog = new TextInputDialog(item);
		dialog.initOwner(mainStage); dialog.setTitle("List Item");
		dialog.setHeaderText("Selected Item (Index: " + index + ")");
		dialog.setContentText("Enter name: ");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) { obsList.set(index, result.get()); }
	}
	
	//TODO: get button to add song to the list with the text fields
	//		Get the song and artist to come up in the list as columns, if not.. song - artist
	//		Get alert to come up so that we can edit the details of the songs
	//		Make sure the items get added in alphabetical order
	
//	public void addSong(ActionEvent e) {
//		Button b = (Button)e.getSource();
//		if(b == addButton) {
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Add Song");
//			alert.show();
//		}
//	}

}
