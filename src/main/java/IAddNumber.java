import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IAddNumber {
	
	public void addTwoNum(Integer a,Integer b);
	
	public void removeNum(Integer a);
	
	
	public List<Integer> getList();

}
