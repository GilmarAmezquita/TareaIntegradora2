package model;
public class Mcs{
	private final static int USERS_MAXIMUM = 10;
	private final static int SONGS_IN_POOL_MAXIMUM = 30;
	private final static int PLAYLISTS_MAXIMUM = 20;
	
	private User[] users;
	private int playlistQuantity;
	private PlayList[] playlists;
	private Song[] songsInPool;
	/**
	* Constructor method that will contain the dates of the aplication
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public Mcs(){
		users = new User[USERS_MAXIMUM];
		playlistQuantity = 0;
		playlists = new PlayList[PLAYLISTS_MAXIMUM];
		songsInPool = new Song[SONGS_IN_POOL_MAXIMUM];
	}
	/**
	* Get the quantity of playlist
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return playlistQuantity
	*/
	public int getPlaylistQuantity(){
		return playlistQuantity;
	}
	/**
	* Increase the quantity of playlist by 1
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increasePlaylistQuantity(){
		playlistQuantity++;
	}
	/**
	* Look for a user in the users array with the nickName
	* <b> pre: </b> Each nickname must be unique <br>
	* <b> post: </b>
	*				1. Returns true if the user is in the array <br>
	*				2. Returns false if the user is'nt in the array
	* @param nickName Name of the user to be looked for
	* @return finded
	*/
	public boolean findUser(String nickName){
		boolean finded = false;
		for(int i = 0; i<USERS_MAXIMUM && !finded; i++){
			if(users[i]!=null){
				if(users[i].getNickName().equals(nickName)){
					finded = true;
				}
			}
		}
		return finded;
	}
	/**
	* Create a new user
	* <b> pre: </b> The nickname cannot be the same as another user nickname <br>
	* <b> post: </b>
	*				1. Returns true if the user could be added <br>
	*				2. Returns false if the user couldn't be added 
	* @param nickName New user name
	* @param password New user password
	* @param age New user age
	* @return added
	*/
	public boolean createUser(String nickName, String password, int age){
		boolean finded = findUser(nickName);
		boolean added = false;
		if(!finded){
			User newUser = new User(nickName, password, age);
			for(int i = 0; i<USERS_MAXIMUM && !added; i++){
				if(users[i]==null){
					users[i] = newUser;
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Method that simulates the login of a user
	* <b> pre: </b> The user must exist <br>
	* <b> post: </b>
	*				1. Returns i-1 if the login information is correct
	*					1.2 Allows to interact with the users menu <br>
	*				2. Returns -1 if the login information is invalid
	* @param nickName Nickname of the user
	* @param password Password of the user
	* @return int Contains the position of the user in the users array or an invalid position
	*/
	public int loginUser(String nickName, String password){
		boolean login = false;
		int i = 0;
		for(i = 0; i<USERS_MAXIMUM && !login; i++){
			if(users[i]!=null){
				if(users[i].getNickName().equals(nickName) && users[i].getPassword().equals(password)){
					login = true;
				}
			}
		}
		if(login){
			return i-1;
		}else return -1;
	}
	/**
	* Get the information of all the users
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return contents
	*/
	public String showUsersInfo(){
		String contents = "";
		for(int i = 0; i<USERS_MAXIMUM; i++){
			if(users[i] != null){
				contents += "****************User****************\n";
				contents += "**  UserName: "+users[i].getNickName()+"\n";
				contents += "**  Age: "+users[i].getAge()+"\n";
				contents += "**  Category: "+users[i].getCategory()+"\n";
				contents += "************************************\n";
			}
		}
		return contents;
	}
	/**
	* Look for a song in the songs pool (songs array)
	* <b> pre: </b> <br>
	* <b> post: </b>
	*				1. Returns true if the song is in the songs ppol (songs array) <br>
	*				2. Returns false if the song isn't in the songs pool (songs array)
	* @param title Song title
	* @param artist Song artist name
	* @return finded
	*/
	public boolean findSongInPool(String title, String artist){
		boolean finded = false;
		for(int i = 0; i<SONGS_IN_POOL_MAXIMUM && !finded; i++){
			if(songsInPool[i]!=null){
				if(songsInPool[i].getTitle().equalsIgnoreCase(title) && songsInPool[i].getArtist().equalsIgnoreCase(artist)){
					finded = true;
				}
			}
		}
		return finded;
	}
	/**
	* Get a song of the songs pool
	* <b> pre: </b> <br>
	* <b> post: </b> 
	*				1. Returns the song if the parameters correspond to a song from the songs pool <br>
	*				2. Returns null if the parameters don't correspond to a song from the songs pool
	* @param title Song title
	* @param artist Song artist name
	* @return theSong
	*/
	public Song getSongOfPool(String title, String artist){
		Song theSong = null;
		boolean finded = false;
		boolean already = findSongInPool(title, artist);
		if(already){
			for(int i = 0; i<SONGS_IN_POOL_MAXIMUM && !finded; i++){
				if(songsInPool[i].getTitle().equalsIgnoreCase(title) && songsInPool[i].getArtist().equalsIgnoreCase(artist)){
					theSong = songsInPool[i];
					finded = true;
				}
			}
		}
		return theSong;
	}
	/**
	* Add song to the songs pool (songs array)
	* <b> pre: </b>
	*				1. The name of artist must be unique <br>
	*				2. The title of the song must be unique per artirst
	* <b> post: </b>
	*				1. Returns true if the song was added successfully <br>
	*				2. Returns false if the song couldn't be added
	* @param title Song title
	* @param artist Song artist name
	* @param releaseDate Song release date
	* @param duration Song duration in seconds
	* @param genre Song genre that define the genre, only 1 per song
	* @param user User position in the users array that add the song
	* @return added
	*/
	public boolean addSongInPool(String title, String artist, String releaseDate, int duration, int genre, int user){
		boolean finded = findSongInPool(title, artist);
		boolean added = false;
		if(!finded){
			Song newSong = new Song(title, artist, releaseDate, duration, genre);
			for(int i = 0; i<SONGS_IN_POOL_MAXIMUM && !added; i++){
				if(songsInPool[i]==null){
					songsInPool[i] = newSong;
					users[user].increaseSongsAdded();
					users[user].calculateCategory();
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Get all the info of the songs in songs pool
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return contents Contains the info of all the songs
	*/
	public String showSongsOfPool(){
		String contents = "";
		for(int i = 0; i<SONGS_IN_POOL_MAXIMUM; i++){
			if(songsInPool[i]!=null){
				contents += "*************** Song ***************\n";
				contents += "**  Title: "+songsInPool[i].getTitle()+"\n";
				contents += "**  Artist: "+songsInPool[i].getArtist()+"\n";
				int seconds = songsInPool[i].getDuration();
				int minutes = (int) (seconds/60);
				seconds -= (minutes*60);
				int hours = (int) (minutes/60);
				minutes -= (hours*60);
				contents += "**  Duration: "+hours+":"+minutes+":"+seconds+"\n";
				contents += "**  Genero: "+songsInPool[i].getGenre()+"\n";
				contents += "************************************\n";
			}
		}
		return contents;
	}
	/**
	* Look for a playlist in the playlists array
	* <b> pre: </b> <br>
	* <b> post: </b>
	*				1. Returns true if the playlist is in the playlists array <br>
	*				2. Returns false if the playlist isn't in the playlists array
	* @param name Playlist name
	* @return finded
	*/
	public boolean findPlaylist(String name){
		boolean finded = false;
		for(int i = 0; i<PLAYLISTS_MAXIMUM && !finded; i++){
			if(playlists[i]!=null){
				if(playlists[i].getName().equals(name)){
					finded = true;
				}
			}
		}
		return finded;
	}
	/**
	* Create a new privated playlist 
	* <b> pre: </b> User must be logged <br>
	* <b> post: </b>
	*				1. Returns true if the playlist was created successfully <br>
	*				2. Returns false if the playlist couldn't be created
	* @param user User position in ther users array
	* @param name Playlist name
	* @return added
	*/
	public boolean createPlaylistPrivated(int user, String name){
		boolean finded = findPlaylist(name);
		boolean added = false;
		if(!finded){
			PlayList newPlaylist = new Privated(users[user], name);
			for(int i = 0; i<PLAYLISTS_MAXIMUM && !added; i++){
				if(playlists[i]==null){
					playlists[i] = newPlaylist;
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Create a new restricted playlist 
	* <b> pre: </b> User must be logged <br>
	* <b> post: </b>
	*				1. Returns true if the playlist was created successfully <br>
	*				2. Returns false if the playlist couldn't be created
	* @param user User position in the users array
	* @param name Playlist name
	* @return added
	*/
	public boolean createPlaylistRestricted(int user, String name){
		boolean finded = findPlaylist(name);
		boolean added = false;
		if(!finded){
			PlayList newPlaylist = new Restricted(users[user], name);
			for(int i = 0; i<PLAYLISTS_MAXIMUM && !added; i++){
				if(playlists[i]==null){
					playlists[i] = newPlaylist;
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Create a new public playlist
	* <b> pre: </b> <br>
	* <b> post: </b>
	*				1. Returns true if the playlist was created successfully <br>
	*				2. Returns false if the playlist couldn't be created 
	* @param name Playlist name
	* @return added
	*/
	public boolean createPlaylistPublic(String name){
		boolean finded = findPlaylist(name);
		boolean added = false;
		if(!finded){
			PlayList newPlaylist = new Public(name);
			for(int i = 0; i<PLAYLISTS_MAXIMUM && !added; i++){
				if(playlists[i]==null){
					playlists[i] = newPlaylist;
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Add a song to a specific playlist
	* <b> pre: </b> The song must be in the songs pool <br>
	* <b> post: </b>
	* @param name Playlist name
	* @param title Song title
	* @param artist Song artist name
	* @return added
	*/
	public boolean addSongToPlaylist(String name, String title, String artist){
		Song theSong = getSongOfPool(title, artist);
		boolean added = false;
		if(theSong!=null){
			for(int i = 0; i<PLAYLISTS_MAXIMUM && !added; i++){
				if(playlists[i]!=null){
					if(playlists[i].getName().equals(name)){
						added = playlists[i].addSong(title, artist, theSong);
					}
				}
			}
		}
		return added;
	}
	/**
	* Get playlist info for a specific playlist
	* <b> pre: </b> The playlist must exist in playlists array <br>
	* <b> post: </b> 
	* @param name Playlist name
	* @return contents Contains all the playlist info
	*/
	public String getPlaylistInfo(String name){
		boolean finded = findPlaylist(name);
		boolean showed = false;
		String contents = "";
		if(finded){
			for(int i = 0; i<PLAYLISTS_MAXIMUM && !showed; i++){
				if(playlists[i].getName().equals(name)){
					contents += playlists[i].getInfo();
					showed = true;
				}
			}
		}
		return contents;
	}
	/**
	* Get the playlist info for all playlists
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return contents Contains all the playlists info
	*/
	public String getAllPlaylistInfo(){
		String contents = "";
		for(int i = 0; i<PLAYLISTS_MAXIMUM; i++){
			if(playlists[i]!=null){
				contents += playlists[i].getInfo();
			}
		}
		return contents;
	}
	/**
	* Add a user to the list of allowed users in a restricted playlist
	* <b> pre: </b> 
	*				1. The playlist must be restricted <br>
	*				2. The user must exist
	* <b> post: </b>
	*				1. Returns true if the user was added to the allowed users successfully <br>
	*				2. Returns false if the user couldn't be added to the allowed users
	* @param name Playlist name
	* @param userName User name
	* @return added
	*/
	public boolean addUser(String name, String userName){
		boolean findPlaylist = findPlaylist(name);
		boolean findUser = findUser(userName);
		boolean findedPlaylist = false;
		boolean findedUser = false;
		boolean added = false;
		if(findPlaylist && findUser){
			User user = null;
			for(int i = 0; i<USERS_MAXIMUM && !findedUser; i++){
				if(users[i].getNickName().equals(userName)){
					user = users[i];
					findedUser = true;
				}
			}
			for(int i = 0; i<PLAYLISTS_MAXIMUM && !added; i++){
				if(playlists[i]!=null){
					if(playlists[i].getName().equals(name)){
						if(playlists[i] instanceof Restricted){
							Restricted playlist = (Restricted) playlists[i];
							added = playlist.addUser(user);
							PlayList newPlaylist = playlist;
							playlists[i] = newPlaylist;
						}
					}
				}
			}
		}
		return added;
	}
	/**
	* Rate a public playlist
	* <b> pre: </b> 
	*				1. The playlist must be public <br>
	*				2. Each user only can rate a playlist once
	* <b> post: </b>
	*				1. Returns true if the qualification was added successfully <br>
	*				2. Returns false if the qualification couldn't be added
	* @param name Playlist name
	* @param qualification User qualification for the playlist
	* @return qualified
	*/
	public boolean ratePlaylist(String name, double qualification){
		boolean findPlaylist = findPlaylist(name);
		boolean qualified = false;
		if(findPlaylist){
			for(int i = 0; i<PLAYLISTS_MAXIMUM && !qualified; i++){
				if(playlists[i]!=null){
					if(playlists[i].getName().equals(name)){
						if(playlists[i] instanceof Public){
							if(qualification>=1 && qualification<=5){
								Public playlist = (Public) playlists[i];
								playlist.addQualification(qualification);
								PlayList newPlaylist = playlist;
								playlists[i] = newPlaylist;
								qualified = true;
							}
						}
					}
				}
			}
		}
		return qualified;
	}
}