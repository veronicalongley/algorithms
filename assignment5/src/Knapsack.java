
public class Knapsack {

	private int capacity;
	private double currentQuant;
	private double currentVal;
	
	public Knapsack()
	{
		capacity = 0;
		currentQuant = 0;
		currentVal = 0;
	}//knapsack
	
	public Knapsack(int newCapacity)
	{
		capacity = newCapacity;
		currentQuant = 0;
		currentVal = 0;
	}//Knapsack
	
	public void setCurrentQuant(double newQuant)
	{
		currentQuant = currentQuant + newQuant;
	}//setCurrentQuant
	
	public void setCurrentVal(double newVal)
	{
		currentVal = currentVal + newVal;
	}//setCurrentVal
	
	public int getCapacity()
	{
		return capacity;
	}//getCapacity
	
	public double getCurrentQuant()
	{
		return currentQuant;
	}//getCurrentQuant
	
	public double getCurrentVal()
	{
		return currentVal;
	}//getCurrentVal
}//Knapsack
