package unittesting.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import unittesting.unittesting.busines.SomeBusinessImpl;

@SpringBootTest
public class SomeBusinesTest {

	@Test
	public void calculate() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		int actualResult=business.calculate(new int[] {1,2,3} );
		int expectedResult= 6;
		assertEquals(expectedResult,actualResult);
		
		
		
	}

}
