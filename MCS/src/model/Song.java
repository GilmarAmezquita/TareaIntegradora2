package model;
public class Song{
	private String title;
	private String artist;
	private String releaseDate;
	private int duration;
	
	private Genre genre;
	/**
	* Constructor method for each song
	* <b> pre: </b> 
	*			1. The name of the artist must be unique <br>
	*			2. The title of the song must be unique for artist
	* <b> post: </b> Initializes a song with all its information
	* @param title The title of the song
	* @param artist The name of the artist
	* @param releaseDate Date the song was released
	* @param duration Duration of the song in seconds
	* @param genreNum Option that define the genre of the song
	*/
	public Song(String title, String artist, String releaseDate, int duration, int genreNum){
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.duration = duration;
		enumGenre(genreNum);
	}
	/**
	* Get the title of the song
	* <b>pre: </b> <br>
	* <b>post: </b> 
	* @return title
	*/
	public String getTitle(){
		return title;
	}
	/**
	* Get the artist name
	* <b>pre: </b> <br>
	* <b>post: </b> 
	* @return artist
	*/
	public String getArtist(){
		return artist;
	}
	/**
	* Get the release date of the song
	* <b>pre: </b> <br>
	* <b>post: </b> 
	* @return releaseDate
	*/
	public String getReleaseDate(){
		return releaseDate;
	}
	/**
	* Get the duration of the song in seconds
	* <b>pre: </b> <br>
	* <b>post: </b> 
	* @return duration
	*/
	public int getDuration(){
		return duration;
	}
	/**
	* Get the genre of the song
	* <b>pre: </b> <br>
	* <b>post: </b> 
	* @return genre
	*/
	public Genre getGenre(){
		return genre;
	}
	/**
	* Calculate the genre of the song.
	* <b>pre: </b> The genreNum must be between 0 and 5 <br>
	* <b>post: </b> 
	* @param genreNum user input, each integer corresponds to a genre
	*/
	public void enumGenre(int genreNum){
	switch(genreNum){
		case 0:
			this.genre = Genre.Rock;
			break;
		case 1:
			this.genre = Genre.Hip_hop;
			break;
		case 2:
			this.genre = Genre.Clasica;
			break;
		case 3:
			this.genre = Genre.Reggae;
			break;
		case 4:
			this.genre = Genre.Salsa;
			break;
		case 5:
			this.genre = Genre.Metal;
			break;
		}
	}
	/**
	* Get the song information
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return contents Contains the song information
	*/
	public String getSongInfo(){
		contents = "*************** Song ***************\n";
		contents += "**  Title: "+getTitle()+"\n";
		contents += "**  Artist: "+getArtist()+"\n";
		int seconds = getDuration();
		int minutes = (int) (seconds/60);
		seconds -= (minutes*60);
		int hours = (int) (minutes/60);
		minutes -= (hours*60);
		contents += "**  Duration: "+hours+":"+minutes+":"+seconds+"\n";
		contents += "**  Genero: "+getGenre()+"\n";
		contents += "************************************\n";		
		return contents;
	}
}