import java.util.LinkedList;

public class Node {
	private int id;
	private boolean processed; 
	
	LinkedList<Node> neighbors = new LinkedList<Node>();

	public Node()
	{
		id = 0;
		processed = false;
		neighbors = null;
	}//NodeLongley
	
	public Node(int newid)
	{
		id = newid;
		processed = false;
		neighbors = null;
	}//NodeLongley

	public boolean getprocessed()
	{
		return processed;
	}//getprocessed
	
	public void setprocessed(boolean newprocessed)
	{
		processed = newprocessed;
	}//setprocessed
	
	//getter for id 
	public int getid()
	{
		return id;
	}//getid
	
	
	//setter for myData 
	public void setid(int newid)
	{
		id = newid;
	}//setid
	
	
	public void addEdge(Node destination) 
	{
		neighbors.add(destination);
	}
}//Node
