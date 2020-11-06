package model;
import java.util.ArrayList;
public abstract class PlayList{
	private final static int MAX_GENRES = 6;
	
	private String name;
	private int duration;
	private int songsInPlaylist;

	private ArrayList<Song> songs;
	private Genre[] genres;
	/**
	* Constructor method for the playlist
	* <b> pre: </b> The playlist name must be unique<br>
	* <b> post: </b> Initializes a playlist without songs
	* @param name the name of the playlist
	*/
	public PlayList(String name){
		this.name = name;
		duration = 0;
		songsInPlaylist = 0;
		genres = new Genre[MAX_GENRES];
		songs = new ArrayList<Song>();
	}
	/**
	* Get the name of the playlist
	* <b>pre: </b> <br>
	* <b>post: </b> The name of each playlist is unique 
	* @return name
	*/
	public String getName(){
		return name;
	} 
	/**
	* Change the name of a playlist
	* <b>pre: </b> The new name must be unique<br>
	* <b>post: </b> 
	* @param name New name of the playlist
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* Get the duration of the playlist
	* <b>pre: </b> <br>
	* <b>post: </b> The duration of the playlist is in seconds 
	* @return duration
	*/
	public int getDuration(){
		return duration;
	}
	/**
	* Number of songs in the playlist
	* <b>pre: </b> <br>
	* <b>post: </b> The number of songs will not be greater than the songs in the pool
	* @return songsInPlaylist
	*/
	public int getSongsQuantity(){
		return songsInPlaylist;
	}
	/**
	* Increase the number of songs in the playlist
	* <b>pre: </b> <br>
	* <b>post: </b> The number of songs will not be greater than the songs in the pool
	*/
	public void increaseSongsInPlaylist(){
		songsInPlaylist++;
	}
	/**
	* Search a song in the playlist
	* <b>pre: </b> <br>
	* <b>post: </b>	
	*			1. Returns false if the song isn't in the playlist<br> 
	*			2. Returns true if the song is in the playlist
	* @param title Title of the song that to be searched
	* @param artist Artist of the song
	* @return finded
	*/
	public boolean findSong(String title, String artist){
		boolean finded = false;
		for(int i = 0; i<songsInPlaylist && !finded; i++){
			if(songs.get(i).getTitle().equalsIgnoreCase(title) && songs.get(i).getArtist().equalsIgnoreCase(artist)){
				finded = true;
			}
		}
		return finded;
	}
	/**
	* Calculate the total duration of the song
	* <b>pre: </b> <br>
	* <b>post: </b> The total duration is in seconds
	*/
	public void calculateDurationPlaylist(){
		int duration = 0;
		for(int i = 0; i<songsInPlaylist; i++){
			duration += songs.get(i).getDuration();
		}
		this.duration = duration;
	}
	/**
	* Check the genres of the playlist and add the missing ones from the songs
	* <b>pre: </b> <br>
	* <b>post: </b> The genres are not repeated
	* @param song Is a song of the playlist
	*/
	public void calculateGenres(Song song){
		boolean already = false;
		boolean added = false;
		for(int i = 0; i<MAX_GENRES && !already; i++){
			if(genres[i]!=null){
				if(genres[i] == song.getGenre()){
					already = true;
				}
			}
		}
		if(!already){
			for(int i = 0; i<MAX_GENRES && !added; i++){
				if(genres[i]==null){
					genres[i] = song.getGenre();
					added = true;
				}
			}
		}
	}
	/**
	* Add a song to the playlist
	* <b>pre: </b> <br>
	* <b>post: </b>
	*			1. Returns false if the song is already in the playlist <br> 
	*			2. Returns true if the song could be added to the playlist
	* @param title Title of the song to be added
	* @param artist Artist of the song to be added
	* @param song Is the song that should be added to the playlist
	* @return added
	*/
	public boolean addSong(String title, String artist, Song song){
		boolean findedInPlaylist = findSong(title, artist);
		boolean added = false;
		if(!findedInPlaylist){
			songs.add(song);
			increaseSongsInPlaylist();
			calculateDurationPlaylist();
			calculateGenres(song);
			added = true;
		}
		return added;
	}
	/**
	* Get the genres of the playlist
	* <b> pre: </b> <br>
	* <b> post: </b> Return the genres list of the playlist, includes the null positions
	* @return genres
	*/
	public Genre[] getGenres(){
		return genres;
	}
	/**
	* Abstract method to get the info of the playlist
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return String
	*/
	public abstract String getInfo();
}