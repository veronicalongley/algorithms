import java.util.ArrayList;
import java.util.Stack;
public class SSSP {


	public SSSP(Graph graph)
	{
		algorithm(graph);
	}
	
	public void algorithm(Graph graph)
	{
		int start = 0; 
		ArrayList<Vertex> theVertices = graph.getVertices();
		ArrayList<Edge> theEdges = graph.getEdges();
		for(int i = 0; i <  theVertices.size(); i++)
		{
			theVertices.get(i).setDist(10000);
			theVertices.get(i).setPrev(null);
		}
		theVertices.get(start).setDist(0);
		for(int j = 1; j<theVertices.size(); j++)
		{
			for(int k = 0; k<theEdges.size(); k++)
			{
				relax(theEdges.get(j).getTo(), theEdges.get(j).getFrom(), theEdges.get(j).getWeight());
			}
		}
		
		for(int i = 0; i < theEdges.size(); i++)
		{
			if(theEdges.get(i).getFrom().getDist() > (theEdges.get(i).getTo().getDist() + theEdges.get(i).getWeight()))
			{
				System.out.println("Negative Cycle");
			}
		}
		
		printPath(theVertices);
				
		
	}
}
