import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static int linearComparisons;
	public static int binaryComparisons;
	public static int hashTableComparisons;
	private static final int HASH_TABLE_SIZE = 250;
	
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
		int linSearchComp = 0;
		int binSearchComp = 0;
		
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

		//shuffle the 666 magic items
		shuffle(magicItems, NUMOFITEMS);
		
		//pick the first 42 and store them in a sub-array
		for (int j = 0; j < 42; j++)
		{
			subArray[j] = magicItems[j];
		}//for
		
		//use merge sort to order the original 666 magic items
		mergeSort(magicItems);
		
		//linear search for each of the 42 sub-array items
		//print the number of comparisons associated with each item
		System.out.println("Linear Search: ");
		for(int i = 0; i<SUBARRAYSIZE; i++)
		{
			linSearchComp = linearSearch(magicItems, subArray[i]);
			System.out.println(linSearchComp+ " comparisons to locate " + subArray[i]);;
			
		}
		
		//Print the average number of comparisons for linear search
		System.out.println("The average number of comparisons using linear search: "+ linearComparisons/SUBARRAYSIZE);
		System.out.println();
		
		System.out.println("Binary Search: ");
		//binary search for each of the 42 sub-array items
		//print the number of comparisons associated with each item
		for(int i = 0; i<SUBARRAYSIZE; i++)
		{
			binSearchComp = binarySearch(magicItems, subArray[i]);
			System.out.println(binSearchComp+ " comparisons to locate " + subArray[i]);	
		}
		
		//Print the average number of comparisons for binary search
		System.out.println("The average number of comparisons using binary search: "+ binaryComparisons/SUBARRAYSIZE);
		
		System.out.println();
		System.out.println("Hash Table: ");
		HashTable hash = new HashTable();
		
		//fill hash table
		for(int i = 0; i<NUMOFITEMS; i++)
		{
			hash.put(magicItems [i], magicItems[i]);
		}
		
		
		//locate the 42 sub-array items in hash table
		//print the number of comparisons associated with each item
		for(int j = 0; j < SUBARRAYSIZE; j++)
		{
			int itemcomp = 0; 
			itemcomp = hash.objComps(subArray[j]);
			if (itemcomp == 1)
				System.out.println(itemcomp + " comparison to locate " + hash.get(subArray[j]));
			else
				System.out.println(itemcomp + " comparisons to locate " + hash.get(subArray[j]));
			hashTableComparisons += itemcomp;
		}//for
		
		
		System.out.println();
		System.out.println("The average number of comparisons using a hash table : " + hashTableComparisons / SUBARRAYSIZE);
		
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

		//if the sub-lists are not yet length one
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

	
	static int linearSearch(String items[], String target)
	{
		int comparisons = 0; 
		int loc = -1;
		int l = 0;
		while(items[l] != target)
		{
			comparisons++;
			linearComparisons ++;
			if(items[l]==target)
				loc = l;
			l++;
		}//while
		
		return comparisons;
	}//linear search
	
	
	  static int binarySearch(String[] items, String target)
	    {
	        int left = 0;
	        int middle = 0;
	        int right = items.length - 1;
	        int pos = 0;
	        int index = -1;
	        int indivComp = 0;
	        while (left <= right && index ==-1) {
	        	
	        	binaryComparisons++;
	        	indivComp++;
	            middle = left + (right - left) / 2;
	 
	            pos = target.compareTo(items[middle]);
	 
	            // Check if x is present at mid
	            if (pos == 0)
	                index = middle;
	 
	            // If x greater, ignore left half
	            if (pos > 0)
	                left = middle + 1;
	 
	            // If x is smaller, ignore right half
	            else
	                right = middle - 1;
	        }//while
	 
	        return indivComp;
	    }//binary search
	

	  
	  
}//main
	
	
