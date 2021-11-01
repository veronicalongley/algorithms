import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static int linearComparisons;
	public static int binaryComparisons;
	
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

		shuffle(magicItems, NUMOFITEMS);
		for (int j = 0; j < 42; j++)
		{
			subArray[j] = magicItems[j];
	//		System.out.println(subArray[j]);
		}//for
		
		mergeSort(magicItems);
		System.out.println();
//		for (int j = 0; j < SUBARRAYSIZE; j++)
//		{
//			System.out.println(subArray[j]);
//		}//for
		for(int i = 0; i<SUBARRAYSIZE; i++)
		{
			linSearchComp = linearSearch(magicItems, subArray[i]);
			System.out.println(linSearchComp);
			
		}
		System.out.println();
		System.out.println(linearComparisons/SUBARRAYSIZE);
		System.out.println();
		for(int i = 0; i<SUBARRAYSIZE; i++)
		{
		//	binSearchComp = binarySearch(magicItems, 0, NUMOFITEMS -1, subArray[i]);
			binSearchComp = binarySearch(magicItems, subArray[i]);
			System.out.println(binSearchComp);	
		}
		System.out.println();
		System.out.println(binaryComparisons/SUBARRAYSIZE);
		
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

	
	static int linearSearch(String items[], String target)
	{
		int comparisons = 0; 
		int loc = -1;
		int l = 0;
	//	for (int l = 0; l < items.length; l++)
		while(items[l] != target)
		{
			comparisons++;
			linearComparisons ++;
			if(items[l]==target)
				loc = l;
			l++;
		}
		
		return comparisons;
	}
	
	
	  static int binarySearch(String[] arr, String x)
	    {
	        int left = 0;
	        int middle = 0;
	        int right = arr.length - 1;
	        int pos = 0;
	        int index = -1;
	        while (left <= right) {
	        	binaryComparisons++;
	            middle = left + (right - left) / 2;
	 
	            pos = x.compareTo(arr[middle]);
	 
	            // Check if x is present at mid
	            if (pos == 0)
	                index = middle;
	 
	            // If x greater, ignore left half
	            if (pos > 0)
	                left = middle + 1;
	 
	            // If x is smaller, ignore right half
	            else
	                right = middle - 1;
	        }
	 
	        return index;
	    }
	
}//main
	
	
