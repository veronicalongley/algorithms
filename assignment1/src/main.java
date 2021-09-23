import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main 
{

static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		//intialize variables
		String fileName = ""; 
		int numofItems = 666;
		String [] magicItems = new String [666];
		String theitem = null;
		System.out.println("Enter a filename: ");
		fileName = keyboard.next();
		
		//input item names from file 
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
		
		//for loop to go through the list of magic items
		for (int i = 0; i < numofItems; i++)
		{
			Stack stackversion = new Stack();
			Queue queueversion = new Queue();
			String word = "";
			
			//eliminate spaces and lower case letters
			// store in 'word' so we can print the possible palindrome correctly
			word = magicItems[i].toUpperCase();
			word = word.replaceAll(" ", "");
			
			//for loop to go through the chars of the magic item
			for(int j = 0; j <= word.length()-1; j++)
			{
					char c = word.charAt(j);
					stackversion.push(c);
					queueversion.enqueue(c);	
			}//for
			
			
			boolean palindrome = true;
			int k = 0;
			
			//while loop to check for palindromes by popping and dequeuing 
			//the same string and comparing those chars
			while ( palindrome == true && k<= word.length()-1 )
			{
				char s = 'a';
				char q = 'b';
				s = stackversion.pop();
				q = queueversion.dequeue();
				if(Character.compare(s, q) == 0 ) 
				{
					k++;
				}//if		
				else
				{
					palindrome = false;
				}//else
					
			}//while
			
			//Print palindrome if it is true
			if(palindrome == true)
				System.out.println(magicItems[i]);
		}//for
		
	}//main

}//main
