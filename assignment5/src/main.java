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
		//Read instructions .txt file
		//make graphs line by line as opposed to storing file
		while (readFile.hasNextLine()) 
		   {
			textLine = readFile.nextLine();
			if (textLine.equals("new graph"))
			{
				newGraph = new Graph();
				graph++;
			}//if
				
			//if the line is not empty and is not a comment 
			else if (!(textLine.equals("")) && (textLine.charAt(0) != '-'))
			{
				//if it contains 'vertex' we are adding a vertex
				if(textLine.contains("vertex"))
				{
					vertices = textLine.split("add vertex ");
					newGraph.addVertex(Integer.parseInt(vertices[1]));
				}//if
				
				//if the line contains edge we are adding an edge 
				else if (textLine.contains("edge"))
				{
					edges = textLine.split("\\s+");
					newGraph.addEdge(Integer.parseInt(edges[2]), Integer.parseInt(edges[4]), Integer.parseInt(edges[5]));
				}//if
			}//else if
			
			//if line is empty we are outputting SSSP 
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
		double difference;
		double amount;
		double quatloos = 0;
		int counter = 0;
		String contains = "";
		Knapsack[] sacks = new Knapsack[5];
		ListOfSpices newSpice = new ListOfSpices();
		while(readFile.hasNextLine())
		{
			text = readFile.nextLine();
			if( text.equals("") ||text.charAt(0)!= '-' )
			{
				//if line contains spice we are adding a new spice 
				if(text.contains("spice"))
				{
					text = text.replace(';', ' ');
					spice = text.split("\\s+");
					//System.out.println(spice[3]+ " " + spice[6]+ " " + spice[9]);
					newSpice.add(spice[3], Double.parseDouble(spice[6]), Integer.parseInt(spice[9]));
					
				}//if
				else if(text.contains("knapsack"))
				{
					//if line contains knapsack  we want to know the highest possible 
					//value for that knapsack
					text = text.replace(';', ' ');
					knapsack = text.split("\\s+");
					sacks[sackNum]= new Knapsack(Integer.parseInt(knapsack[3]));
					//System.out.println(knapsack[3]);
					sackNum++;
				}//elseIf
			}//if
			
		}//while
		
		//put spices in order by value
		newSpice.spiceSort();
		Spice curr = newSpice.getHead();
		
		while(counter < sacks.length && sacks[counter] != null)
		{
			//if spice is not null and sack is not full
			if(curr != null && sacks[counter].getCurrentQuant() != sacks[counter].getCapacity())
			{
				//if we can add the entirety of the spice 
				if (sacks[counter].getCurrentQuant() + curr.getQuant() < sacks[counter].getCapacity())
				{
					sacks[counter].setCurrentQuant(curr.getQuant());
					contains = contains + (", " + (curr.getQuant()* 1.0) + " scoop(s) of " + curr.getName());
					quatloos = quatloos + (curr.getQuant() * curr.getPerUnitValue());
					curr = curr.getNext();
				}//if
				//if we can only add some of the spice 
				else
				{
					difference = (sacks[counter].getCapacity() - sacks[counter].getCurrentQuant());
					amount = difference / curr.getQuant();
					sacks[counter].setCurrentQuant(amount * curr.getQuant());
					sacks[counter].setCurrentVal(amount * curr.getPerUnitValue());
					contains = contains +  (", " + amount * curr.getQuant() + " scoop(s) of " + curr.getName() );
					quatloos = quatloos + ((amount * curr.getQuant())* curr.getPerUnitValue());
					curr = curr.getNext();
				}//else
			}//if
			
			else
			{
				System.out.println("Knapsack of capacity " + sacks[counter].getCapacity() + " is worth "
						+ quatloos + " quatloos and contains" + contains + ". ");
				counter ++;
				curr = newSpice.getHead();
				quatloos = 0;
				contains = "";
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
