package model;
import java.util.ArrayList;
public class PlayList{
	private final static int MAX_GENRES = 6;
	
	private String name;
	private int duration;
	private int songsInPlaylist;
	
	private ArrayList<Song> songs;
	private Genre[] genres;
	
	public PlayList(String name){
		this.name = name;
		duration = 0;
		songsInPlaylist = 0;
		genres = new Genre[MAX_GENRES];
		songs = new ArrayList<Song>();
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
	
	public int getSongsQuantity(){
		return songsInPlaylist;
	}
	
	public void increaseSongsInPlaylist(){
		songsInPlaylist++;
	}
	
	public boolean findSong(String title, String artist){
		boolean finded = false;
		for(int i = 0; i<songsInPlaylist && !finded; i++){
			if(songs.get(i).getTitle().equalsIgnoreCase(title) && songs.get(i).getArtist().equalsIgnoreCase(artist)){
				finded = true;
			}
		}
		return finded;
	}
	
	public void calculateDurationPlayList(){
		int duration = 0;
		for(int i = 0; i<songsInPlaylist; i++){
			duration += songs.get(i).getDuration();
		}
		this.duration = duration;
	}

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
	
	public boolean addSong(String title, String artist, Song[] songsPool){
		boolean findedInPlaylist = findSong(title, artist);
		boolean added = false;
		if(!findedInPlaylist){
			for(int i = 0; i<songsPool.length && !added; i++){
				if(songsPool[i]!=null){
					if(songsPool[i].getTitle().equalsIgnoreCase(title) && songsPool[i].getArtist().equalsIgnoreCase(artist)){
						songs.add(songsPool[i]);
						increaseSongsInPlaylist();
						calculateDurationPlayList();
						calculateGenres(songsPool[i]);
						added = true;
					}
				}
			}
		}
		return added;
	}
	//CLASE ABSTRACTRA
	public String getInfo(){
		String contents = "**************  Playlist **************\n";
		contents += "** Title: "+getName()+"\n";
		int seconds = this.duration;
		int minutes = (seconds/60);
		seconds -= (minutes*60);
		int hours = (minutes/60);
		minutes -= (hours*60);
		contents += "** Duraion: "+hours+":"+minutes+":"+seconds+"\n";
		contents += "** Genre:";
		for(int i = 0; i<MAX_GENRES; i++){
			if(genres[i]!=null){
				contents += " "+genres[i];
			}
		}
		return contents;
	}
}