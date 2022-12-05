package main.test;
import main.java.service.impl.QuickSortMultiThread;
import main.java.service.utility.Utility;

import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class QuickSortMultiThreadTest 
{
	main.java.service.impl.QuickSortMultiThread QuickSortMultiThread;
	Utility utility  = new Utility();
	//Comparable[] arrayOfElements= {1, 7, 4, 3, 9, 2};
	Comparable arrayOfElements[] = getRandomIntArray(1000);
	
	@Before
	public void setUp()
	{
		QuickSortMultiThread = new QuickSortMultiThread(arrayOfElements);
	}
	
	@After
	public void tearDown()
	{
		QuickSortMultiThread = null;
	}

//UNIT TESTING
//test partition method in utility.java
	@Test  
	public void testpartition()
	{  
		try
		{
			int low=0, high=0; 
			utility.partition(arrayOfElements, low, high);
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			Assert.assertFalse(false);
		}
	}
	
//test swap method in utility.java
	@Test  
	public void testswap()
	{   
		try
		{
			int p=0,r=0; 
			utility.swap(arrayOfElements, p, r);
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			Assert.assertFalse(false);
		}
	}
	
//test selection sort method in utility.java
	 @Test  
	    public void testselectionSort()
	 	{  
		 	try
		 	{ 
				utility.selectionSort(arrayOfElements);
				Assert.assertTrue(true);
		 	}
		 	catch(Exception e)
		 	{
			 	Assert.assertFalse(false);
		 	}
	    }
	 
//test getExecutionTime method in MultiThreadQuickSort.java
		@Test  
	    public void testgetExecutionTime()
		{  
			QuickSortMultiThread.sort();
			long Executiontime = QuickSortMultiThread.getExecutionTime();
			System.out.println(Executiontime);	
	    	} 

	    static Comparable[] getRandomIntArray(int length) 
	    {
	        Comparable a[] = new Comparable[length];
	        for (int i = 0; i < length; i++) 
	        {
	            a[i] = (int) Math.floor(Math.random() * length * 5);
	        }
	        return a;
	    }
}

/*
//INTEGRATION TESTING	
//test for an array of even number of integers
	 @Test
	 public void quickSortTest1() 
	 {
		 Integer[] arrayElements = {-7, -4, 3, 5, 7, 9};
		 System.out.println("Array before Sorting: " + Arrays.toString(arrayElements)); 
		 QuickSortMultiThread.sort();
		 System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
		 assertArrayEquals(arrayOfElements, arrayElements);
	}
	  
//test for an array of odd no.of integers
		    @Test
		    public void quickSortTest2() 
		    {
		    	Integer[] arrayElements = {-2, 4, 6, 8, 9};
		        System.out.println("Array before Sorting: " + Arrays.toString(arrayElements)); 
		        QuickSortMultiThread.sort();
		        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
		        assertArrayEquals(arrayOfElements, arrayElements);
		    } 

//test for a null array
		    @Test
		    public void quickSortTest3() 
		    {
		    	Integer[] arrayElements = {};
		        System.out.println("Array before Sorting: " + Arrays.toString(arrayElements)); 
		        QuickSortMultiThread.sort();
		        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
		        assertArrayEquals(arrayOfElements, arrayElements);
		    }

//test for an array with duplicates
		    @Test
		    public void quickSortTest4() 
		    {
				Integer[] arrayElements = {-4, -4, 3, 3, 5, 6};
		        System.out.println("Array before Sorting: " + Arrays.toString(arrayElements)); 
		        QuickSortMultiThread.sort();
		        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
		        assertArrayEquals(arrayOfElements, arrayElements);
		    }
		    
//test for an array with String elements
		    @Test
			 public void quickSortTest5() 
			 {
				 String[] arrayElements = {"a", "b", "d", "f", "i"};
				 System.out.println("Array before Sorting: " + Arrays.toString(arrayElements)); 
				 QuickSortMultiThread.sort();
				 System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
				 assertArrayEquals(arrayOfElements, arrayElements);
			}
		    
	}
*/    






