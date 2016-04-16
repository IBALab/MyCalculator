package com.lab.calc.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lab.calc.MyMath;

public class TestMyMath {
	MyMath myMath;
	ArrayList <Integer> allFilesList;

	@Before
	public void setUp() throws Exception {
		myMath = new MyMath();
		allFilesList = new ArrayList <Integer> ();
		for (int i = 0; i <= 5; i++)
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
		assertTrue(myMath.intToInteger(a).getClass().getName() == b.getClass().getName());		
	}
	
	
	@Test
	public void sum() {
		//1
		assertEquals(myMath.sum(allFilesList), new Integer(15));
		
		//2
		allFilesList.clear();
		assertNull(myMath.sum(allFilesList));		
	}
	
	
	@Test
	public void max() {
		//1
		assertEquals(myMath.max(allFilesList), new Integer(5));
		
		//2
		allFilesList.clear();
		assertNull(myMath.max(allFilesList));

	}
	
	
	@Test
	public void min() {
		//1
		assertEquals(myMath.min(allFilesList), new Integer(0));
		//2
		allFilesList.clear();
		assertNull(myMath.min(allFilesList));

	}
	
	
	@Test
	public void EvenMinusOdd() {
		//1
		assertEquals(myMath.EvenMinusOdd(allFilesList), new Integer(-3));
		
		//2
		allFilesList.clear();
		assertNull(myMath.EvenMinusOdd(allFilesList));
	}
	
	
	@Test
	public void Mean() {
		//1
		assertEquals(myMath.Mean(allFilesList), new Integer(2));
		
		//2
		allFilesList.clear();
		assertNull(myMath.Mean(allFilesList));
	}
}
