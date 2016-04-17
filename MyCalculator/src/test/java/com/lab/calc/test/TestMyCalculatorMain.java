package com.lab.calc.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lab.calc.MyCalculatorMain;

public class TestMyCalculatorMain {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void main() throws FileNotFoundException {
		String args [] = new String []{"/home/admin/docs/source_archive","/home/admin/docs/source_archive/input.txt","MIN"};
		MyCalculatorMain.main(args);
		Integer rightResult = 32, calcResult = null;
		File outputFile = new File (args[1]);
		Scanner scanner = new Scanner(outputFile);
		while(scanner.hasNextInt())
			calcResult = scanner.nextInt();
		scanner.close();
		System.out.println(calcResult);
		assertEquals(rightResult,calcResult);
	}

}
