import java.util.LinkedList;

public class HashTable {
	
	private static final int HASH_TABLE_SIZE = 250;
	
	public static class HashObj
	{
		public String key;
		public String value;
	}//HashObj
	
	private LinkedList<HashObj>[] arr = new LinkedList[HASH_TABLE_SIZE];
	
	//initialize to null
	public HashTable()
	{
		for(int i = 0; i < HASH_TABLE_SIZE; i++)
		{
			arr[i] = null;
		}//for
	}//HashTable
	
	private HashObj getObj(String key) 
	{
		int index = -1;
		
		if (key == null)
			return null;	
		index = makeHashCode(key);
		LinkedList<HashObj> items = arr[index];
		if(items == null)
			return null;
		for(HashObj item : items)
		{
			if(item.key.equals(key))
				return item; 
		}//for
		
		return null;
	}//HashObj
	
	//count comparisons
	public int objComps(String key)
	{
		int hashTableComparisons = 0; 
		
		if(key == null)
			return -1; 
		int index = makeHashCode(key);
		LinkedList<HashObj>items = arr[index];
		
		if(items == null)
		{
			return -1; 
		}//if
		
		for(HashObj item : items )
		{
			hashTableComparisons ++; 
			if(item.key.equals(key))
				return hashTableComparisons;
		}//for
		
		return -1;
	}//objComps	
	
	public String get(String key)
	{
		HashObj item = getObj(key);
		if(item == null)
			return null;
		else
			return item.value;
	}//get 
	
	
	public void put(String key, String value)
	{
		int index = makeHashCode(key);
		LinkedList<HashObj> items = arr[index];
		if(items == null)
		{
			items = new LinkedList<HashObj> ();
			HashObj item = new HashObj();
			item.key = key;
			item.value = value;
			items.add(item);
			arr[index ] = items;
		}//if
		
		else 
		{
			for(HashObj item : items )
			{
				if(item.key.equals(key))
				{
					item.value = value;
					return;
				}//if
			}//for
			
			HashObj item = new HashObj();
			item.key = key;
			item.value = value;
			items.add(item);
		}//else
	}//put
	
	
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
	
	
}//HashTable
