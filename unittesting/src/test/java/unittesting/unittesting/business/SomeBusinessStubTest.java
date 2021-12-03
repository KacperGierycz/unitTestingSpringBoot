package unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import unittesting.unittesting.business.SomeBusinessImpl;
import unittesting.unittesting.data.SomeDataService;


class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}
}

class SomeDataServiceStub_empty implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {};
	}
}

class SomeDataServiceStub_oneValue implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {5};
	}	
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult=business.calculateSumUsingDataService();
		int expectedResult= 6;
		assertEquals(expectedResult,actualResult);
		
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub_empty());
		int actualResult=business.calculateSumUsingDataService();
		int expectedResult= 0;
		assertEquals(expectedResult,actualResult);

	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub_oneValue());
		int actualResult=business.calculateSumUsingDataService();
		int expectedResult= 5;
		assertEquals(expectedResult,actualResult);
		
		
		
	}
	
}
