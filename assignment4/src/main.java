import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class main 
{
	public static float totalComparisons;
	public static Graph theGraph = new Graph();

	public static void main(String[] args) 
	{
		//Read instructions .txt file
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
		
		//call makeGraph and send it the ArrayList of instructions from the .txt file
		makeGraph(commands);

		
		//For the Binary Search Tree
		//Read MagicItems
		String file2Name = ""; 
		final int NUMOFITEMS = 666;
		String [] magicItems = new String [NUMOFITEMS];
		String theitem = null;
		file2Name = "magicitems.txt";
		
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
		
		//fill the Binary Search Tree
		BinarySearchTree tree = new BinarySearchTree();
		for(int k = 0; k < NUMOFITEMS; k++)
		{
			System.out.print(magicItems[k] + ": ");
			tree.insert(magicItems[k]);
			System.out.println();
		}//for
		
		System.out.println();
		//Traverse it in order to get an alphabetized list of magic items
		System.out.println("In-order Traversal:");
		tree.inOrder();
		System.out.println();
		System.out.println("Searches and Comparisons:");
		
		//read the file with 42 items to search for and store in a new array
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
		
		//loop through list of items to search for
		//search for each one
		//print it out along with its path and number of comparisons needed to find it
		for(int j = 0; j < NUMOFSEARCHES; j++)
		{
			System.out.print(itemsToFind[j] + " -- ");
			
			tree.search(tree.root, itemsToFind[j]);
			
			totalComparisons += tree.countComps();
			System.out.print(" -- " );
			System.out.println(tree.countComps());
			tree.resetComps();
		}//for
		System.out.println();
		//Print the average number of comparisons for a Binary Search Tree
		System.out.println("The average number of comparisons " + totalComparisons / NUMOFSEARCHES);
		
	  }//main
	
	public static void makeGraph(ArrayList<String> list)
	{
		//loop through each line of the array
		for (int i = 0; i<list.size(); i++)
		{
			//if line contains "undirected" we know a graph is being announced, so we can 
			//print out that line as it acts as a title for the graph
			if(list.get(i).contains("undirected"))
			{
				System.out.println(list.get(i));
			}//if
			
			//if line contains "new graph" we know we want to make a new graph and not add to the last
			else if(list.get(i).contains("new graph"))
			{
				Graph theGraph = new Graph();
			}
			
			//if line contains "vertex" we want to add a new vertex to the graph
			//We locate the last space in the line and take the number from the string
			//and convert it to an integer, so it can be added to the graph of integers
			else if (list.get(i).contains("vertex"))
			{
				int val = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1 ));
				//System.out.println("Adding Vertex");
				theGraph.addVertex(val);
			}//else if
			
			//if line contains edge we are linking two vertices
			//start finds the last index of the letter e and the index of "-" and converts the number between it to an integer
			//end takes the number after the "-" and converts it to an integer 
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
			
			//if the line is empty we know the graph is done being described and we can go about 
			//making and printing the matrix and the adjacency list as well as doing two traversals 
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
				
			}//elseif
			
			else
			{
				
			}//else
		}//for
	}//makeGraph
	
}//main
