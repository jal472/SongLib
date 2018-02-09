package application.view;

import java.util.Optional;

import application.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainController {
	@FXML         
	ListView<Song> listView;
	
	private ObservableList<Song> obsList;
	
	@FXML
	Button addButton;
	@FXML
	TextField nameTextField, artistTextField, albumTextField, yearTextField;

	public void start(Stage primaryStage) {
		obsList = FXCollections.observableArrayList();
		listView.setItems(obsList);
		
//		// select the first item
		listView.getSelectionModel().select(0);
		
//		//
//		listView
//		.getSelectionModel()
//		.selectedIndexProperty()
//		.addListener(
//				(obs, oldVal, newVal) -> 
//				//showItem(mainStage)
//				showItemInputDialog(primaryStage)
//				);
	}
	
	//fix this for Songs
//	public void showItemInputDialog(Stage mainStage) {                
//		String item = listView.getSelectionModel().getSelectedItem();
//		int index = listView.getSelectionModel().getSelectedIndex();
//
//		TextInputDialog dialog = new TextInputDialog(item);
//		dialog.initOwner(mainStage); dialog.setTitle("List Item");
//		dialog.setHeaderText("Selected Item (Index: " + index + ")");
//		dialog.setContentText("Enter name: ");
//
//		Optional<String> result = dialog.showAndWait();
//		if (result.isPresent()) { obsList.set(index, result.get()); }
//	}
	
	//TODO: get button to add song to the list with the text fields
	//		Get the song and artist to come up in the list as columns, if not.. song - artist
	//		Get alert to come up so that we can edit the details of the songs
	//		Make sure the items get added in alphabetical order
	public void addSong(ActionEvent e) {
		//make sure the user inputs at least the name and artist
		if(nameTextField.getText().trim().isEmpty() || artistTextField.getText().trim().isEmpty()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Input");
			alert.setHeaderText(null);
			alert.setContentText("The user must enter the song name and artist name at the least to add a song to the list.");
			alert.showAndWait();
		}else{
			Song newSong = new Song(nameTextField.getText(),artistTextField.getText(),albumTextField.getText(),yearTextField.getText());
			System.out.println("button clicked");
		}
	}
	
}
