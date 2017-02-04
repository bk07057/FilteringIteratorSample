package self.learn.bkhadka;

public class EvenNumberTest implements IObjectTest{

	@Override
	public boolean test(Object o) {
		if (o instanceof Integer)
		{
			Integer o_val = (Integer) o;
			if ((o_val % 2) == 0) return true;
			return false;
		}	
		return false;
	}

}
