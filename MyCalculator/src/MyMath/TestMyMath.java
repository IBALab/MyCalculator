package MyMath;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyMath {
	MyMath mm;
	ArrayList <Integer>   allFilesList;

	@Before
	public void setUp() throws Exception {
		mm=new MyMath();
		allFilesList=new ArrayList <Integer> ();
		for (int i=0;i<=5;i++)
			allFilesList.add(i);
	}

	@After
	public void tearDown() throws Exception {
		allFilesList.clear();
	}

	@Test
	public void intToInteger() {
		int a = 0;
		Integer b = 0;
		assertTrue( mm.intToInteger(a).getClass().getName() == b.getClass().getName());
		
	}
	
	@Test
	public void sum() {
		//1
		assertEquals(mm.sum(allFilesList),new Integer(15));
		
		//2
		allFilesList.clear();
		assertNull(mm.sum(allFilesList));
		
	}
	
	@Test
	public void max() {
		//1
		assertEquals(mm.max(allFilesList),new Integer(5));
		
		//2
		allFilesList.clear();
		assertNull(mm.max(allFilesList));

	}
	@Test
	public void min() {
		//1
		assertEquals(mm.min(allFilesList),new Integer(0));
		//2
		allFilesList.clear();
		assertNull(mm.min(allFilesList));

	}
	@Test
	public void EvenMinusOdd() {
		//1
		assertEquals(mm.EvenMinusOdd(allFilesList),new Integer(-3));
		
		//2
		allFilesList.clear();
		assertNull(mm.EvenMinusOdd(allFilesList));

	}
	@Test
	public void Mean() {
		//1
		//System.out.println("dd "+mm.Mean(allFilesList).intValue());
		assertEquals(mm.Mean(allFilesList),new Integer(2));
		
		//2
		allFilesList.clear();
		assertNull(mm.Mean(allFilesList));

	}

}
