package application;

public class Song {
	String name;
	String artist;
	String album;
	String year;
	
	//Constructor Default sets all to empty strings
	public Song () {
		this.name = "";
		this.artist = "";
		this.album = "";
		this.year = "";
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
