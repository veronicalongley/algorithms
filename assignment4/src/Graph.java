import java.io.*;
import java.util.ArrayList;
public class Graph {
	
	private int numOfVertices;
	
	public ArrayList<Vertex> theVertices;
	 
	boolean [][] m = new boolean [numOfVertices][numOfVertices];
	
	public Graph()
	{
		theVertices = new ArrayList<>();
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
				addVertex(val);
//				for (int d = 0; d < theVertices.size();d++) 
//			      { 		      
//			          System.out.print(theVertices.get(d).getid());
//			          System.out.println();
//			      } 
			}//else if
			
			else if (list.get(i).contains("edge"))
			{
				int start = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("e") + 2, list.get(i).indexOf("-") -1 ));
				int end = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 2 ));
				
				if(theVertices.get(0).getid() == 0)
				{
//					System.out.println(start+ end);
//					System.out.println(end);
					theVertices.get(start).addEdge(theVertices.get(end));
					theVertices.get(end).addEdge(theVertices.get(start));
					m[start][end] = true;
					m[end][start] = true;
				}//if
				
				else
				{
//					System.out.println(start+ end);
//					System.out.println(end);
					theVertices.get(start - 1 ).addEdge(theVertices.get(end - 1));
					theVertices.get(end - 1 ).addEdge(theVertices.get(start - 1));
					m[start][end] = true;
					m[end][start] = true;
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
			System.out.println(graph.theVertices.get(j).getid()+ "| ");
			for(int q = 0; q < graph.theVertices.get(j).neighbors.size(); q++)
			{
				System.out.print(graph.theVertices.get(j).neighbors.get(q));
			}//for
		}//for
		
	}//printAdjList
	
	
	public void printMatrix(Graph graph)  
	{
	
		for (int i = 0; i < graph.numOfVertices; i++)
		   for (int j = 0; j < graph.numOfVertices; j++)
		      System.out.print(m[i][j] + " ");
		    
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


