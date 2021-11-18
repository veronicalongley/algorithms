import java.io.*;
import java.util.ArrayList;
public class Graph {
	
	private int numOfVertices;
	
	public ArrayList<Vertex> theVertices;
	 
	
	
	public Graph()
	{
		theVertices = new ArrayList<>();
		numOfVertices = 0;

	}//Graph
	
	public void addVertex(int num)
	{
		Vertex newVertex = new Vertex(num);
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
				//System.out.println("Adding Vertex");
				addVertex(val);
			}//else if
			
			else if (list.get(i).contains("edge"))
			{
				int start = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("e") + 2, list.get(i).indexOf("-") -1 ));
				int end = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 2 ));
				
				//System.out.println("Adding edge" + start+ " -  " + end);
				
				if(theVertices.get(0).getid() == 0)
				{
					theVertices.get(start).addEdge(theVertices.get(end));
					theVertices.get(end).addEdge(theVertices.get(start));
				}//if
				
				else
				{
					//System.out.println("Adding edge to vertex " + theVertices.get(start -1 ).getid());
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
		for(int j = 0; j < graph.numOfVertices; j++)
		{
			System.out.print(graph.theVertices.get(j).getid()+ " | ");
			for(int q = 0; q < graph.theVertices.get(j).neighbors.size(); q++)
			{
				System.out.print(graph.theVertices.get(j).neighbors.get(q).getid());
			}//for
			System.out.println();
		}//for
		
	}//printAdjList
	
	
	public void printMatrix(Graph graph)  
	{
		boolean [][] matrix = new boolean [numOfVertices][numOfVertices];
		for (int i = 0; i < numOfVertices; i++)
		{
			for( int k= 0; k< numOfVertices; k++)
				matrix[i][k] = false;
		}
		for (int h = 0; h < graph.theVertices.size() ; h++)
			   for (int p = 0; p < graph.theVertices.get(h).getNeighbors().size(); p++)
			      matrix[h][graph.theVertices.get(h).getNeighbors().get(p).getid()-1] = true;
	
		for (int i = 0; i < graph.numOfVertices; i++)
		{
			System.out.println( );
		   for (int j = 0; j < graph.numOfVertices; j++)
		   {
			   if(matrix[i][j] == true)
				   System.out.print(" 1 ");
			   else
				   System.out.print(" 0 ");
		   }
		}
			
			   
		    
	 }//printGraph
	    
	public void depthFT(Vertex v)
	{
		if(v.getprocessed() == false)
		{
			System.out.println(v.getid());
			v.setprocessed(true);
		}// if
		
		for (int n = 0; n < v.neighbors.size(); n++)
		{
			if(v.neighbors.get(n).getprocessed() == false)
			{
				depthFT(v.neighbors.get(n));
			}//if
		}//for
	}//DepthFT
	
	public void breadthFT(Vertex v)
	{
		Queue q = new Queue();
		q.enqueue(v);
		v.setprocessed(true);
		Vertex cv;
		while(!q.isEmpty())
		{
			cv = q.dequeue();
			System.out.println(cv.getid());
			for(int n = 0; n < cv.neighbors.size(); n++)
			{
				if(cv.neighbors.get(n).getprocessed() == false)
				{
					q.enqueue(cv.neighbors.get(n));
					cv.neighbors.get(n).setprocessed(true);
				}//if
			}//for
		}//while
	}//breadthFT
	
	public void reset(Vertex v)
	{
		if(v.getprocessed() == true)
		{
			System.out.println(v.getid());
			v.setprocessed(false);
		}// if
		
		for (int n = 0; n < v.neighbors.size(); n++)
		{
			if(v.neighbors.get(n).getprocessed() == true)
			{
				depthFT(v.neighbors.get(n));
			}//if
		}//for
	}//reset
}//Graph


