/*Andrew Hartnett
 * November 4, 2016
 * Linked List 3 Program
 * Program allows the user to input a list of students and cycle
 * through the list, displaying the current student's info. User
 * can add, remove, or edit students. Info saves on quitting. */

package main;
import BreezySwing.*;
import javax.swing.*;
public class Linked3GUI extends GBFrame{

	private JTextArea			out;		//Output text field
	private JButton				next;		//Go to next student
	private JButton				previous;	//Go to previous student
	private JButton				add;		//Add a student
	private JButton				remove;		//Remove current student
	private JButton				edit;		//Edit current student
	private JButton				sort;		//Sort alphabetically or numerically
	private JButton				exit;		//End program and save button
	private StudentInputGUI		inGUI;		//GUI to input student info
	private DoubleLinkedList 	link;		//Linked List object
	
	public Linked3GUI(){
		out			= addTextArea	("",1,1,3,4);
		previous	= addButton		("Previous",5,1,1,1);	
		next		= addButton		("Next",5,3,1,1);
		add			= addButton		("Add",1,4,1,1);
		remove		= addButton		("Remove",2,4,1,1);
		edit		= addButton		("Edit",3,4,1,1);
		sort		= addButton		("Sort List",4,4,1,1);
		exit		= addButton		("Save & Exit",5,4,1,1);
		
		enableOutputs(false);
		out.setEditable(false);
		
		//Load in file, create if non-existent
		FileInputOutput.selectFile("studentList.dat");
		if(FileInputOutput.exists()==false){
			FileInputOutput.saveFile(null);
			link = new DoubleLinkedList<>();
			dialogSort();
			remove.setEnabled(false);
			edit.setEnabled(false);
			next.setEnabled(false);
			previous.setEnabled(false);}
		else{
			if(FileInputOutput.loadFile()==null){
				link = new DoubleLinkedList<>();
				dialogSort();
				next.setEnabled(false);
				previous.setEnabled(false);}
			else{
				link=(DoubleLinkedList)FileInputOutput.loadFile();
				next.setEnabled(false);
				previous.setEnabled(false);
				if(link.checkList()==true){
					enableOutputs(true);
					dialogSort();
					link.sortList();
					outCurrentStudent();
					checkEnds();}}}}
	
	/*Determine action based on which button is clicked
	 * Previous -- Show previous student info
	 * Next -- Show next student info
	 * Add -- Input a new student and add to list
	 * Remove -- Delete current student from list
	 * Edit -- Change details about current student
	 * Sort -- Determine how to sort list and resort
	 * Exit -- Save list and end program
	 *@param JButton buttonObj -- Which button was clicked */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj==previous){
			link.goPrev();
			outCurrentStudent();}
		else if(buttonObj==next){
			link.goNext();
			outCurrentStudent();}
		else if(buttonObj==add){
			try{inputStudent(new Student());
			enableOutputs(true);}
			catch(IllegalArgumentException e)
			{out.setText(e.getMessage());
			inGUI.setVisible(false);}}
		else if(buttonObj==remove){
			link.remove();
			outCurrentStudent();
			if(link.checkList()==false)
				enableOutputs(false);}
		else if(buttonObj==edit){
			inputStudent((Student)link.getCurrent());
			link.remove();
			outCurrentStudent();}
		else if(buttonObj==sort){
			dialogSort();
			outCurrentStudent();}
		else if(buttonObj==exit){
			FileInputOutput.saveFile(link);
			System.exit(0);}}
	
	public static void main(String [] myMainManJosh){
		Linked3GUI theGUI = new Linked3GUI();
		theGUI.setSize (400,400);
		theGUI.setLookAndFeel("METAL");
		theGUI.setVisible(true);
		theGUI.setTitle("Linked List 3 Program");}
	
	/*Prompt user if they would like to sort alphabetically or numerically */
	private void dialogSort(){
		Object[] options = {"Alphabetical","Numerical"};
		int n = JOptionPane.showOptionDialog(null,
				"How would you like to sort Students?",
				"Sort Option Window", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(n==0)Student.sort=true;
		else	Student.sort=false;
		link.sortList();}
	
	/*Create new GUI to take in student input
	 * @param Student s -- If student exists, display information to edit */
	private void inputStudent(Student s){
		inGUI = new StudentInputGUI(this,link,s);
		inGUI.setSize (500,300);
		inGUI.setLookAndFeel("METAL");
		inGUI.setVisible(true);
		inGUI.setTitle("Student Input");}
	
	/*Display current student info in list
	 * @return -- Return in list is empty */
	public void outCurrentStudent(){
		if(link.checkList()==false){
			out.setText("List is empty.");
			return;}
		out.setText(link.getCurrent().toString());
		checkEnds();}
	
	/*Enable or disable Next/Previous buttons */
	private void checkEnds(){
		next.setEnabled(link.checkNext());
		previous.setEnabled(link.checkPrev());}
	
	/*Enable or disable all output buttons
	 * @param boolean x -- State to set all output buttons to */
	private void enableOutputs(boolean x){
		remove.setEnabled(x);
		edit.setEnabled(x);
		sort.setEnabled(x);}
}