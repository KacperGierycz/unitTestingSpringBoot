package unittesting.unittesting.busines;

public class SomeBusinessImpl {
	
	public int calculate(int[] data) {
		
		int sum=0;
		for(int value:data) {
			sum+=value;
		}
		return sum;
		
	}

}
