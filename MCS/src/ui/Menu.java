package ui;
import model.*;
public class Menu{
	private final static int USERS_MAXIMUM = 10;
	
	private final static int LOG_IN = 1;
	private final static int SIGN_UP = 2;
	private final static int EXIT = 3;
	
	private static Scanner sc = new Scanner(System.in);
	
	private User[] users;
	
	public Menu(){
		users = new User[USERS_MAXIMUM];
	}
	
	public void showMenu(){
		System.out.println("\n**************MENU**************");
		System.out.println("(1) Iniciar sesion.");
		System.out.println("(2) Registrarse");
		System.out.println("(3) Salir");
		System.out.println("**************MENU**************");
	}
	
	public int readOption(){
		System.out.print("Opcion");
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	
	public boolean findUser(String nickname){
		boolean finded = false;
		for(int i = 0; i<USERS_MAXIMUM && !finded; i++){
			if(users[i].getNicknName.equals(nickname)){
				finded = true;
			}
		}
		return finded;
	}
	
	public void logInUser(){
		System.out.println("Escribe el nombre de usuario:");
		String nickName = sc.nextLine();
		System.out.println("Ingrese la contraseña");
		String password = sc.nextLine();
		boolean logIn = false;
		for(int i = 0; i<USERS_MAXIMUM && !logIn; i++){
			if(users[i].getNickName().equals(nickName) && users[i].getPassword().equals(password)){
				System.out.println("Ingreso correctamente");
				logIn = true;
			}
		}
		if(!logIn){
			System.out.println("No se pudo iniciar sesion");
		}
	}
	
	public String registerUser(){
		System.out.println("Escribe el nombre de usuario:");
		String nickName = sc.nextLine();
		boolean nickNameRegister = findUser(nickname);
		if(!nickNameRegister){
			System.out.println("Ingrese su edad: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Ingrese la contraseña: ");
			String password = sc.nextLine();
			System.out.println("Confirme la contraseña: ");
			String confirmPassword = sc.nextLine();
			if(password.equals(confirmPassword)){
				User newUser = new User(nickName, password, age);
				return "Usuario registrado correctamente";
			}else return "Las contraseñas no coinciden";
		}else return "Ya existe un usuario con ese nombre";
	}
	
	public void doOperation(int choice){
		switch(choice){
			case LOG_IN:
				break;
			case SIGN_UP:
				System.out.println(registerUser());
				break;
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida, ingrese otra opcion");
		}
	}
	
	public void startProgram(){
		int choice;
		do{
			showMenu();
			choice = readOption();
			doOperation(choice);
		}while()
	}
}