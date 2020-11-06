package ui;
import model.*;
import java.util.Scanner;
public class Menu{
	private final static int LOG_IN = 1;
	private final static int SIGN_UP = 2;
	private final static int SHOW_USERS_INFO = 3;
	private final static int EXIT = 4;
	
	private final static int ADD_SONG_TO_POOL = 1;
	private final static int SONGS_IN_POOL = 2;
	private final static int CREATE_PLAYLIST = 3;
	private final static int ADD_SONG_TO_PLAYLIST = 4;
	private final static int SHOW_PLAYLIST_INFO = 5;
	private final static int ADD_USER_TO_RESTRICTED_PLAYLIST = 6;
	private final static int RATE_PLAYLIST = 7;
	private final static int SHOW_ALL_PLAYLIST_INFO = 8;
	private final static int EXIT_USER = 9;
	
	private static Scanner sc = new Scanner(System.in);
	private Mcs mcs;
	
	public Menu(){
		this.mcs = new Mcs();
	}
	/**
	* Show the principal menu
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void showMenu(){
		System.out.println("\n**************MENU**************");
		System.out.println("(1) Iniciar sesion");
		System.out.println("(2) Registrarse");
		System.out.println("(3) Listar informacion de usuarios");
		System.out.println("(4) Salir");
		System.out.println("**************MENU**************");
	}
	/**
	* Show the secundary menu
	* <b> pre: </b> User must be logged to interact with the menu <br>
	* <b> post: </b>
	*/
	public void showMenuUser(){
		System.out.println("\n*********** MENU USER ***********");
		System.out.println("(1) Agregar cancion al pool");
		System.out.println("(2) Listar canciones del pool");
		System.out.println("(3) Crear una playlist");
		System.out.println("(4) Agregar una cancion a una playlist");
		System.out.println("(5) Informacion de una playlist");
		System.out.println("(6) Agregar usuario a una playlist restringida");
		System.out.println("(7) Calificar una playlist publica");
		System.out.println("(8) Mostrar todas las listas de reproduccion");
		System.out.println("(9) Salir");
		System.out.println("*********** MENU USER ***********");
	}
	/**
	* Gets the choice of the menu
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return choice
	*/
	public int readOption(){
		System.out.print("Opcion: ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println();
		return choice;
	}
	/**
	* Simulate a login system
	* <b> pre: </b> <br>
	* <b> post: </b> 
	*				1. If login was successfull, show the user menu <br>
	*				2. If couldn't logged, show the main menu
	*/
	public void loginUser(){
		System.out.println("Escribe el nombre de usuario:");
		String nickName = sc.nextLine();
		System.out.println("Ingrese la contraseña:");
		String password = sc.nextLine();
		int indexUser = mcs.loginUser(nickName, password);
		if(indexUser>-1){
			int choice;
			do{
				showMenuUser();
				choice = readOption();
				doOperationUser(choice, indexUser);
			}while(choice!=EXIT_USER);
		}
	}
	/**
	* Register a new user
	* <b> pre: </b> The nickname must be unique <br>
	* <b> post: </b> 
	* @return content Show the user if their action was completed successfully or not
	*/
	public String registerUser(){
		String content = "";
		System.out.println("Ingrese el nombre de usuario:");
		String nickName = sc.nextLine();
		boolean nickNameRegister = mcs.findUser(nickName);
		if(nickNameRegister){
			content = "Ya existe un usuario con ese nombre.";
		}
		if(!nickNameRegister){
			System.out.println("Ingrese su edad: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Ingrese la contrasenia: ");
			String password = sc.nextLine();
			System.out.println("Confirme la contrasenia: ");
			String confirmPassword = sc.nextLine();
			if(password.equals(confirmPassword)){
				boolean added = mcs.createUser(nickName, password, age);
				if(added){
					content = "Se ha creado el usuario correctamente";
				}else content = "No se ha podido crear el usuario";
			}
		}
		return content;
	}
	/**
	* Do an action depending on the choice
	* <b> pre: </b> <br>
	* <b> post: </b> 
	* @param choice User choice
	*/
	public void doOperation(int choice){
		switch(choice){
			case LOG_IN:
				loginUser();
				break;
			case SIGN_UP:
				System.out.println(registerUser());
				break;
			case SHOW_USERS_INFO:
				System.out.println(mcs.showUsersInfo());
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida, ingrese otra opcion");
		}
	}
	/**
	* Receives the information of the song to create a new song
	* <b> pre: </b> The title of the song must be unique per artist <br>
	* <b> post: </b>
	* @param user User position in the users array
	* @return String Show the user if their action was completed successfully or not
	*/
	public String readSongToPool(int user){
		System.out.println("Ingrese el titulo de la cancion:");
		String title = sc.nextLine();
		System.out.println("Ingrese el nombre del artista:");
		String artist = sc.nextLine();
		System.out.println("Ingrese la fecha en que se estreno:");
		String releaseDate = sc.nextLine();
		System.out.println("Ingrese la duracion de la cancion (formato minutos:segundos):");
		String str = sc.nextLine();
		String[] time = str.split(":");
		int duration = ((Integer.parseInt(time[0])*60)+(Integer.parseInt(time[1])));
		System.out.println("(1) Rock");
		System.out.println("(2) Hip hop");
		System.out.println("(3) Clasica");
		System.out.println("(4) Reggae");
		System.out.println("(5) Salsa");
		System.out.println("(6) Metal");
		System.out.println("Ingrese la opcion que corresponde al genero de la cancion:");
		int genre = sc.nextInt();
		sc.nextLine();
		genre--;
		boolean added = mcs.addSongInPool(title, artist, releaseDate, duration, genre, user);
		if(added){
			return "La cancion se ha agregado correctamente";
		}else return "No se pudo agregar la cancion";
	}
	/**
	* Create a new playlist
	* <b> pre: </b> Playlist name must be unique <br>
	* <b> post: </b>
	* @param user User position in the users array
	* @return String Show the user if their action was completed successfully or not
	*/
	public String createPlaylist(int user){
		System.out.println("(1) Playlist privada");
		System.out.println("(2) Playlist restringida");
		System.out.println("(3) Playlist publica");
		System.out.println("Ingrese el numero que corresponde al tipo de playlist:");
		int playlistType = sc.nextInt();
		sc.nextLine();
		playlistType--;
		System.out.println("Ingrese el nombre para la playlist:");
		String name = sc.nextLine();
		boolean create = false;
		switch(playlistType){
			case 0:
				create = mcs.createPlaylistPrivated(user, name);
				break;
			case 1:
				create = mcs.createPlaylistRestricted(user, name);
				break;
			case 2:
				create = mcs.createPlaylistPublic(name);
				break;
			default:
				System.out.println("No es un tipo valido de playlist");
		}
		if(create){
			return "La playlist se creo satisfactoriamente";
		}return "La playlist no se pudo crear";
	}
	/**
	* Add song of songs pool to a specific playlist
	* <b> pre: </b> The song must be in the songs pool <br>
	* <b> post: </b>
	* @return String Show the user if their action was completed successfully or not
	*/
	public String addSongToPlaylist(){
		System.out.println("Ingrese el nombre de la playlist a la que agregara la cancion:");
		String name = sc.nextLine();
		System.out.println("Ingrese el titulo de la cancion que quiere añadir:");
		String title = sc.nextLine();
		System.out.println("Ingrese el nombre del artista de la cancion:");
		String artist = sc.nextLine();
		boolean added = mcs.addSongToPlaylist(name, title, artist);
		if(added){
			return "La cancion se agrego satisfactoriamente";
		}return "No se pudo agregar la cancion";
	}
	/**
	* Get information from a specific playlist
	* <b> pre: </b> <br>
	* <b> post: </b> Return the playlist information if it exist
	* @return content
	*/
	public String getInfoPlaylist(){
		System.out.println("Ingrese el nombre de la playlist:");
		String name = sc.nextLine();
		String content = mcs.getPlaylistInfo(name);
		return content;
	}
	/**
	* Add new allowed user to restricted playlist
	* <b> pre: </b> The playlist must be restricted <br>
	* <b> post: </b>
	* @return String Show the user if their action was completed successfully or not
	*/
	public String addUser(){
		System.out.println("Ingrese el nombre de la playlist a la que le añadira un usuario nuevo:");
		String name = sc.nextLine();
		System.out.println("Ingrese el nombre del usuario:");
		String userName = sc.nextLine();
		boolean added = mcs.addUser(name, userName);
		if(added){
			return "Se agrego correctamente el nuevo usuario a la playlist";
		}else return "No se pudo agregar el nuevo usuario a la playlist";
	}
	/**
	* Rate a public playlist
	* <b> pre: </b> A user can rate a playlist once <br>
	* <b> post: </b>
	* @return String Show the user if their action was completed successfully or not
	*/
	public String ratePlaylist(){
		System.out.println("Ingrese el nombre de la playlist a calificar:");
		String name = sc.nextLine();
		boolean finded = mcs.findPlaylist(name);
		boolean added = false;
		if(finded){
			System.out.println("Ingrese su calificacion de la playlist, debe ser entre 1 y 5:");
			double qualification = sc.nextDouble();
			sc.nextLine();
			added = mcs.ratePlaylist(name, qualification);
		}
		if(added){
			return "Se agrego correctamente la calificacion";
		}else return "No se pudo agregar la calificacion";
	}
	/**
	* Do an action depending on the choice 
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param choice User choice
	* @param user User position in the users array
	*/
	public void doOperationUser(int choice, int user){
		switch(choice){
			case ADD_SONG_TO_POOL:
				System.out.println(readSongToPool(user));
				break;
			case SONGS_IN_POOL:
				System.out.println(mcs.showSongsOfPool());
				break;
			case CREATE_PLAYLIST:
				System.out.println(createPlaylist(user));
				break;
			case ADD_SONG_TO_PLAYLIST:
				System.out.println(addSongToPlaylist());
				break;
			case SHOW_PLAYLIST_INFO:
				System.out.println(getInfoPlaylist());
				break;
			case ADD_USER_TO_RESTRICTED_PLAYLIST:
				System.out.println(addUser());
				break;
			case RATE_PLAYLIST:
				System.out.println(ratePlaylist());
				break;
			case SHOW_ALL_PLAYLIST_INFO:
				System.out.println(mcs.getAllPlaylistInfo());
				break;
			case EXIT_USER:
				System.out.println("Cerrando sesion");
				break;
			default:
				System.out.println("Opcion invalida, ingrese otra opcion");
		}
	}
	/**
	* Method to end the aplication with a choice
	* <b> pre: </b>
	* <b> post: </b>
	*/
	public void startProgram(){
		int choice;
		do{
			showMenu();
			choice = readOption();
			doOperation(choice);
		}while(choice!=EXIT);
	}
}