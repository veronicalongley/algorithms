import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) 
	{
		//Read instructions .txt file
		//make graphs line by line as opposed to storing file
		String fileName = "graphs2.txt";
		String file2Name = "spice.txt";
		try 
		{
		Scanner readFile = new Scanner (new File (fileName));
		String textLine = "";
		Graph newGraph = new Graph();
		String[] vertices;
        String[] edges;
        int graph = 0; 
        System.out.println("Directed Weighted Graphs: ");
		while (readFile.hasNextLine()) 
		   {
			textLine = readFile.nextLine();
			if (textLine.equals("new graph"))
			{
				newGraph = new Graph();
				graph++;
			}//if
				
			else if (!(textLine.equals("")) && (textLine.charAt(0) != '-'))
			{
				if(textLine.contains("vertex"))
				{
					vertices = textLine.split("add vertex ");
					newGraph.addVertex(Integer.parseInt(vertices[1]));
				}//if
				else if (textLine.contains("edge"))
				{
					edges = textLine.split("\\s+");
					//System.out.println(edges[5]);
					newGraph.addEdge(Integer.parseInt(edges[2]), Integer.parseInt(edges[4]), Integer.parseInt(edges[5]));
				}//if
			}//else if
			else if (textLine.equals("") )
			{
				System.out.println("Graph # "+ graph + ": ");
				newGraph.detailsG();
				SSSP nextSssp = new SSSP(newGraph);
				System.out.println();
			}//else if
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
		
	try 
	{
		System.out.println("Spice Heist: ");
		Scanner readFile = new Scanner (new File (file2Name));
		String text = "";
		String spice [];
		String knapsack [];
		int sackNum = 0;
		Knapsack[] sacks = new Knapsack[50];
		ListOfSpices newSpice = new ListOfSpices();
		while(readFile.hasNextLine())
		{
			text = readFile.nextLine();
			if( text.equals("") ||text.charAt(0)!= '-' )
			{
				if(text.contains("spice"))
				{
					text = text.replace(';', ' ');
					spice = text.split("\\s+");
					//System.out.println(spice[3]+ " " + spice[6]+ " " + spice[9]);
					newSpice.add(spice[3], Double.parseDouble(spice[6]), Integer.parseInt(spice[9]));
					
				}//if
				else if(text.contains("knapsack"))
				{
					text = text.replace(';', ' ');
					knapsack = text.split("\\s+");
					sacks[sackNum]= new Knapsack(Integer.parseInt(knapsack[3]));
					//System.out.println(knapsack[3]);
					sackNum++;
				}//elseif
			}
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
	
	}//main
	
}//main
