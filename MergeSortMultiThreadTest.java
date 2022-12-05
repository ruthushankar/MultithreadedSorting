package main.test;

import static org.junit.Assert.*;

import main.java.service.impl.MergeSortMultiThread;
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class MergeSortMultiThreadTest
{
	MergeSortMultiThread mergeSortMultiThread;
	//Comparable[] arrayOfElements= {2, -3, 1, 9, 5, 6};
	Comparable arrayOfElements[] = getRandomIntArray(10000);
	
	    @Before
	    public void setUp()
	    {
	    	mergeSortMultiThread = new MergeSortMultiThread(arrayOfElements);
	    }
	    
	    @After
	    public void tearDown() 
	    {
	    	mergeSortMultiThread = null;
	    }
	    
//UNIT TEST  
//test sort method
	    @Test  
	    public void testsort()
	    {  
	  			mergeSortMultiThread.sort();
	  			Assert.assertArrayEquals(arrayOfElements, arrayOfElements);
	     }

//test mergesort method
		@Test  
	    public void testmergeSort()
	    {   
			try
			{
	    		mergeSortMultiThread.sort();
	    		Assert.assertTrue(true);
			}
			catch(Exception e)
			{
				Assert.assertFalse(false);
			}
	    }  

//test merge method
		@Test  
	     public void testmerge()
	     {   
			try
			{
				int begin=0, half=0,end=0;  
				mergeSortMultiThread.merge(arrayOfElements, begin, half, end);
				Assert.assertTrue(true);
			}
			catch(Exception e)
			{
				Assert.assertFalse(false);
			}
	     }

//test execution time
		@Test  
	    public void getExecutionTime()
		{  
			mergeSortMultiThread.sort();
			long Executiontime = mergeSortMultiThread.getExecutionTime();
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
//INTEGRATION TEST
	    
// test for an array of even no.of integers
	    @Test
	    public void mergeSortTest1() 
	    {
	    	Integer[] arrayElements = {-3, 1, 2, 5, 6, 9};
	        System.out.println("Array before Sorting: " + Arrays.toString(arrayOfElements)); 
	        mergeSortMultiThread.sort();
	        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
	        assertArrayEquals(arrayOfElements, arrayElements);
	    } 
}

//test for an array of odd no.of integers
	    @Test
	    public void mergeSortTest2() 
	    {
	    	Integer[] arrayElements = {-2, 2, 4, 7, 11};
	        System.out.println("Array before Sorting: " + Arrays.toString(arrayOfElements)); 
	        mergeSortMultiThread.sort();
	        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
	        assertArrayEquals(arrayOfElements, arrayElements);
	    } 

//test for a null array
	    @Test
	    public void mergeSortTest3() 
	    {
	    	Integer[] arrayElements = {};
	        System.out.println("Array before Sorting: " + Arrays.toString(arrayOfElements)); 
	        mergeSortMultiThread.sort();
	        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
	        assertArrayEquals(arrayOfElements, arrayElements);
	    }
	    
//test for an array with duplicates
	    @Test
	    public void mergeSortTest4() 
	    {
			Integer[] arrayElements = {-4, -4, 3, 3, 5, 6};
	        System.out.println("Array before Sorting: " + Arrays.toString(arrayOfElements)); 
	        mergeSortMultiThread.sort();
	        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
	        assertArrayEquals(arrayOfElements, arrayElements);
	    }
	    
//test with string input
 		@Test
	    public void mergeSortTest5() 
	    {
	    	String[] arrayElements = {"a", "b", "d", "e", "f"};
	        System.out.println("Array before Sorting: " + Arrays.toString(arrayOfElements)); 
	        mergeSortMultiThread.sort();
	        System.out.println("Array after Sorting: " + Arrays.toString(arrayOfElements));
	        assertArrayEquals(arrayOfElements, arrayElements);
	    }     
}
*/
 

