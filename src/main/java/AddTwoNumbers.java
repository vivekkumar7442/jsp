import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class AddTwoNumbers implements IAddNumber {
	
	private List<Integer> numbers=new ArrayList<Integer>();

	@Override
	public void addTwoNum(Integer a, Integer b) {
		numbers.add(a);
		numbers.add(b);
		
	}

	@Override
	public void removeNum(Integer a) {
		numbers.remove(a);
		
	}

	@Override
	public List<Integer> getList() {
		return numbers;
	}

}
