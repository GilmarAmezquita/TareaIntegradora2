package model;
public class Mcs{
	private final static int USERS_MAXIMUM = 10;
	private final static int SONGS_IN_POOL_MAXIMUM = 30;
	private final static int PLAYLISTS_MAXIMUM = 20;
	
	private User[] users;
	private int playlistQuantity;
	private PlayList[] playlists;
	private Song[] songsInPool;

	public Mcs(){
		users = new User[USERS_MAXIMUM];
		playlistQuantity = 0;
		playlists = new PlayList[PLAYLISTS_MAXIMUM];
		songsInPool = new Song[SONGS_IN_POOL_MAXIMUM];
	}
	public int getPlaylistQuantity(){
		return playlistQuantity;
	}
	public void increasePlaylistQuantity(){
		playlistQuantity++;
	}
	//METODOS USUARIOS
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
	//METODOS POOL
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
	//METODOS PLAYLIST
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
	public boolean addSongToPlaylist(String name, String title, String artist){
		boolean findedInPool = findSongInPool(title, artist);
		boolean added = false;
		if(findedInPool){
			for(int i = 0; i<PLAYLISTS_MAXIMUM; i++){
				if(playlists[i]!=null){
					if(playlists[i].getName().equals(name))
						added = playlists[i].addSong(title, artist, songsInPool);
				}
			}
		}
		return added;
	}
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
}