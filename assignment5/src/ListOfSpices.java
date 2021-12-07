
public class ListOfSpices {

	private Spice myHead;
	private Spice ordered;
	
	public ListOfSpices()
	{
		myHead = null;
		ordered = null;
	}//List of Spices
	
	public void add(String name, double value, int quant)
	{
		Spice newSpice = new Spice(name, value, quant);
		Spice newNext = myHead;
		myHead = newSpice;
		myHead.setNext(newNext);
	}
	
	public Spice getHead()
	{
		if(isEmpty() == false)
		{
			return myHead;
		}
		else
			return null;
	}//getHead
	
	public boolean isEmpty()
	{
		if (myHead ==null)
			return true;
		else
			return false;
	}//isEmpty
	
	public void spiceSort()
	{
		ordered = null;
		Spice curr = myHead;
		while(curr != null)
		{
			Spice next = curr.getNext();
			insert(curr);
			curr = next;
		}//while
	}//spiceSort
	
	public void insert(Spice newSpice)
	{
		if(ordered == null || ordered.getPerUnitValue()<= newSpice.getPerUnitValue())
		{
			newSpice.setNext(ordered);
			ordered = newSpice;
		}//if
		else
		{
			Spice curr = ordered;
			while(curr.getNext() != null && curr.getNext().getPerUnitValue()> newSpice.getPerUnitValue())
			{
				curr = curr.getNext();
			}//while
			newSpice.setNext(curr.getNext());
			curr.setNext(newSpice);
		}//else
	}//insert
	
}//List of Spices
