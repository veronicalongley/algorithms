
public class Stack {
	
	//initialize Node for top of stack
	private NodeLongley top; 
	
	public Stack()
	{
		top = null;
	}//Stack
	
	//push method which will add char c to the top of the stack
	public void push (char c)
	{
		NodeLongley oldTop = top;
		top = new NodeLongley();
		top.setData(c);
		top.setNext(oldTop);

	}//push
	
	//checks to see if the stack is empty and returns true if it is
	// returns false if it is not
	public boolean isEmpty() 
	{
		if (top == null)
			return true;
		else
			return false;
	}// isEmpty
	
	//pop method to remove the pop char from the stack to be used for comparison
	public char pop()
	{
		char returnval = 'a';
		if (!isEmpty())
		{
			returnval = top.getData();
			top = top.getNext();
		}//if
		else
			System.out.println("Handle Underflow");
		return returnval; 
	}//pop
}//Stack