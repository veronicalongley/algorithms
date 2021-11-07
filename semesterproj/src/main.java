import java.util.Random;

public class main 
{
	public static void main(String[] args) 
	{
		int popSize = 100; 
		double infectedAmt = popSize * 0.02;
		int [] population = new int [popSize];
		int sum = 0; 
		
		for(int j = 0; j < popSize; j++)
		{
			population[j] = 0;
			//System.out.println(population[j]);
		}//for
		
		for(int i = 0; i < infectedAmt; i++)
		{
			population[i] = 1; 
		}//for
		
		shuffle(population, popSize);
		
		for(int j = 0; j < popSize; j++)
		{
			System.out.println(population[j]);
			sum += population[j];
		}//for
		
		System.out.println(sum);
	
	}//main
	
	static void shuffle (int values [], final int TOTNUM)
	{
		Random random = new Random();
		int temp = -1;
		random.nextInt();
		for (int i = 0; i < TOTNUM; i++)
		{
			int change = i + random.nextInt(TOTNUM - i);
			temp = values[i];
	        values[i] = values[change];
	        values[change] = temp;
		}//for
	}//shuffle
	
	
}//main
