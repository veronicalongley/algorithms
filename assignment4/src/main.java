import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
import java.util.ArrayList;

public class main {
	public static float totalComparisons;


	public static void main(String[] args) 
	{
		String fileName = "graphs.txt";
		
		String [] graph = new String[375];
		int i =0;
		try {
		Scanner readFile = new Scanner (new File (fileName));
		
		while (readFile.hasNextLine()) 
		   {
			   	graph[i]= readFile.nextLine();
			   //	System.out.println(graph[i]);
			   	i++;
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
		Graph firstGraph = new Graph();
		Graph secondGraph = new Graph();
		Graph thirdGraph = new Graph();
		Graph fourthGraph = new Graph();
		Graph fifthGraph = new Graph();
		
		ArrayList<String> firstGraphCmd = new ArrayList<>();
		for(int h = 0; h < graph[h].indexOf(" "); h++)
		{
			firstGraphCmd.add(graph[h]);
		}//for
		
		firstGraph.makeGraph(firstGraphCmd);
		
		System.out.println();
		System.out.println("Matrix Form: ");
		firstGraph.printMatrix(firstGraph);
		System.out.println();
		System.out.println("Adjacency List: ");
		firstGraph.printAdjList(firstGraph);
		
	 
		
		
		
		
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
		
		for(int j = 0; j < NUMOFITEMS; j++)
		{
			System.out.print(magicItems[j] + " -- ");
			
			tree.search(tree.root, magicItems[j]);
			
			totalComparisons += comparisons;
			System.out.print(" -- " +comparisons);
			System.out.println();
		}
		System.out.println(totalComparisons / NUMOFITEMS);
		
	  }
	

	
}
