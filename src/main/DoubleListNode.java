package main;
import java.io.Serializable;
public class DoubleListNode<T> implements Serializable{ 
	
	private T value; 						//Value in list node
	private DoubleListNode<T> next;			//Next node in list
	private DoubleListNode<T> previous; 	//Previous node in list

	//Default constructor
	public DoubleListNode(){
		value=null;
		next=null;
		previous=null;}

	//Constructor with parameters
	public DoubleListNode(T initValue, DoubleListNode<T> initNext, DoubleListNode<T> initPrevious){ 
		value=initValue; 
		next=initNext; 
		previous=initPrevious;} 

	/*Access the value in node
	 * @return value -- Return value of node */
	public T getValue(){
		return value;} 

	/*Access the next node
	 * @return next -- Return the next node */
	public DoubleListNode<T> getNext(){
		return next;} 

	/*Access the previous node
	 * @return previous -- Return the previous node */
	public DoubleListNode<T> getPrevious(){
		return previous;}

	/*Update value in this node
	 * @param T newValue -- Value to replace current value */
	public void setValue(T newValue){
		value=newValue;} 

	/*Set a new list node to be next in the list
	 * @param DoubleListNode<T newNext -- New next list node */
	public void setNext(DoubleListNode<T> newNext){
		next=newNext;}

	/*Set a new list node to be previous in the list
	 * @param DoubleListNode<T newPrevious -- New previous list node */
	public void setPrevious(DoubleListNode<T> newPrevious){
		previous=newPrevious;}
}