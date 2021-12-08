
import java.util.ArrayList;

public class Vertex {
	//vertices are labelled with an id
	//dist and prev aid with SSSP
	private int id;
	private int dist;
	private Vertex prev;
	
	
	public Vertex()
	{
		id = 0;
		prev = null;
		dist = -1;
	}//Vertex
	
	public Vertex(int newid)
	{
		id = newid;
	}//Vertex
	
	public void setPrev(Vertex newPrev)
	{
		prev = newPrev;
	}//setPrev
	
	public Vertex getPrev()
	{
		return prev;
	}//getPrev
	
	public void setDist(int newDist)
	{
		dist = newDist;
	}//setDist
	
	//getter for id 
	public int getid()
	{
		return id;
	}//getid
	
	public int getDist()
	{
		return dist;
	}//getDist

}//Vertex

