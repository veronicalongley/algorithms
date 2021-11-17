
public class NodeLongley
{
	//myData holds the char for each Node
	//myNext references the next Node in the stack or queue
	private Vertex myData;
	private NodeLongley myNext;

	public NodeLongley()
	{
		myData = null;
		myNext = null;
	}//NodeLongley
	
	public NodeLongley(Vertex newData)
	{
		myData = newData;
		myNext = null;
	}//NodeLongley

	//getter for myData 
	public Vertex getData()
	{
		return myData;
	}//getData
	
	//getter for myNext
	public NodeLongley getNext()
	{
		return myNext;
	}//getNext
	
	//setter for myData 
	public void setData(Vertex newData)
	{
		myData = newData;
	}//setData
	
	//setter for myNext
	public void setNext(NodeLongley newNext)
	{
		myNext = newNext;
	}//setNext
}//NodeLongley