
public class Spice {

	private String name;
	private int perUnitValue;
	private int quant;
	private Spice next;
	
	public Spice() 
	{
		name = null;
		perUnitValue = 0;
		quant = 0;
		next = null;
	}//Spice
	
	public Spice(String newName, int newPerUnitValue, int newQuant)
	{
		name = newName;
		perUnitValue = newPerUnitValue;
		quant = newQuant;
		next = null;
	}//Spice
	
	public void setNext(Spice newNext)
	{
		next = newNext;
	}//setNext
	
	public int getPerUnitValue()
	{
		return perUnitValue;
	}//getUnitValue
	
	public int getQuant()
	{
		return quant;
	}//getQuant
	
	public String getName()
	{
		return name;
	}//getName
	
	public Spice getNext()
	{
		return next;
	}//getNext
}//Spice
