package self.learn.bkhadka;
import java.util.Iterator;

public class NumberCountingIterator implements Iterator<Integer> {
	Integer min;
	Integer max;
	Integer current;
	Integer incrementValue; //since this is non-restrictive iterator, it can iterate from 100 to 1 in which case increment value will be -1 
	
	public NumberCountingIterator(Integer minval, Integer maxval){
		min = minval;
		max = maxval;
		
		current = minval;
		if (min <= max)
			incrementValue = 1;
		else 
			incrementValue = -1;
	}
	
	@Override
	public boolean hasNext() {
		// i.e. we are counting forward
		if (incrementValue > 0) {
			if (current + incrementValue <= max || current == min)
				return true;
		}
		// i.e. we are counting reverse
		else {
			if (current + incrementValue >= max || current == min)
				return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			Integer toRet = current;
			current = toRet + incrementValue;
			return toRet;
		}
		
		return null;
	}
	

}
