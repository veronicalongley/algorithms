package assignment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class main 
{

static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		//initialize variables used to read in items from list
		String fileName = ""; 
		final int NUMOFITEMS = 666;
		String [] magicItems = new String [NUMOFITEMS];
		String theitem = null;
		fileName = "magicitems";
		
		//input item names from file and store in array
		try
			{
			Scanner readFile = new Scanner (new File (fileName));
			int i = 0; 
			while(readFile.hasNextLine())
			{
				theitem = readFile.nextLine();
				magicItems[i] = theitem;
				i++;
			}//while
			readFile.close();
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
		
		//int ssnum = 0;
		selectionSort(magicItems, NUMOFITEMS);
		shuffle(magicItems, NUMOFITEMS);
		insertion(magicItems, NUMOFITEMS);
	    for(int i = 0; i < NUMOFITEMS; i++)
	    {
	        System.out.println(i + magicItems[i]);
	    }

		
		
	}//main


static void selectionSort( String items[], final int TOTNUM)
{
	for(int i = 0; i < TOTNUM - 1; i++)
	{
		int minIndex = i; 
		String minItem = items[i];
		String temp = "";
		for (int j = i + 1; j < TOTNUM; j++)
		{
			if (items[j].compareToIgnoreCase(minItem) < 0)
			{
				minItem = items[j];
				minIndex= j;
			}//if
		}//for j
		
		
		
		if (minIndex != i)
		{	temp = items[minIndex];
	        items[minIndex] = items[i];
	        items[i] = temp;
		}//if
	}//for i
}//selection sort

static void shuffle (String items [], final int TOTNUM)
{
	Random random = new Random();
	String temp = "";
	random.nextInt();
	for (int i = 0; i < TOTNUM; i++)
	{
		int change = i + random.nextInt(TOTNUM - i);
		temp = items[i];
        items[i] = items[change];
        items[change] = temp;
	}//for
}//shuffle

static void insertion (String items[],final int TOTNUM ) 
{
	for(int i = 0; i < TOTNUM -1; i++)
	{
		for (int j = i + 1;j>0; j--)
		{
			if(items[j].compareToIgnoreCase(items[j-1]) < 0)
			{
				String temp = items[j];
                items[j] = items[j - 1];
                items[j - 1] = temp;
			}//if
		}//for j
	}//for i
 
}//insertion


}//main 