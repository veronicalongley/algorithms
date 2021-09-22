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

		String fileName = ""; 
		String item = "";
		int numofItems = 666;
		String [] magicItems = new String [666];
		
		System.out.println("Enter a filename: ");
		fileName = keyboard.next();
		try
			{
			Scanner readFile = new Scanner (new File (fileName));
			for(int i = 0; i < numofItems; i++)
				{
				item = readFile.nextLine();
				magicItems[i] = item;
				}//for
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
		
		for (int i = 0; i < numofItems; i++)
		{
			Stack stackversion = new Stack();
			Queue queueversion = new Queue();
			magicItems[i].toUpperCase();
			magicItems[i].replaceAll(" ", "");
			for(int j = 1; j <= magicItems[j].length(); j++)
			{
				//while (j<= magicItems[i].length() )
				//{
					char c = magicItems[i].charAt(j);
					stackversion.push(c);
					queueversion.enqueue(c);
				//}//while
			}//for
			
			boolean palindrome = true;
			int k = 1;
			
			while ( palindrome == true || k<= magicItems[i].length() )
			{
				char s = 'a';
				char q = 'b';
				s = stackversion.pop();
				q = queueversion.dequeue();
				k++;
				if(Character.compare(s, q) == 0 ) {
					k++;
				}
					
				else
					palindrome = false;
			}//while
			
			if(palindrome == true)
				System.out.println(magicItems[i]);
			
		}//for
	}

}
