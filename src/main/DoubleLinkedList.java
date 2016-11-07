package main;
import java.io.Serializable;
public class DoubleLinkedList<T extends Comparable<T>> implements Serializable{

	private DoubleListNode<T>   head;		//Head of linked list
	private DoubleListNode<T>   current;	//Current value in linked list
	
	//Default constructor
	public DoubleLinkedList(){
		head=null;
		current=head;}
	
	/*Add T value to linked list
	 * @param T t -- T value to be added to linked list */
	public void add(T t){
		DoubleListNode<T> front=head;
		DoubleListNode<T> back=null;
		if(head == null){
			head = new DoubleListNode<T>(t,null,null);
			current=head;}
		else{
			while(front!=null && front.getValue().compareTo(t)<=0){
				back=front;
				front=front.getNext();}
			if(back==null){
				addFirst(t);}
			else if(front==null){
				addLast(t,back);}
			else{
				DoubleListNode<T> temp = new DoubleListNode<T>(t,front,back);
				back.setNext(temp);
				front.setPrevious(temp);
				current=temp;}}}
	
	/*Add T value to first position in linked list
	 * @param T t -- T value to be added to linked list */
	private void addFirst(T t){
		head.setPrevious(new DoubleListNode<T>(t,head,null));
		head=head.getPrevious();
		current=head;}
	
	/*Add T value to last position in linked list
	 * @param T t,DoubleListNode<T> last -- T value to be added after last */
	private void addLast(T t,DoubleListNode<T> last){
		DoubleListNode<T> newLast = new DoubleListNode<T>(t,null,last);
		last.setNext(newLast);
		current=newLast;}
	
	/*Remove current T value from linked list */
	public void remove(){
		if(current==head){
			if(head.getNext()==null){
				head=null;
				current=head;}
			else{
				head=head.getNext();
				head.setPrevious(null);
				current=head;}
			return;}
		DoubleListNode<T> prev = current.getPrevious();
		DoubleListNode<T> next = current.getNext();
		prev.setNext(next);
		if(next!=null)
			next.setPrevious(prev);
		current=prev;}
	
	/*Edit current T value by removing it and adding new T
	 * @param T t -- T value to replace current */
	public void edit(T t){
		remove();
		add(t);}
	
	/*goNext -- Move current to next position in linked list
	 *goPrev -- Move current to previous position in linked list */
	public void goNext(){
		current=current.getNext();}
	public void goPrev(){
		current=current.getPrevious();}
	
	/*checkNext -- Return if current is at the end of the list
	 *checkPrev -- Return if current is at the start of the list */
	public boolean checkNext(){
		return current.getNext()!=null;}
	public boolean checkPrev(){
		return current.getPrevious()!=null;}
	
	/*Return current T value
	 * @return current.getValue() -- Get current value and return it
	 * @return null -- Return null if list is empty */
	public T getCurrent(){
		if(head!=null)
			return current.getValue();
		return null;}
	
	/*Sort the linked list based on T compareTo
	 * @return null -- Return if list is empty */
	public void sortList(){
		if(head==null)
			return;
		DoubleListNode<T> unsorted = head;
		head=null;
		T t = unsorted.getValue();
		add(t);
		while(unsorted.getNext()!=null){
			unsorted = unsorted.getNext();
			t = unsorted.getValue();
			add(t);}
		current=head;}
	
	/*Check to see if list is empty
	 * @return head!=null -- Return if list is empty */
	public boolean checkList(){
		return head!=null;}
}