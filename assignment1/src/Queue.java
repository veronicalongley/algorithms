
public class Queue {

	private NodeLongley head;
	private NodeLongley tail;
	
	public boolean isEmpty()
	{
		return(head == null);
	}
	
	public void enqueue (char c) 
	{
		NodeLongley oldtail = tail;
		tail = new NodeLongley();
		tail.setData(c);
		tail.setNext(null);
		if (isEmpty())
		{
			head = tail;
		}//if
		else
			oldtail.setNext(tail);
	}//enqueue
	
	public char dequeue()
	{
		char returnval = 'a';
		if(!isEmpty()) 
		{
			returnval = head.getData();
			head = head.getNext();
			if (isEmpty())
				tail = null;
		}//if
		else 
			System.out.println("Handle Underflow");
		
		return returnval;
	}//dequeue
}
