package unittesting.unittesting;

import static org.junit.Assert.*;



import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

import java.util.ArrayList;
import java.util.List;

public class ListMockTest {
	
	List<String> mock = mock(List.class);
//	List mock = mock(List.class);

	@Test
	public void size_basic() {
		
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28minutes");
		assertEquals("in28minutes",mock.get(0));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in28minutes");
		assertEquals("in28minutes",mock.get(100));
		
		
	}
	@Test
	public void verificationBasics() {
	//SUT
		String value1=mock.get(0);
		String value2=mock.get(1);
		
		//Verify
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeastOnce()).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock,atMost(2)).get(anyInt());
		verify(mock ,never()).get(2);		
	}
	
	@Test
	public void argumentCapturing() {
		
		//SUT
		mock.add("SomeStrign");
		
		
		//Verification
		ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeStrign",captor.getValue());
		
		
	}
	
	
	@Test
	public void multipleArgumentCapturing() {
		
		//SUT
		mock.add("SomeStrign1");
		mock.add("SomeStrign2");
		
		//Verification
		ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues=captor.getAllValues();
		
		assertEquals("SomeStrign1",allValues.get(0));
		assertEquals("SomeStrign2",allValues.get(1));
		
	}
	
	@Test
	public void mocking() {
		
		ArrayList arrayListMock=mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); //null
		System.out.println(arrayListMock.size()); //0
		arrayListMock.add("Test"); // 
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size()); //0
		
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
		
		
	}
	
	@Test
	public void spying() {
		
		ArrayList arrayListSpy=spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0)); //null
		System.out.println(arrayListSpy.size()); //1
		arrayListSpy.add("Test"); // 
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size()); //3
		
		when(arrayListSpy.size()).thenReturn(5);
		arrayListSpy.add("Test3");
		System.out.println(arrayListSpy.size()); //5
		
		verify(arrayListSpy).add("Test3");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
