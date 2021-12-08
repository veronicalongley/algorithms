
import java.util.ArrayList;
public class Graph {

	private int numOfVertices;
	public ArrayList<Vertex> theVertices;
	public ArrayList<Edge> theEdges;
	
	public Graph()
	{
		theVertices = new ArrayList<>();
		theEdges = new ArrayList<>();
		numOfVertices = 0;

	}//Graph
	
	public void addVertex(int num)
	{
		Vertex newVertex = new Vertex(num);
		theVertices.add(newVertex);
		numOfVertices++;
		//System.out.println("Added " + num);
	}//addVertex
	
	public void addEdge(int sourceID, int destID, int weight)
	{
		Edge newEdge = new Edge(theVertices.get(sourceID-1 ), theVertices.get(destID-1), weight);
		//System.out.println("Added " + sourceID + " - " + destID + " " + weight);
		theEdges.add(newEdge);
	}//addEdge
	
	
	public ArrayList<Vertex> getVertices()
	{
		return theVertices;
	}//getVertices
	
	public ArrayList<Edge> getEdges()
	{
		return theEdges;
	}//getEdges
	
	public int getnumOfVertices()
	{
		return numOfVertices;
	}//getnumOfVertices
	
	public void detailsG()
	{
		for (int i = 0; i < theEdges.size();  i++)
		{
			theEdges.get(i).detailsE();
		}//for
	}//detailsG
}//Graph



