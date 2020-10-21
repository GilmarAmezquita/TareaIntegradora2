package model;
import java.util.ArrayList;
public class PlayList{
	private final static int MAX_PLAYLISTS = 20;
	private final static int MAX_GENRES = 6;
	
	private String name;
	private int duration;
	
	private ArrayList<Song> songs;
	private Genre[] genres;
	
	public PlayList(String name){
		this.name = name;
		duration = 0;
		songs = new Song[MAX_PLAYLISTS];
		genres = new Genre[MAX_GENRES];
	}
	
	public String getName(){
		return name;
	} 
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public boolean findSongInPool(String title, String artist, SongPool songPool){
		boolean finded = songPool.findSong(title, artist);
		return finded;
	}
	
	public boolean findSongInPlayList(String title, String artist){
		boolean findedInPlayList = false;
		for(int i = 0; i<songs.size && !findedInPlayList; i++){
			if(songs[i].getTitle().equalsIgnoreCase(title) && songs[i].getArtist().equalsIgnoreCase(artist)){
				findedInPlayList = true;
			}
		}
		return finded;
	}
	
	public void calculateDurationPlayList(){
		int duration = 0;
		for(int i = 0; i<songs.size; i++){
			duration += songs.get(i).getDuration;
		}
		this.duration = duration;
	}
	/*
	public Genre[] calculateGenresPlayList(){
		for(int i = 0; i<songs.size; i++){
			for(int j = 0; i<songs.size; j++)
			if(songs.get(i).getGenre )
		}
	}
	*/
	public boolean addSong(String title, String artist, SongPool songPool){
		boolean findedPlayList = findSongInPlayList(title, artist);
		boolean findedSongPool = findSongInPool(title, artist, songPool);
		boolean added = false;
		if(!findedSongInPlayList && findedSongPool){
			boolean index = false; 
			for(int i = 0; i<songPool.getSongMaximum() && !index; i++){
				if(songPool.songs[i].getTitle().equalsIgnoreCase() && songPool.songs[i].getArtist().equalsIgnoreCase(artist)){
					index = true;
				}
			}
			for(int j = 0; j<MAX_PLAYLISTS && !added; j++){
				if(songs[j]==null){
					songs[j] = songPool.songs[i-1];
					added = true;
					calculateDurationPlayList();
				}
			}
		}
		return added;
	}
}