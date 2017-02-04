package self.learn.bkhadka;

public class OddNumberTest implements IObjectTest{

	@Override
	public boolean test(Object o) {
		if (o instanceof Integer)
		{
			Integer o_val = (Integer) o;
			if ((o_val % 2) == 0) return false;
			return true;
		}	
		return false;
	}

}
