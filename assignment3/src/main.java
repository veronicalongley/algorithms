import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {

	
static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		//initialize variables used to read in items from list
		String fileName = ""; 
		final int NUMOFITEMS = 666;
		String [] magicItems = new String [NUMOFITEMS];
		final int SUBARRAYSIZE = 42;
		String [] subArray = new String [SUBARRAYSIZE];
		String theitem = null;
		fileName = "magicitems.txt";
		
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

		shuffle(magicItems, NUMOFITEMS);
		for (int j = 0; j < 42; j++)
		{
			subArray[j] = magicItems[j];
	//		System.out.println(subArray[j]);
		}//for
		
		mergeSort(subArray);
		System.out.println();
		for (int j = 0; j < 42; j++)
		{
			System.out.println(subArray[j]);
		}//for
		
	}//main
	
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
	
	static void mergeSort (String items[])
	{

		//if the sub-lists are not yet legth one
		if(items.length > 1)
		{
			//divide in half again 
			String[] left = new String [items.length/2];
			String[] right = new String [items.length- (items.length /2)];
			
			//copy items into new arrays
			for(int i = 0; i< left.length; i++)
			{
				left[i]= items[i];
			}//for i
			for(int i = 0; i< right.length; i++)
			{
				right[i]= items[i+items.length/2];
			}//for i 
			
			//recursively calls merge sort for each side 
			mergeSort(left);
			mergeSort(right);
			merge(items, left, right);
			
		}//if

	}//mergeSort

	static void merge(String[]items, String[]left, String[]right)
	{
		//merges sub-arrays
		int x = 0;
		int y = 0;
		
		for(int j = 0; j < items.length; j++)
		{
			if(y >= right.length || (x < left.length && left[x].compareToIgnoreCase(right[y]) < 0))
			{
				items[j]= left[x];
				x++;
			}//if
			else
			{
				items[j] = right[y];
				y++;
			}//else
		}//for
		
	}//merge

	static void random(String items [], int left, int right)
	{
		Random random = new Random();
		int pivot = random.nextInt(right - left)+ left;
		String temp = items[pivot];
		items[pivot]= items[right];
		items[right] = temp;
	}//random
	
}//main
	
	
