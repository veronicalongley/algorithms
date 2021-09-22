
public class Stack {
	private NodeLongley top; 
	
	public Stack()
	{
		top = null;
	}//Stack
	
	public void push (char c)
	{
		NodeLongley oldTop = top;
		top = new NodeLongley();
		top.setData(c);
		top.setNext(oldTop);

	}//push
	
	public boolean isEmpty() 
	{
		if (top == null)
			return true;
		else
			return false;
	}// isEmpty
	
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
