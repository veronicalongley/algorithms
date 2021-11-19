import java.util.ArrayList;

public class Vertex {
	//Vertexes are made up of an id, a boolean is processed to 
	//aid with traversals and a list of neighbors 
	private int id;
	private boolean processed; 
	public ArrayList<Vertex> neighbors;
	
	public Vertex()
	{
		id = 0;
		processed = false;
		neighbors = new ArrayList<Vertex>();
	}//Vertex
	
	public Vertex(int newid)
	{
		id = newid;
		processed = false;
		neighbors = new ArrayList<Vertex>();
	}//Vertex
	
	public ArrayList<Vertex> getNeighbors()
	{
		return neighbors;
	}//getNeighbors
	
	public void setNeighbors(ArrayList<Vertex> newNeighbors)
	{
		neighbors = newNeighbors;
	}//setNeighbors
	
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
	
	//add vertex to other vertex's list of neighbors to create an edge 
	public void addEdge(Vertex destination) 
	{
		//System.out.println("... destination is vertex " + destination.id);
		this.neighbors.add(destination);
		//System.out.println("added destination vertex " + destination.id + "from Vertex " + this.id);
	}//add edge 
}//Vertex
