package assignment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class main 
{
	public static int mergeComparisons;
	public static int quickComparisons; 
	
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
		
		int ssnum = 0; 
		int isnum = 0;
	
		
		ssnum = selectionSort(magicItems, NUMOFITEMS);

		shuffle(magicItems, NUMOFITEMS);
		isnum = insertion(magicItems, NUMOFITEMS);
//		for(int i = 0; i < NUMOFITEMS; i++)
//	    {
//	        System.out.println(i + magicItems[i]);
//	    }//for		
		shuffle(magicItems, NUMOFITEMS);
		mergeSort(magicItems);
		shuffle(magicItems, NUMOFITEMS);
		quicksort(magicItems, 0, NUMOFITEMS-1);
	   
	    System.out.println("Selection sort does a total of " + ssnum+ " comparisons. ");
	    System.out.println("Insertion sort does a total of " + isnum+ " comparisons. ");
	    System.out.println("Merge sort does a total of " + mergeComparisons+ " comparisons. ");
	    System.out.println("Quick sort does a total of " +quickComparisons+ " comparisons. ");

	  //  
		
	}//main


static int selectionSort( String items[], final int TOTNUM)
{
	int comparisons = 0; 
	//for loop to go through list and hold space for lowest
	//value to be swapped to 
	for(int i = 0; i < TOTNUM - 1; i++)
	{
		int minIndex = i; 
		String minItem = items[i];
		String temp = "";
		
		//for loop to compare the rest of the element in the 
		//array with the value from the for i loop 
		for (int j = i + 1; j < TOTNUM; j++)
		{
			comparisons ++;
			//if items[j] is less than the current minimum
			//item in the list assign the minimum index to 
			// be j
			if (items[j].compareToIgnoreCase(minItem) < 0)
			{
				
				minItem = items[j];
				minIndex= j;
			}//if
		}//for j

		//swap if not already in correct index
		if (minIndex != i)
		{	temp = items[minIndex];
	        items[minIndex] = items[i];
	        items[i] = temp;
		}//if
	}//for i
	return comparisons;
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

static int insertion (String items[],final int TOTNUM ) 
{
	int comparisons = 0;
	//for loop to go through array from beginning to end 
	for(int i = 1; i < TOTNUM ; i++)
	{
		String key = items[i];
		int j = i -1; 
		
		//while the item being added is greater than the end of the 
		//already sorted items and j has not reached the start of 
		//the array we slide values until j has found its position
		while((j > -1) && ( items[j] .compareToIgnoreCase(key) >0 ))
		{
			comparisons ++; 
			//slide affected values to new location
			items [j+1] = items [j];  
             j--; 
		}//for j
		
		//increment the key
		items[j+1] = key; 
	}//for i
	return comparisons;
 
}//insertion

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
		mergeComparisons++;
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

static int partition(String items[], int left, int right)
{
	random(items, left, right);
	String pivot = items[right];
	
	//indicates elements smaller than the pivot
	int x = (left - 1);
	for(int j = left; j < right; j++)
	{
		quickComparisons++;
		//if current position is smaller than pivot
		if(items[j].compareToIgnoreCase(pivot) < 0)
		{
			//increase the number of elements smaller than pivot
			x++;
			
			//swap
			String temp = items[x];
            items[x] = items[j];
            items[j] = temp;

		}//if
		
	}//for
	
	//swap remaining upper elements
	String temp2 = items[x+1];
    items[x+1] = items[right];
    items[right] = temp2;

    return x+1;
}//partition

static void quicksort (String items[], int left, int right)
{
	 
	if(left < right)
	{
		//index of pivot
		int piv = partition(items, left, right);
		//sort elements above and below the pivot
		//recursion
		quicksort(items, left, piv-1);
		quicksort(items, piv+1, right);
		
	}//if
}//quicksort

}//main 