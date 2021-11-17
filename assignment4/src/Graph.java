import java.io.*;
import java.util.ArrayList;
public class Graph {
	
	private int numOfVertices;
	
	public ArrayList<Node> theVertices;
	
	public Graph()
	{
		theVertices = new ArrayList<>();
	}//Graph
	
	public void addVertex(int num)
	{
		Node newVertex = new Node(num);
		theVertices.add(newVertex);
		
		numOfVertices++;
	}//addVertex
	
	public int getnumOfVertices()
	{
		return numOfVertices;
	}//getnumOfVertices
	
	
	public void makeGraph(ArrayList<String> list)
	{
		for (int i = 0; i<list.size(); i++)
		{
			if(list.get(i).equals("")|| list.get(i ).substring(0, 2).equals("--"))
			{
				System.out.println(list.get(i));
			}//if
			
			else if (list.get(i).contains("vertex"))
			{
				int val = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1 ));
				addVertex(val);
			}//else if
			
			else if (list.get(i).contains("edge"))
			{
				int start = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("e") + 2, list.get(i).indexOf("-") -1 ));
				int end = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("-") + 2 ));
				
				if(theVertices.get(0).getid() == 0)
				{
					theVertices.get(start).addEdge(theVertices.get(end));
					theVertices.get(end).addEdge(theVertices.get(start));
				}//if
				
				else
				{
					theVertices.get(start - 1 ).addEdge(theVertices.get(end - 1));
					theVertices.get(end - 1 ).addEdge(theVertices.get(start - 1));
				}//else
				
			}//else if
			
			else
			{
				
			}//else
		}//for
	}//makeGraph

	
	public void printAdjList(Graph graph)
	{
		
	}
	
	public void printMatrix(Graph graph)  
	{

	 }//printGraph
	    
}


