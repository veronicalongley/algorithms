import java.io.*;
import java.util.ArrayList;
public class Graph {
	
	private int numOfVertices;
	
	public ArrayList<Vertex> theVertices;
	 
	//Graph theGraph;
	
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
	
	

	
	public void printAdjList(Graph graph)
	{
		
			for(int j = 0; j < graph.numOfVertices; j++)
			{
				System.out.print(graph.theVertices.get(j).getid()+ " | ");
				for(int q = 0; q < graph.theVertices.get(j).neighbors.size(); q++)
				{
					System.out.print(graph.theVertices.get(j).neighbors.get(q).getid() + " ");
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
		
		
		if(graph.theVertices.get(0).getid() == 0)
		{
			for (int h = 0; h < graph.theVertices.size() ; h++)
				   for (int p = 0; p < graph.theVertices.get(h).getNeighbors().size(); p++)
				      matrix[h][graph.theVertices.get(h).getNeighbors().get(p).getid()] = true;
		}
		else
		{
			for (int h = 0; h < graph.theVertices.size() ; h++)
			   for (int p = 0; p < graph.theVertices.get(h).getNeighbors().size(); p++)
			      matrix[h][graph.theVertices.get(h).getNeighbors().get(p).getid()-1] = true;
		}
		
	
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
			v.setprocessed(true);
			System.out.print(v.getid() + " ");
			
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
			System.out.print(cv.getid() + " ");
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
			v.setprocessed(false);
		}// if
		
		for (int n = 0; n < v.neighbors.size(); n++)
		{
			if(v.neighbors.get(n).getprocessed() == true)
			{
				reset(v.neighbors.get(n));
			}//if
		}//for
	}//reset
	
	public void resetGraph(Graph graph)
	{
		graph.numOfVertices = 0;
		graph.theVertices.clear();
	}
}//Graph


