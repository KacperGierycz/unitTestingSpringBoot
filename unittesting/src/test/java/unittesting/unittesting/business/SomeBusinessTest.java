package unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import unittesting.unittesting.business.SomeBusinessImpl;


public class SomeBusinessTest {

	@Test
	public void calculate() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		int actualResult=business.calculate(new int[] {1,2,3} );
		int expectedResult= 6;
		assertEquals(expectedResult,actualResult);
		
		
		
	}
	
	@Test
	public void calculate_empty() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		int actualResult=business.calculate(new int[] {} );
		int expectedResult= 0;
		assertEquals(expectedResult,actualResult);
		
		
		
	}

}
