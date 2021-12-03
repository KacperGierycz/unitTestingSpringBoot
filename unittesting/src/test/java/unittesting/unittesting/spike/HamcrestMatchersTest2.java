package unittesting.unittesting.spike;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;



import org.junit.Test;

public class HamcrestMatchersTest2 {
	
	@Test
	public void learning() {
		List<Integer> numbers= Arrays.asList(12,15,45);
		
		assertThat(numbers,hasSize(3));
	}

}
