public class User{
	private final String NEWBIE = "Newbie";
	private final String LITTE_CONTRIBUTOR = "Little contributor";
	private final String MILD_CONTRIBUTOR = "Mild contributor";
	private final String STAR_CONTRIBUTOR = "Star contributor";
	
	private final int NEWBIE_MAXIMUM = 3;
	private final int LITTE_CONTRIBUTOR_MAXIMUM = 10;
	private final int MILD_CONTRIBUTOR_MAXIMUM = 30;
	
	private String nickName;
	private String password;
	private int age;
	private String category;
	
	public User(String nickName, String password, String age){
		this.nickName = nickName;
		this.password = password
		this.age = age;
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
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public int getAge(){
		return age;
	}
	
	public int ageIncrease(){
		age++;
	}
	
	public String getCategory(){
		return category;
	}
	
	
	public void calculateCategory(){
		if 
	}
}