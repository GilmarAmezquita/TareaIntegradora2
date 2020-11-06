package model;
public class User{
	private final static String NEWBIE = "Newbie";
	private final static String LITTLE_CONTRIBUTOR = "Little contributor";
	private final static String MILD_CONTRIBUTOR = "Mild contributor";
	private final static String STAR_CONTRIBUTOR = "Star contributor";
	
	private final static int NEWBIE_MAXIMUM = 3;
	private final static int LITTLE_CONTRIBUTOR_MAXIMUM = 10;
	private final static int MILD_CONTRIBUTOR_MAXIMUM = 30;
	
	private String nickName;
	private String password;
	private int age;
	private int songsAdded;
	private String category;
	/**
	* Constructor method for the users
	* <b> pre: </b> The nickname must be unique for user <br>
	* <b> post: </b> Initilizes a user with all his information
	* @param nickName Name of the user
	* @param password Password of the user
	* @param age Age of the user
	*/
	public User(String nickName, String password, int age){
		this.nickName = nickName;
		this.password = password;
		this.age = age;
		songsAdded = 0;
		category = NEWBIE;
	}
	/**
	* Get the user's nickname
	* <b> pre: </b> <br>
	* <b> post: </b> 
	* @return nickName
	*/
	public String getNickName(){
		return nickName;
	}
	/**
	* Change the user nickname
	* <b> pre: </b> The new nickname must be unique and different from the old one <br>
	* <b> post: </b>
	* @param nickName
	*/
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	/**
	* Get the user's password
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return password
	*/
	public String getPassword(){
		return password;
	}
	/**
	* Get the user¿s age
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return age
	*/
	public int getAge(){
		return age;
	}
	/**
	* Increases the user age by 1
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseAge(){
		age++;
	}
	/**
	* Increases the songs the user has added by 1
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseSongsAdded(){
		songsAdded++;
	}
	/**
	* Get the user's category
	* <b> pre: </b> <br>
	* <b> post: </b>
	*				1. Returns Newbie if the user has added less than 3 songs <br>
	*				2. Returns Little contributor if the user has added between 3 and 9 songs <br>
	*				3. Returns Mild contributor if the user has added between 10 and 29 songs <br>
	*				4. Returns Star contributor if the user has added 30 songs
	* @return category
	*/
	public String getCategory(){
		return category;
	}
	/**
	* Calculate the user's category
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void calculateCategory(){
		if(songsAdded<NEWBIE_MAXIMUM){
			category = NEWBIE;
		}else if(songsAdded<LITTLE_CONTRIBUTOR_MAXIMUM){
			category = LITTLE_CONTRIBUTOR;
		}else if(songsAdded<MILD_CONTRIBUTOR_MAXIMUM){
			category = MILD_CONTRIBUTOR;
		}else if(songsAdded>=MILD_CONTRIBUTOR_MAXIMUM){
			category = STAR_CONTRIBUTOR;
		}
	}
	/**
	* Get the user information
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return contents Contains the user information
	*/
	public String getUserInfo(){
		String contents = "****************User****************\n";
		contents += "**  UserName: "+getNickName()+"\n";
		contents += "**  Age: "+getAge()+"\n";
		contents += "**  Category: "+getCategory()+"\n";
		contents += "************************************\n";
		return contents;
	}
}