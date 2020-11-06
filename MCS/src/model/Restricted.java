package model;
public class Restricted extends PlayList{
	private final static int MAX_ALLOWED_USERS = 5;
	
	private User[] allowedUsers;
	/**
	* Constructor method of the restridted playlists
	* <b> pre: </b> The playlist name must be unique <br>
	* <b> post: </b> Initializes a playlist without songs
	* @param principalUser Is the creator of the playlist and the first who can edit the playlist
	* @param name Is the name of the playlist
	*/
	public Restricted(User principalUser, String name){
		super(name);
		allowedUsers = new User[MAX_ALLOWED_USERS];
		allowedUsers[0] = principalUser;
	}
	/**
	* Add a new member to the user that can edit the playlist
	* <b> pre: </b> <br>
	* <b> post: </b>
	*				1. Return true if the user was added <br>
	*				2. Return false if the user couldn't be added
	* @param newUser Is the usar that must be added
	* @return added
	*/
	public boolean addUser(User newUser){
		boolean already = false;
		boolean added = false;
		for(int i = 0; i<MAX_ALLOWED_USERS && !already; i++){
			if(allowedUsers[i]!=null){
				if(allowedUsers[i].getNickName().equals(newUser.getNickName())){
					already = true;
				}
			}
		}
		if(!already){
			for(int i = 0; i<MAX_ALLOWED_USERS && !added; i++){
				if(allowedUsers[i]==null){
					allowedUsers[i] = newUser;
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Get all the information of the playlist
	* <b> pre: </b> <br>
	* <b> post: </b> Must include the members who can edit the playlist
	* @return contents Stirng with the information of the playlist
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
		contents += "\n** Allowed users:";
		for(int i = 0; i<MAX_ALLOWED_USERS; i++){
			if(allowedUsers[i]!=null){
				contents += " "+allowedUsers[i].getNickName()+",";
			}
		}
		return contents;
	}
}