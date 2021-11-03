
public class HashTable {
	
	private static final int HASH_TABLE_SIZE = 250;
	private NodeLongley[] hashTable;
	int mySize = 0;
	
	public HashTable()
	{
		hashTable = new NodeLongley[HASH_TABLE_SIZE];
		mySize = 0;
	}//HashTable
	
	public void insert(String str)
	{
		int position = -1;
		mySize++;
		position = makeHashCode(str);
		NodeLongley insertion = new NodeLongley(str);
		if (hashTable[position] == null)
		{
			hashTable[position] = insertion;
		}//if
		else
		{
			insertion.setNext(hashTable[position]);
			hashTable[position] = insertion;
		}//else
		
	}//insert
	
	private static int makeHashCode(String str) {
	      str = str.toUpperCase();
	      int length = str.length();
	      int letterTotal = 0;

	      // Iterate over all letters in the string, totaling their ASCII values.
	      for (int i = 0; i < length; i++) {
	         char thisLetter = str.charAt(i);
	         int thisValue = (int)thisLetter;
	         letterTotal = letterTotal + thisValue;

	         // Test: print the char and the hash.
	         /*
	         System.out.print(" [");
	         System.out.print(thisLetter);
	         System.out.print(thisValue);
	         System.out.print("] ");
	         // */
	      }

	      // Scale letterTotal to fit in HASH_TABLE_SIZE.
	      int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
	      // TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.

	      return hashCode;
	   }//makeHashCode
	
	private void printHashTable() 
	{
		System.out.println();
		for(int i =0; i< hashTable.length; i++)
		{
			System.out.println("Bucket "+ i + ": ");
			NodeLongley first = hashTable[i];
			while(first != null)
			{
				System.out.println(first.getData() + "; ");
				first.getNext();
			}//while
			System.out.println();
		}//for
	}//printHashTable
	
	
}//HashTable
