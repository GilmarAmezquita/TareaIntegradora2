package model;
public class Privated extends PlayList{
	private User userOwner;
	/**
	* Constructor method of the private playlists
	* <b> pre: </b> The playlist name must be unique <br>
	* <b> post: </b> Initializes a playlist without songs
	* @param user Is the user who can edit the playlist
	* @param name Is the name of the playlist
	*/
	public Privated(User user, String name){
		super(name);
		userOwner = user;
	}
	/**
	* Get all the information of the playlist
	* <b> pre: </b> <br>
	* <b> post: </b> Must include the name of the user that can edit the playlist
	* @return contents String with the information of the playlist
	*/
	@Override
	public String getInfo(){
		String contents = "\n**************  Playlist **************\n";
		contents += "** Title: "+getName()+"\n";
		int seconds = getDuration();
		int minutes = (seconds/60);
		seconds -= (minutes*60);
		int hours = (minutes/60);
		minutes -= (hours*60);
		contents += "** Duraion: "+hours+":"+minutes+":"+seconds+"\n";
		Genre[] genresProv = getGenres(); 
		contents += "** Genre:";
		for(int i = 0; i<genresProv.length; i++){
			if(genresProv[i]!=null){
				contents += " "+genresProv[i]+",";
			}
		}
		contents += "\n** User: "+userOwner.getNickName();
		return contents;
	}
}
