public class NodeLongley
{
	//myData holds the char for each Node
	//myNext references the next Node in the stack or queue
	private String myData;
	private NodeLongley myNext;

	public NodeLongley()
	{
		myData = "";
		myNext = null;
	}//NodeLongley
	
	public NodeLongley(String newData)
	{
		myData = newData;
		myNext = null;
	}//NodeLongley

	//getter for myData 
	public String getData()
	{
		return myData;
	}//getData
	
	//getter for myNext
	public NodeLongley getNext()
	{
		return myNext;
	}//getNext
	
	//setter for myData 
	public void setData(String newData)
	{
		myData = newData;
	}//setData
	
	//setter for myNext
	public void setNext(NodeLongley newNext)
	{
		myNext = newNext;
	}//setNext
}//NodeLongley

