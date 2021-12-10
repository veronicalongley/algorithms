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
		}//for
		
		System.out.println("Case (1): " + popSize/8 + " * 0.8500 = "+ case1 + " instances requiring " + (case1 * 1) + " tests. ");
		System.out.println("Case (2): " + popSize/8 + " * 0.1496 = "+ case2 + " instances requiring " + (case2 * 7) + " tests. ");
		System.out.println("Case (3): " + popSize/8 + " * 0.0004 = "+ case3 + " instances requiring " + (case3 * 11) + " tests. ");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println(numofTests + " tests to screen a population of " + popSize + " people with an infection rate of 2%. ");

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
			int[] firstHalf = new int [4];
			firstHalf[0] = pool[0];
			firstHalf[1] = pool[1];
			firstHalf[2] = pool[2];
			firstHalf[3] = pool[3];
			int[] secondHalf = new int [4];
			secondHalf[0] = pool[4];
			secondHalf[1] = pool[5];
			secondHalf[2] = pool[6];
			secondHalf[3] = pool[7];
			posneg2 = test(firstHalf);
			posneg3 = test(secondHalf);
			
			if(posneg2 == true && posneg3 == false)
			{
				singleTest(pool[0]);
				singleTest(pool[1]);
				singleTest(pool[2]);
				singleTest(pool[3]);
				case2++;
			}//if
			if(posneg3 == true && posneg2 == false)
			{
				singleTest(pool[4]);
				singleTest(pool[5]);
				singleTest(pool[6]);
				singleTest(pool[7]);
				case2++;
			}//if
			if(posneg2 ==true && posneg3 ==true)
			{
				case3++;
				singleTest(pool[0]);
				singleTest(pool[1]);
				singleTest(pool[2]);
				singleTest(pool[3]);
				singleTest(pool[4]);
				singleTest(pool[5]);
				singleTest(pool[6]);
				singleTest(pool[7]);
			}//if
		}//else
		
	}//runtest
	
	static boolean test(int pool[])
	{
		numofTests ++;
		boolean result = false;
		if(IntStream.of(pool).sum() != 0)
		{
			result = true;
		}//if
		return result;
	}//test
	
	static boolean singleTest(int value)
	{
		numofTests++;
		boolean result = false;
		if(value == 1)
		{
			result = true;
		}//if
		return result;
	}//singleTest
	
}//main
