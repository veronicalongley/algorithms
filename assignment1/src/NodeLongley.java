

public class NodeLongley
{
	private char myData;
	private NodeLongley myNext;
	

	public NodeLongley()
	{
		myData = 'a';
		myNext = null;
	}//NodeLongley
	
	public NodeLongley(char newData)
	{
		myData = newData;
		myNext = null;
	}//NodeLongley

	public char getData()
	{
		return myData;
	}//getData
	
	public NodeLongley getNext()
	{
		return myNext;
	}//getNext
	
	public void setData(char newData)
	{
		myData = newData;
	}//setData
	
	public void setNext(NodeLongley newNext)
	{
		myNext = newNext;
	}//setNext
}//NodeLongley
