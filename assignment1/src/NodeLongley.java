public class NodeLongley
{
	//myData holds the char for each Node
	//myNext references the next Node in the stack or queue
	private char myData;
	private NodeLongley myNext;

	public NodeLongley()
	{
		myData = ' ';
		myNext = null;
	}//NodeLongley
	
	public NodeLongley(char newData)
	{
		myData = newData;
		myNext = null;
	}//NodeLongley

	//getter for myData 
	public char getData()
	{
		return myData;
	}//getData
	
	//getter for myNext
	public NodeLongley getNext()
	{
		return myNext;
	}//getNext
	
	//setter for myData 
	public void setData(char newData)
	{
		myData = newData;
	}//setData
	
	//setter for myNext
	public void setNext(NodeLongley newNext)
	{
		myNext = newNext;
	}//setNext
}//NodeLongley