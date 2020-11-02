package model;
public class Restricted extends PlayList{
	private final static int MAX_ALLOWED_USERS = 5;
	
	private User[] allowedUsers;
	
	public Restricted(User principalUser, String name){
		super(name);
		allowedUsers = new User[MAX_ALLOWED_USERS];
		allowedUsers[0] = principalUser;
	}
	
	public void addUser(User newUser){
		boolean added = false;
		for(int i = 0; i<MAX_ALLOWED_USERS && !added; i++){
			if(allowedUsers[i]==null){
				allowedUsers[i] = newUser;
				added = true;
			}
		}
	}
	
	@Override
	public String getInfo(){
		String contents = super.getInfo()+"\n** Allowed users:";
		for(int i = 0; i<MAX_ALLOWED_USERS; i++){
			if(allowedUsers[i]!=null){
				contents += " "+allowedUsers[i].getNickName()+",";
			}
		}
		return contents;
	}
}