package model;
import java.util.ArrayList;
public class Public extends PlayList{
	private ArrayList<Double> qualificationsUsers;
	private int usersQuantityQualification;
	private double qualification;
	/**
	* Constructor method of the public playlists
	* <b> pre: </b> The playlist name must be unique <br>
	* <b> post: </b> Initializes a playlist without songs
	* @param name The name of the playlist
	*/
	public Public(String name){
		super(name);
		this.qualificationsUsers = new ArrayList<Double>();
		this.usersQuantityQualification = 0;
		this.qualification = 0;
	}
	/**
	* Get the qualification of the playlist
	* <b> pre: </b> <br>
	* <b> post: </b> Must be between 0 and 5
	* @return qualification
	*/
	public double getQualification(){
		return qualification;
	}
	/**
	* Add a qualification of an user to the arraylist of qualifications
	* <b> pre: </b> 
	*				1. The new qualification must be between 1 and 5 <br>
	*				2. Each user can only rate a playlist once
	* <b> post: </b>
	* @param qualification User qualification
	*/
	public void addQualification(double qualification){
		this.qualificationsUsers.add(qualification);
		this.usersQuantityQualification++;
		calculateQualification();
	}
	/**
	* Calculate the qualification (avarage of the qualifications in the arraylist)
	* <b> pre: </b> <br>
	* <b> post: </b> The avarage must be between 1 and 5
	*/
	public void calculateQualification(){
		double result = 0;
		for(int i = 0; i<usersQuantityQualification; i++){
			result += qualificationsUsers.get(i);
		}
		result /= usersQuantityQualification;
		this.qualification = result;
	}
	/**
	* Get all the information of the playlist
	* <b> pre: </b> <br>
	* <b> post: </b> Must include the qualification of the playlist
	* @return contents String with the information of the playlist
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
		contents += "\n** Qualification: "+getQualification();
		return contents;
	}
}