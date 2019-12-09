package abcd;

public class DoubleEqualityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoubleEqualityTest db = new DoubleEqualityTest();
		System.out.println(db.isZero((double) 0));

	}

	public Boolean isZero(Double Arg){
		if(0 == Arg){
			return true;
		}
		return false;
	}
}
