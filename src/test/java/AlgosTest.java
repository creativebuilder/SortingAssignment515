package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Item;
import main.java.RandomNumber;
import main.java.SortAlgos;

public class AlgosTest {

	//This test case is for covering case 1 of node coverage i.efor throwing NullPointerException
		@Test (expected = NullPointerException.class)
		public void methodForNullInputCoverage()
		{
			Item x[] = new Item[10];
			Item y[] = new Item[10];
			int inputArray[]= {};
			for(int i =0;i<inputArray.length;i++)
			{
				x[i]=new Item(inputArray[i]);
				y[i] = new Item(inputArray[i]);
			}
			
			SortAlgos.bubbleSort(x);
			SortAlgos.insertionSort(y);;
			
			for(int j =0;j<inputArray.length;j++)
			{
				assert(x[j].key== y[j].key);
			}
		}
		
		//This test case is for covering case 2 of node coverage - i.e breaking the outer for loop
		@Test
		public void methodForBreakingOuterForLoop()
		{
			Item x[] = new Item[1];
			Item y[] = new Item[1];
			int inputArray[]= {8};
			for(int i =0;i<inputArray.length;i++)
			{
				x[i]=new Item(inputArray[i]);
				y[i] = new Item(inputArray[i]);
			}
			
			SortAlgos.bubbleSort(x);
			SortAlgos.heapSort(y);
			
			for(int j =0;j<inputArray.length;j++)
			{
				assert(x[j].key== y[j].key);
			}
		}

	
	//This test case is for covering case 4 of node coverage - i.e failing if (vec[i-1].key > vec[i].key)
	@Test
	public void methodForBreakingIfCondition()
	{
		Item x[] = new Item[3];
		Item y[] = new Item[3];
		int inputArray[]={9,4,5};
		for(int i =0;i<inputArray.length;i++)
		{
			x[i]=new Item(inputArray[i]);
			y[i] = new Item(inputArray[i]);
		}
		
		SortAlgos.bubbleSort(x);
		SortAlgos.selectionSort(y);
		
		for(int j =0;j<inputArray.length;j++)
		{
			assert(x[j].key== y[j].key);
		}
	}
	
	//This test case is for covering case 5 of node coverage - happy path where all lines gets executed
	@Test
	public void methodForAllStatementsExecuting() {
		
		Item[] items = retrieveInputList(200);
		Item[] items1 = items;
		SortAlgos.bubbleSort(items);
		SortAlgos.quickSort(items1);
		for (int i =0;i<4;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	//Additional test cases to increase code coverage
	@Test
	public void methodForAllStatementsExecutingWithMergeSort() {
		
		Item[] items = retrieveInputList(6);
		Item[] items1 = items;
		SortAlgos.bubbleSort(items);
		SortAlgos.mergeSort(items1);
		for (int i =0;i<4;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	@Test
	public void methodForAllStatementsExecutingWithHeapSort() {
		
		Item[] items = retrieveInputList(100);
		Item[] items1 = items;
		SortAlgos.bubbleSort(items);
		SortAlgos.heapSort(items1);
		for (int i =0;i<4;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	@Test
	public void methodForAllStatementsExecutingWithInsertionSort() {
		
		Item[] items = retrieveInputList(500);
		Item[] items1 = items;
		SortAlgos.bubbleSort(items);
		SortAlgos.insertionSort(items1);
		for (int i =0;i<4;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	@Test
	public void methodForAllStatementsExecutingWithSelectionSort() {
		
		Item[] items = retrieveInputList(300);
		Item[] items1 = items;
		SortAlgos.bubbleSort(items);
		SortAlgos.selectionSort(items1);
		for (int i =0;i<4;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	
	private Item[] retrieveInputList(int size) {
		Item[] items = null;
		if (size > 0) {
			items =  new Item[size];
			RandomNumber randomGenerator = new RandomNumber();
			for (int i = 0; i< size; i++) {
				items[i] = new Item(randomGenerator.nextIntRand(0, size));
			}
		}
		return items;
	}	
	
}
