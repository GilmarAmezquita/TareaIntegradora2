package model;
public class SongPool{
	private final static int SONG_MAXIMUM = 30;
	
	public Song[] songs;
	
	public SongPool(){
		songs = new Song[SONG_MAXIMUM];
	}
	
	public boolean findSong(String title, String artist){
		boolean finded = false;
		for(int i = 0; i<SONG_MAXIMUM && !finded; i++){
			if(songs[i]!=null){
				if(songs[i].getTitle().equalsIgnoreCase(title) && songs[i].getArtist().equalsIgnoreCase(artist)){
					finded = true;
				}
			}
		}
		return finded;
	}
	
	public int getSongMaximum(){
		return SONG_MAXIMUM;
	}
	
	public boolean addSong(String title, String artist, String releaseDate, int duration, int gender){
		Song newSong = new Song(title, artist, releaseDate, duration, gender);
		boolean added = findSong(title, artist);
		if(!added){
			for(int i = 0; i<SONG_MAXIMUM && !added; i++){
				if(songs[i]!=null){
					songs[i] = newSong;
					added = true;
				}
			}
		}
		return added;
	}
	
	public int quantitySong(){
		int result = 0;
		for(int i = 0; i<SONG_MAXIMUM; i++){
			if(songs[i]!=null){
				results++;
			}
		}
		return result;
	}
	
	public String showSongs(){
		String contents;
		for(int i = 0; i<SONG_MAXIMUM; i++){
			if(songs[i]!=null){
				contents += "\n************** Song **************\n";
				contents += "**  Title: "+songs[i].getTitle()+"\n";
				contents += "**  Artist: "+songs[i].getArtist()+"\n";
				int seconds = songs[i].getDuration();
				int minutes = (int) (seconds/60);
				seconds -= (minutes*60);
				int hours = (int) (minutes/60);
				minutes -= (hours*60);
				contents += "**  Duration: "+hours+":"+minutes+":"+seconds+"\n";
				contents += "**  Genre: "+songs[i].getGenre()+"\n";
				contents += "************************************";
			}
		}
		return contents;
	}
}