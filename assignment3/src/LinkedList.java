
public class LinkedList {

	private NodeLongley myHead;

	public LinkedList()
	{
		myHead = null;
	}//LinkedList 


	public void setHead( NodeLongley newHead)
	{
		myHead = newHead;
	}//setHead

	public void clear()
	{
		myHead = null;
	}//clear

	private int findIndex(String keyValue)
	{
		int index = -1;
		boolean found = false;
		NodeLongley curr = myHead;
		while((curr != null)&&(!found))
			{
			if(curr.getData().compareToIgnoreCase(keyValue)== 0)
				{
				found = true;
				index = 1;
				}//if
			else
				curr = curr.getNext();
			}//while
		return index;
	}//findIndex

	public boolean add(String item)
	{
		boolean found = false;
		NodeLongley curr = myHead;
		NodeLongley prev = null;
		NodeLongley newGuy = new NodeLongley (item);
		
		if(findIndex(item) == -1)
		{
			while ((curr != null)&&(!found))
			{
				if((curr.getData().compareToIgnoreCase(item)>0))
					found = true;
				else
				{
					prev = curr;
					curr = curr.getNext();
				}//else
				
			}//while
			found = true;
			newGuy.setNext(curr);
			if(prev == null)
				myHead = newGuy;
			else
				prev.setNext(newGuy);
		}//if

			return found;
			
	}//add

	public boolean remove(String keyValue)
	{
		boolean found = false;
		NodeLongley curr = myHead;
		NodeLongley prev = null;
		
		if(findIndex(keyValue)== 1)
		{
			while((curr != null) && (!found))
			{
				if (curr.getData().compareToIgnoreCase(keyValue) == 0)
					found = true;
				else
				{
					prev = curr;
					curr = curr.getNext();
				}//else
			}//while
			
			if(found)
			{
				if(prev == null)
					myHead = curr.getNext();
				else
					prev.setNext(curr.getNext());
			}//if
		}//if
		return found;

	}//remove

	public String retrieve(String keyValue)
	{
		String ans = null;
		NodeLongley curr = myHead;
		boolean found = false;
		if(findIndex(keyValue) != -1)
		{
			while (!found)
			{
				if (curr.getData().compareToIgnoreCase(keyValue)==0)
				{
					
					ans = curr.getData();
					found = true;
				}//if
				curr = curr.getNext();
			}//while
		}//if
		return ans;
	}//retrieve 

	public boolean isEmpty()
	{
		boolean ans = false;
		if(myHead == null)
			ans = true;
		return ans;
	}//isEmpty

	public boolean isFull()
	{
		boolean ans = false;
		return ans;
	}//isFull

	public void print()
	{
		NodeLongley curr = myHead;
			while (curr != null)
			{
				System.out.println(curr.getData().toString());
				curr = curr.getNext();
			}//while
	}//print


}
