import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
import java.util.ArrayList;

public class main {
	public static float totalComparisons;
	public static Graph theGraph = new Graph();

	public static void main(String[] args) 
	{
		String fileName = "graphs1.txt";
		ArrayList<String> commands = new ArrayList<>();
		try {
		Scanner readFile = new Scanner (new File (fileName));
		
		while (readFile.hasNextLine()) 
		   {
				commands.add(readFile.nextLine());
				
		   }//while
		}//try
		
	catch(FileNotFoundException ex)
		{
		System.out.println("Failed to find file: "+ fileName);
		}//catch
	catch(InputMismatchException ex)
		{
		System.out.println("Type mismatch for the number I tried to read. ");
		System.out.println(ex.getMessage());
		}//catch
	catch(NumberFormatException ex)
		{
		System.out.println("Failed to convert String text into an integer value. ");
		System.out.println(ex.getMessage());
		}//catch
	catch(NullPointerException ex)
		{
		System.out.println("Null pointer exception. ");
		System.out.println(ex.getMessage());
		}//catch
	catch(Exception ex)
		{
		System.out.println("Oops, something went wrong. ");
		ex.printStackTrace();
		}//catch	
		
		
		makeGraph(commands);
		
		for(int h = 0; h < 20; h++)
		{
		//	firstGraphCmd.add(graph[h]);
		}//for
		
		
		//firstGraph.makeGraph(firstGraphCmd);		

//		
//		System.out.println();
//		System.out.println("Matrix Form: ");
//		firstGraph.printMatrix(firstGraph);
//		System.out.println();
//		System.out.println("Adjacency List: ");
//		firstGraph.printAdjList(firstGraph);
//		
//		firstGraph.depthFT(firstGraph.theVertices.get(0));
//		firstGraph.reset(firstGraph.theVertices.get(0));
//		firstGraph.breadthFT(firstGraph.theVertices.get(0));
//		
//		int next = 0;
//		int endOfNext = 0;
//		int empty = 0; 
//		
//		for (int k = 22; k < 59; k++)
//		{
//		//	secondGraphCmd.add(graph[k]);
//		}
		
//		secondGraph.makeGraph(secondGraphCmd);
//		
//		System.out.println();
//		System.out.println("Matrix Form: ");
//		secondGraph.printMatrix(secondGraph);
//		System.out.println();
//		System.out.println("Adjacency List: ");
//		secondGraph.printAdjList(secondGraph);
		
		
		
		
		String file2Name = ""; 
		final int NUMOFITEMS = 666;
		String [] magicItems = new String [NUMOFITEMS];
		String theitem = null;
		file2Name = "magicitems.txt";
		float comparisons = 0;
		
		//input item names from file and store in array
		try
			{
			Scanner readFile = new Scanner (new File (file2Name));
			int g = 0; 
			while(readFile.hasNextLine())
			{
				theitem = readFile.nextLine();
				magicItems[g] = theitem;
				g++;
			}//while
			readFile.close();
			}//try
		catch(FileNotFoundException ex)
			{
			System.out.println("Failed to find file: "+ file2Name);
			}//catch
		catch(InputMismatchException ex)
			{
			System.out.println("Type mismatch for the number I tried to read. ");
			System.out.println(ex.getMessage());
			}//catch
		catch(NumberFormatException ex)
			{
			System.out.println("Failed to convert String text into an integer value. ");
			System.out.println(ex.getMessage());
			}//catch
		catch(NullPointerException ex)
			{
			System.out.println("Null pointer exception. ");
			System.out.println(ex.getMessage());
			}//catch
		catch(Exception ex)
			{
			System.out.println("Oops, something went wrong. ");
			ex.printStackTrace();
			}//catch
		
		BinarySearchTree tree = new BinarySearchTree();
		for(int k = 0; k < NUMOFITEMS; k++)
		{
			System.out.print(magicItems[k] + ": ");
			tree.insert(magicItems[k]);
			System.out.println();
		}//for
		
		System.out.println();
		System.out.println("In-order Traversal:");
		tree.inOrder();
		System.out.println();
		System.out.println("Searches and Comparisons:");
		
		final int NUMOFSEARCHES = 42; 
		String file3Name = "magicitems-find-in-bst.txt";
		String [] itemsToFind = new String [NUMOFSEARCHES];
		//input item names from file and store in array
		try
			{
			Scanner readFile = new Scanner (new File (file3Name));
			int r = 0; 
			while(readFile.hasNextLine())
			{
				itemsToFind[r] = readFile.nextLine();
				r++;
			}//while
			readFile.close();
			}//try
		catch(FileNotFoundException ex)
			{
			System.out.println("Failed to find file: "+ file2Name);
			}//catch
		catch(InputMismatchException ex)
			{
			System.out.println("Type mismatch for the number I tried to read. ");
			System.out.println(ex.getMessage());
			}//catch
		catch(NumberFormatException ex)
			{
			System.out.println("Failed to convert String text into an integer value. ");
			System.out.println(ex.getMessage());
			}//catch
		catch(NullPointerException ex)
			{
			System.out.println("Null pointer exception. ");
			System.out.println(ex.getMessage());
			}//catch
		catch(Exception ex)
			{
			System.out.println("Oops, something went wrong. ");
			ex.printStackTrace();
			}//catch
		
		for(int j = 0; j < NUMOFSEARCHES; j++)
		{
			System.out.print(itemsToFind[j] + " -- ");
			
			tree.search(tree.root, itemsToFind[j]);
			
			totalComparisons += tree.countComps();
			System.out.print(" -- " );
			System.out.println(tree.countComps());
			tree.resetComps();
		}
		System.out.println();
		System.out.println("The average number of comparisons " + totalComparisons / NUMOFSEARCHES);
		
	  }
	
	public static void makeGraph(ArrayList<String> list)
	{
		for (int i = 0; i<list.size(); i++)
		{
			if(list.get(i).contains("undirected"))
			{
				System.out.println(list.get(i));
			}//if
			
			else if(list.get(i).contains("new graph"))
			{
				//System.out.println("done");
				Graph theGraph = new Graph();
				//System.out.println(theGraph.getnumOfVertices());
			}
			
			else if (list.get(i).contains("vertex"))
			{
				int val = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1 ));
				//System.out.println("Adding Vertex");
				theGraph.addVertex(val);
			}//else if
			
			else if (list.get(i).contains("edge"))
			{
				int start = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("e") + 2, list.get(i).indexOf("-") -1 ));
				int end = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 2 ));
				
				//System.out.println("Adding edge" + start+ " -  " + end);
				
				if(theGraph.theVertices.get(0).getid() == 0)
				{
					theGraph.theVertices.get(start).addEdge(theGraph.theVertices.get(end));
					theGraph.theVertices.get(end).addEdge(theGraph.theVertices.get(start));
				}//if
				
				else
				{
					//System.out.println("Adding edge to vertex " + theVertices.get(start -1 ).getid());
					theGraph.theVertices.get(start - 1 ).addEdge(theGraph.theVertices.get(end - 1));
					theGraph.theVertices.get(end - 1 ).addEdge(theGraph.theVertices.get(start - 1));

				}//else
				
			}//else if
			
			else if (list.get(i).equals("") )
			{
				System.out.println();
				System.out.println("The Adjacency List: ");
				theGraph.printAdjList(theGraph);
				System.out.println();
				System.out.println("The Matrix: ");
				theGraph.printMatrix(theGraph);
				System.out.println();
				System.out.println();
				System.out.println("Depth First Traversal ");
				theGraph.depthFT(theGraph.theVertices.get(0));
				System.out.println();
				//System.out.println(theGraph.theVertices.get(2).getprocessed());
				theGraph.reset(theGraph.theVertices.get(0));
				//System.out.println(theGraph.theVertices.get(2).getprocessed());
				System.out.println();
				System.out.println("Breadth First Traversal ");
				theGraph.breadthFT(theGraph.theVertices.get(0));
				System.out.println();
				theGraph.resetGraph(theGraph);
				System.out.println();
				System.out.println();
				System.out.println();
				
			}
			
			else
			{
				
			}//else
		}//for
	}//makeGraph
	
}
