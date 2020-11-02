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
	
	public User(String nickName, String password, int age){
		this.nickName = nickName;
		this.password = password;
		this.age = age;
		songsAdded = 0;
		category = NEWBIE;
	}
	
	public String getNickName(){
		return nickName;
	}
	
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public int getAge(){
		return age;
	}
	
	public void increaseAge(){
		age++;
	}
	
	public void increaseSongsAdded(){
		songsAdded++;
	}
	
	public String getCategory(){
		return category;
	}
	
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
}