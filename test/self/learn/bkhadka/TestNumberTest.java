package self.learn.bkhadka;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestNumberTest {

	@Test
	public void testOddNumberTest(){
		OddNumberTest tester1 = new OddNumberTest();
		boolean expectedFalse= tester1.test(6);
		assertFalse (expectedFalse);
		
		boolean expectedTrue = tester1.test(3);
		assertTrue (expectedTrue);
		
	}
	
	@Test
	public void testEvenNumberTest(){
		OddNumberTest tester1 = new OddNumberTest();
		boolean expectedFalse= tester1.test(100);
		assertFalse (expectedFalse);
		
		boolean expectedTrue = tester1.test(-5);
		assertTrue (expectedTrue);
		
	}
	
}
