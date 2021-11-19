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
		
		//initialize matrix to false
		for (int i = 0; i < numOfVertices; i++)
		{
			for( int k= 0; k< numOfVertices; k++)
				matrix[i][k] = false;
		}//for
		
		//change from false to true if in list of neighbors
		//if vertex id's start a 0 we do not have to adjust for the matix positions
		if(graph.theVertices.get(0).getid() == 0)
		{
			for (int h = 0; h < graph.theVertices.size() ; h++)
				   for (int p = 0; p < graph.theVertices.get(h).getNeighbors().size(); p++)
				      matrix[h][graph.theVertices.get(h).getNeighbors().get(p).getid()] = true;
		}//if
		else
		{
			for (int h = 0; h < graph.theVertices.size() ; h++)
			   for (int p = 0; p < graph.theVertices.get(h).getNeighbors().size(); p++)
			      matrix[h][graph.theVertices.get(h).getNeighbors().get(p).getid()-1] = true;
		}//else
		
		//print out 1 for true and 0 for false 
		for (int i = 0; i < graph.numOfVertices; i++)
		{
			System.out.println( );
		   for (int j = 0; j < graph.numOfVertices; j++)
		   {
			   if(matrix[i][j] == true)
				   System.out.print(" 1 ");
			   else
				   System.out.print(" 0 ");
		   }//for
		}//for
		    
	 }//printGraph
	  
	//depth first traversal
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
				//recursion
				depthFT(v.neighbors.get(n));
			}//if
		}//for
	}//DepthFT
	
	//breadth first traversal
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
	
	//reset processed to be false again after one traversal has been done
	//so second traversal and start fresh
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
	
	//reset number of vertices and the vertices when we are moving to next graph
	public void resetGraph(Graph graph)
	{
		graph.numOfVertices = 0;
		graph.theVertices.clear();
	}//resetGraph
}//Graph


