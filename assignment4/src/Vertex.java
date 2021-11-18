import java.util.LinkedList;
import java.util.ArrayList;

public class Vertex {
	private int id;
	private boolean processed; 
	//private  Vertex next;
	
	//LinkedList<Vertex> neighbors = new LinkedList<Vertex>();
	public ArrayList<Vertex> neighbors;

	public ArrayList<Vertex> getNeighbors()
	{
		return neighbors;
	}
	
	public void setNeighbors(ArrayList<Vertex> newNeighbors)
	{
		neighbors = newNeighbors;
	}
	
	public Vertex()
	{
		id = 0;
		processed = false;
		neighbors = new ArrayList<Vertex>();
		//next = null;
	}//Vertex
	
	public Vertex(int newid)
	{
		id = newid;
		processed = false;
		neighbors = new ArrayList<Vertex>();
		//next = null;
	}//Vertex
	

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
	
	
	public void addEdge(Vertex destination) 
	{
		//System.out.println("... destination is vertex " + destination.id);
		this.neighbors.add(destination);
		//System.out.println("added destination vertex " + destination.id + "from Vertex " + this.id);
	}
}//Vertex
