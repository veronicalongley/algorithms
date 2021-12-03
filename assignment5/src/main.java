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
		String fileName = "graphs1.txt";
		ArrayList<String> commands = new ArrayList<>();
		try {
		Scanner readFile = new Scanner (new File (fileName));
		String textLine = "";
		Graph newGraph = new Graph();
		String[] vertices;
        String[] edges;
		while (readFile.hasNextLine()) 
		   {
			textLine = readFile.nextLine();
			if (textLine.equals("new graph"))
				newGraph = new Graph();
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
				}
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
