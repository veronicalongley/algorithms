
public class ListOfSpices {

	private Spice myHead;
	private Spice ordered;
	
	public ListOfSpices()
	{
		myHead = null;
		ordered = null;
	}//List of Spices
	
	public void add(String name, int value, int quant)
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
	
	
}
