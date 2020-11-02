package model;
public class Privated extends PlayList{
	private User userOwner;
	
	public Privated(User user, String name){
		super(name);
		userOwner = user;
	}
	
	@Override
	public String getInfo(){
		String contents = super.getInfo()+"\n** User: "+userOwner.getNickName();
		return contents;
	}
}
