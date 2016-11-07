package main;
import java.io.*;
public class FileInputOutput {

	private static String fileName;	//File name placeholder
	
	//Default constructor
	public static void selectFile(String fileNm){
		fileName=fileNm;}
	
	/*Take in a class and store its contents into a file name fileName
	 * @param Object obj -- Object to store in file with fileName */
	public static void saveFile(Object obj){
		try{
			FileOutputStream file=new FileOutputStream(fileName);
			ObjectOutputStream output=new ObjectOutputStream(file);
			output.writeObject(obj);
			file.close();
			output.close();}
		catch(IOException e){
			System.out.println(e);}}
	
	/*Take contents of desired file into output Object
	 * @return output -- Return contents of file */
	public static Object loadFile(){
		Object output=new Object();
		try{
			FileInputStream file2=new FileInputStream(fileName);
			ObjectInputStream input=new ObjectInputStream(file2);
			output=input.readObject();
			file2.close();
			input.close();}
		catch(ClassNotFoundException e){
			System.out.println(e);}
		catch(IOException e){
			System.out.println(e);}
		return output;}
	
	/*Determine if file exists
	 * @return new File(fileName).exists() -- Pass back result */
	public static boolean exists(){
		return new File(fileName).exists();}
}