package main;
import javax.swing.*;
import BreezySwing.*;
public class StudentInputGUI extends GBFrame{

	DoubleLinkedList		list;		//Linked List object
	Linked3GUI				theGUI;		//Main GUI object
	private JLabel 			firstL;		//First name label
	private	JTextField		first;		//First name input
	private JLabel			lastL;		//Last name label
	private JTextField		last;		//Last name input
	private	JLabel			yogL;		//Year of grad label
	private IntegerField	yog;		//Year of grad input
	private JLabel			gpaL;		//GPA label
	private DoubleField		gpa;		//GPA input
	private JButton			input;		//Input student button
	
	public StudentInputGUI(Linked3GUI mainGUI,DoubleLinkedList linkedList,Student s){
		list=linkedList;
		theGUI=mainGUI;
		
		firstL	= addLabel			("First Name:",1,1,1,1);
		first	= addTextField		(s.getFirst(),1,2,1,1);
		lastL	= addLabel			("Last Name:",2,1,1,1);
		last	= addTextField		(s.getLast(),2,2,1,1);
		yogL	= addLabel			("Year of Grad:",3,1,1,1);
		yog		= addIntegerField	(s.getYOG(),3,2,1,1);
		gpaL	= addLabel			("GPA:",4,1,1,1);
		gpa		= addDoubleField	(s.getGPA(),4,2,1,1);
		input	= addButton			("Input",5,2,1,1);
		
		if(s.getFirst().equals("")){
			yog.setText("");
			gpa.setText("");}}
	
	/*Input student into linked list when input is clicked
	 * @param JButton buttonObj -- Button clicked */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj==input){
			try{Student.errorCheckStudent(gpa.getNumber());
			Student s = new Student(first.getText(),last.getText(),
					yog.getNumber(),gpa.getNumber(),true);
			list.add(s);
			theGUI.outCurrentStudent();
			this.setVisible(false);}
			catch(IllegalArgumentException e){messageBox(e.getMessage());}}}
}