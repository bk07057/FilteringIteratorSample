package self.learn.bkhadka;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import self.learn.bkhadka.EvenNumberTest;
import self.learn.bkhadka.FilteringIterator;
import self.learn.bkhadka.IObjectTest;
import self.learn.bkhadka.NumberCountingIterator;
import self.learn.bkhadka.OddNumberTest;

public class FilteredIteratorTest {

	@Test
	public void testOddNumberIteration() {
		Iterator<Integer> myIterator = new NumberCountingIterator(1, 10);
		IObjectTest myTest = new OddNumberTest();
		
		FilteringIterator iterToTest = new FilteringIterator(myIterator, myTest);
		while (iterToTest.hasNext()){
			Integer val = (Integer) iterToTest.next();
			//System.out.println(val);
			// all values we get here must be odd 
			assertTrue (( val % 2) == 1);
		}		
	}
	
	@Test
	public void testEvenNumberIteration() {
		Iterator<Integer> myIterator = new NumberCountingIterator(5, 15);
		IObjectTest myTest = new EvenNumberTest();
		
		FilteringIterator iterToTest = new FilteringIterator(myIterator, myTest);
		while (iterToTest.hasNext()){
			Integer val = (Integer) iterToTest.next();
			
			//System.out.println(val);
			// all values we get here must be even
			assertTrue (( val % 2) == 0);
		}	
	}
	
	@Test
	public void testReverseIterator() {
		Iterator<Integer> myIterator = new NumberCountingIterator(5, -15); // this should count backward 
		IObjectTest myTest = new EvenNumberTest();
		
		FilteringIterator iterToTest = new FilteringIterator(myIterator, myTest);
		while (iterToTest.hasNext()){
			Integer val = (Integer) iterToTest.next();
			// all values we get here must be even
			assertTrue (( val % 2) == 0);
		}
	}
	
	@Test
	public void testSingleOddNumber() {
		Iterator<Integer> myIterator = new NumberCountingIterator(5, 5); // this iterator should iterate over just 1 element - 5
		IObjectTest myTest = new OddNumberTest();
		
		FilteringIterator iterToTest = new FilteringIterator(myIterator, myTest);
		if (iterToTest.hasNext()){
			Integer val = (Integer) iterToTest.next();
			assertTrue (val ==  5);
		}	
		
		// lets try to get without checking hasNext()
		Iterator<Integer> myIterator2 = new NumberCountingIterator(5, 5); // this iterator should iterate over just 1 element - 5
		FilteringIterator iterToTest2 = new FilteringIterator(myIterator2, myTest);
		assertEquals (iterToTest2.next(), 5);
		
	}
	
	@Test
	public void testAllInvalidNumbers() {
		Iterator<Integer> myIterator = new NumberCountingIterator(1, 1); // this iterator should iterate over just 1 element - 5
		IObjectTest myTest = new EvenNumberTest();
		
		// lets try to get without checking hasNext()
		FilteringIterator iterToTest = new FilteringIterator(myIterator, myTest);
		assertNull (iterToTest.next());
		
	}
	
}
