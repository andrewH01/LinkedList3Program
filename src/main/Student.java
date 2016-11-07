package main;
import java.io.Serializable;
import BreezySwing.Format;
public class Student implements Comparable, Serializable{

	private String first;	//First name
	private String last;	//Last name
	private int year;		//Year of graduation
	private double gpa;		//Grade point average (GPA)
	public static boolean sort=true;
	
	//Default constructor
	public Student(){
		first="";
		last="";
		year=0;
		gpa=0;}
	
	//Constructor with parameters
	public Student(String f,String l,int y,double g,boolean s){
		first=f;
		last=l;
		year=y;
		gpa=g;
		sort=s;}
	
	/*Return formatted Student information
	 * @return output -- String of Student information */
	public String toString(){
		String output="NAME: "+last+", "+first+
				"\nYOG: "+year+"\nGPA: "+gpa;
		return output;}
	
	//Accessor Methods
	public String getFirst(){
		return first;}
	public String getLast(){
		return last;}
	public int getYOG(){
		return year;}
	public double getGPA(){
		return gpa;}

	/*Compare Student last and first names alphabetically
	 * @param Object o -- Student to be compared
	 * @return last.compareTo(((Student)o).getLast()) -- Compare last names
	 * @return first.compareTo(((Student)o).getFirst()) -- Compare first names */
	public int compareTo(Object o){		
		if(o instanceof Student){
			if(sort==true){
				if(last.compareTo(((Student)o).getLast())!=0){
					return last.compareTo(((Student)o).getLast());}
				else{
					return first.compareTo(((Student)o).getFirst());}}
			else{
				double g=(gpa-((Student)o).getGPA());
				if(g<0)
					return -1;
				else if(g==0)
					return 0;
				return 1;}}
		else{
			throw new IllegalArgumentException("Error. Invalid type to compare.");}}
	
	/*Error check GPA to see if it is between 0.0 and 5.0
	 * @param double gpa -- Student GPA */
	public static void errorCheckStudent(double gpa){
		if(gpa>5||gpa<0)
			throw new IllegalArgumentException("Error. GPA must be between 0.0 and 5.0.");}
}