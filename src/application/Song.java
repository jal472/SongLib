package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Song implements Comparable<Song> {
	private SimpleStringProperty name;
	private SimpleStringProperty artist;
	private SimpleStringProperty album;
	private SimpleStringProperty year;
	
	//Constructor
	public Song (String name, String artist, String album, String year) {
		this.name = new SimpleStringProperty(name);
		this.artist = new SimpleStringProperty(artist);
		this.album = new SimpleStringProperty(album);
		this.year = new SimpleStringProperty(year);
	}
	
	//Getters
	public String getName() {
		return name.get();
	}
	public String getArtist() {
		return artist.get();
	}
	public String getAlbum() {
		return album.get();
	}
	public String getYear() {
		return year.get();
	}
	
	//Setters
	public void setName (String setName) {
		name.set(setName);
	}
	public void setArtist (String setArtist) {
		artist.set(setArtist);
	}
	public void setAlbum (String setAlbum) {
		album.set(setAlbum);
	}
	public void setYear (String setYear) {
		year.set(setYear);
	}
	public StringProperty nameProperty(){
		return name;
	}
	public StringProperty artistProperty(){
		return artist;
	}
	public StringProperty albumProperty(){
		return album;
	}
	public StringProperty yearProperty(){
		return year;
	}

	public int compareTo(Song o){
		String song1Full = this.getName().toLowerCase()+this.getArtist().toLowerCase();
		String song2Full = o.getName().toLowerCase()+o.getArtist().toLowerCase();
		return song1Full.compareTo(song2Full);
	}
}
