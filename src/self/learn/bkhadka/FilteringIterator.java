package self.learn.bkhadka;

import java.util.Iterator;

public class FilteringIterator implements java.util.Iterator{

	Iterator<Integer> iterRef; 
	IObjectTest tester;
	Object nextObjCached = null;
	boolean isNextCalled = true; // which means first time hasNext will scan 
	boolean lasthasNextResponse = false;
	
	FilteringIterator (Iterator<Integer> anotherIterator, IObjectTest instance) {
		iterRef = anotherIterator;
		tester = instance;
	}

	@Override
	public boolean hasNext() {
		// since we are iterating through and skipping some elements as part of hasNext method 
		// lets cache the valid current element and use flag for the scenario of consecutive hasNext() is called 
		if (!isNextCalled)
			return lasthasNextResponse;
		
		// get the next element from the iterator 
		nextObjCached = iterRef.next();
		while (nextObjCached != null) {
			// perform its test, if passed  
			if (tester.test(nextObjCached)) {
				isNextCalled = false;
				lasthasNextResponse = true;
				return true;
			}
			// else part means we are filtering this item out 
			nextObjCached = iterRef.next();
			
		}
		
		// perhaps we reached to the end, reset the flags appropriately 
		isNextCalled = false;
		lasthasNextResponse = false;
		return false;
	}

	/***
	 * returns next element that matches the test() condition of IObjectTest instance, skipping anything else in between 
	 *    Note: This method returns null when it reached at the end (instead of throwing an exception) 
	 */
	@Override
	public Object next() {
		if (hasNext()){
			Object toRet = nextObjCached;
			isNextCalled = true;
			nextObjCached = null; 
			return toRet;
		}		
		
		// let's simply return null when we reach to the end 
		return null;
	}
	

}
