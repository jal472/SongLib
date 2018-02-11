package application.view;

import java.util.Optional;

import application.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController {
	
	private ObservableList<Song> obsList;
	@FXML
	ListView<String> detailsListView;
	@FXML
	Button addButton;
	@FXML
	TextField nameTextField, artistTextField, albumTextField, yearTextField;

	@FXML
	TableView<Song> songTable;
	//table columns
	@FXML
	TableColumn<Song,String> songTableColumn;
	@FXML
	TableColumn<Song,String> artistTableColumn;

	public void start(Stage primaryStage) {
		obsList = FXCollections.observableArrayList();
		obsList.add(new Song("spice","girls","vol1","1999"));
//		songTable.setItems(obsList);
		songTableColumn.setCellValueFactory(new PropertyValueFactory<Song,String>("songName"));
		artistTableColumn.setCellValueFactory(new PropertyValueFactory<Song,String>("artistName"));
		songTable.setItems(obsList);
		//		// select the first item
		songTable.getSelectionModel().selectFirst();


		
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
			//TODO: add song to the list and sort
			obsList.add(newSong);
			System.out.println("button clicked");
		}
	}

	// Right click event -- possible use case for right clicking on a song to either edit or delete it
//	public void rightClick(MouseEvent event){
//		MouseButton button  = event.getButton();
//		if(button==MouseButton.SECONDARY){
//			System.out.println("right button clicked");
//		}
//	}
	public void contextMenuEvent(ContextMenuEvent event){
		//testing context menu for right clicking on a song
		//Menu item choices
		MenuItem editSong = new MenuItem("Edit");
		MenuItem deleteSong = new MenuItem("Delete");
		ContextMenu rightClickMenu = new ContextMenu();
		rightClickMenu.getItems().addAll(editSong,deleteSong);
		rightClickMenu.show(addButton,event.getScreenX(),event.getScreenY());
	}
}
