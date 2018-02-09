package application;

public class Song {
	String name;
	String artist;
	String album;
	String year;
	
	//Constructor
	public Song (String name, String artist, String album, String year) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}
	
	//Getters
	public String getName() {
		return this.name;
	}
	public String getArtist() {
		return this.artist;
	}
	public String getAlbum() {
		return this.album;
	}
	public String getYear() {
		return this.year;
	}
	
	//Setters
	public void setName (String name) {
		this.name = name;
	}
	public void setArtist (String artist) {
		this.artist = artist;
	}
	public void setAlbum (String album) {
		this.album = album;
	}
	public void setYear (String year) {
		this.year = year;
	}
}
