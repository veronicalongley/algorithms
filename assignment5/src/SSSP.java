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
				
	}//algorithm
	
	public void relax(Vertex to, Vertex from, int weight)
	{
		if(from.getDist() > (to.getDist()+ weight))
		{
			from.setDist(to.getDist()+weight);
			from.setPrev(to);
		}//if
	}//relax
	
	
	public void printPath(ArrayList<Vertex> vertices)
	{
		Stack<Integer> path = new Stack<>();
		System.out.println("Shortest Path: ");
		for(int i = 1; i < vertices.size(); i++)
		{
			Vertex vertex = vertices.get(i);
			System.out.print("1 --> " + vertices.get(i).getid() + " cost is "+ vertices.get(i).getDist() + "; path is ");
			while(vertex.getPrev() != null)
			{
				vertex = vertex.getPrev();
				path.push(vertex.getid());
			}//while
			while(!path.isEmpty() )
			{
				int id = path.pop();
				System.out.print(id + "-->");
			}//while
			System.out.print(vertices.get(i).getid() + "\n");
		}//for
	}
}
