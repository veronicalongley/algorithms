
public class Queue {

	//initialize Node for head and tail of queue
	private NodeLongley head;
	private NodeLongley tail;
	
	//checks if queue is empty and returns boolean
	public boolean isEmpty()
	{
		return(head == null);
	}//isEmpty
	
	// enqueue method adds Vertex c to the end of the line 
	public void enqueue (Vertex c) 
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
	
	// dequeue method removes the Vertex at the front of the line 
	// to be used for comparison 
	public Vertex dequeue()
	{
		Vertex returnval = null;
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
}//queue
