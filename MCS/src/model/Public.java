package model;
import java.util.ArrayList;
public class Public extends PlayList{
	private ArrayList<Double> qualificationUsers;
	private int usersQuantityQualification;
	private double qualification;
	
	public Public(String name){
		super(name);
	}
	
	public double getQualification(){
		return qualification;
	}
	
	public void addQualification(double qualification){
		this.qualificationUsers.add(qualification);
	}
	
	public void calculateQualification(){
		double result = 0;
		for(int i = 0; i<usersQuantityQualification; i++){
			result += qualificationUsers.get(i);
		}
		result /= usersQuantityQualification;
		this.qualification = result;
	}
	
	@Override
	public String getInfo(){
		String contents = super.getInfo()+"\n** Qualification: "+qualification;
		return contents;
	}
}