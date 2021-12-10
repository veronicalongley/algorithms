import java.util.Random;
import java.util.Arrays;
import java.util.stream.*;

public class main 
{
	
	public static float case1;
	public static float case2;
	public static float case3;
	public static float numofTests;
	
	public static void main(String[] args) 
	{
		int popSize = 1000; 
		double infectedAmt = popSize * 0.02;
		int [] population = new int [popSize];
		int groupSize = 8;
		int sum = 0; 
		
		for(int j = 0; j < popSize; j++)
		{
			population[j] = 0;
			//System.out.println(population[j]);
		}//for
		
		for(int i = 0; i < Math.floor(infectedAmt); i++)
		{
			population[i] = 1; 
		}//for
		
		shuffle(population, popSize);
		
		for(int j = 0; j < popSize; j++)
		{
			//System.out.println(population[j]);
			sum += population[j];
		}//for
		
		//System.out.println(sum);
		
		int [] samplePool = new int [groupSize];
		
		for(int k = 0; k < popSize; k = k+ 8 )
		{
			samplePool[0] = population[k];
			samplePool[1] = population[k+1];
			samplePool[2] = population[k+2];
			samplePool[3] = population[k+3];
			samplePool[4] = population[k+4];
			samplePool[5] = population[k+5];
			samplePool[6] = population[k+6];
			samplePool[7] = population[k+7];
			runtest(samplePool);

		}
		System.out.println("Case 1: "+ case1);
		System.out.println("Case 2: "+ case2);
		System.out.println("Case 3: "+ case3);
		System.out.println("Total tests "+ numofTests);
	
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
	
	static void runtest(int pool [])
	{
		boolean posneg = false;
		boolean posneg2 = false;
		boolean posneg3 = false;
		
		posneg = test(pool);
		
		if(posneg == false)
		{
			case1++;
		}//if
		
		else
		{
			int[] firstHalf = Arrays.copyOfRange(pool, 0, 3);
			int[] secondHalf = Arrays.copyOfRange(pool, 4, 7);
			posneg2 = test(firstHalf);
			posneg3 = test(secondHalf);
			
			if(posneg2 == true )
			{
				int[] first = Arrays.copyOfRange(pool,0,0);
				int[] second = Arrays.copyOfRange(pool,1,1);
				int[] third = Arrays.copyOfRange(pool,2,2);
				int[] fourth = Arrays.copyOfRange(pool,3,3);
				test(first);
				test(second);
				test(third);
				test(fourth);
				case2++;
			}
			if(posneg3 == true)
			{
				int[] first = Arrays.copyOfRange(pool,4,4);
				int[] second = Arrays.copyOfRange(pool,5,5);
				int[] third = Arrays.copyOfRange(pool,6,6);
				int[] fourth = Arrays.copyOfRange(pool,7,7);
				test(first);
				test(second);
				test(third);
				test(fourth);
				case2++;
			}
			if(posneg2 ==true && posneg3 ==true)
			{
				case3++;
				case2 = case2 - 2;
			}
		}
		
	}
	
	static boolean test(int pool[])
	{
		numofTests ++;
		boolean result = false;
		if(IntStream.of(pool).sum() != 0)
		{
			result = true;
		}
		return result;
	}
	
	
}//main
