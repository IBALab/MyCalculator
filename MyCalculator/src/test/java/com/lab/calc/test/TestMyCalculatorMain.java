package com.lab.calc.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lab.calc.MyCalculatorMain;

public class TestMyCalculatorMain {
	static String pathToInputFolder = "src/test/resources";
	static String pathToOutputFolder = pathToInputFolder + "/MyCalculatorTestResults";


	@BeforeClass
	public static void setUp() throws Exception {
		new File(pathToOutputFolder).mkdir();
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void mainForMin() throws Exception {
		// min
		String args[] = new String[] { pathToInputFolder, pathToOutputFolder + "/minResult.txt", "MIN" };
		MyCalculatorMain.main(args);
		Integer rightMin = 6;
		File outputFile = new File(args[1]);
		Integer calcResult = readFromFile(outputFile);
		assertEquals(rightMin, calcResult);
	}


	@Test
	public void mainForMax() throws Exception {
		// max
		String args[] = new String[] { pathToInputFolder, pathToOutputFolder + "/maxResult.txt", "Max" };
		MyCalculatorMain.main(args);
		Integer rightMax = 30522;
		File outputFile = new File(args[1]);
		Integer calcResult = readFromFile(outputFile);
		assertEquals(rightMax, calcResult);

	}


	@Test
	public void mainForSum() throws Exception {
		// sum
		String args[] = new String[] { pathToInputFolder, pathToOutputFolder + "/sumResult.txt", "Sum" };
		MyCalculatorMain.main(args);
		Integer rightSum = 59555;
		File outputFile = new File(args[1]);
		Integer calcResult = readFromFile(outputFile);
		assertEquals(rightSum, calcResult);
	}


	@Test
	public void mainForEvenMinusOdd() throws Exception {
		// evenminusodd
		String args[] = new String[] { pathToInputFolder, pathToOutputFolder + "/evenMinusOddResult.txt",
				"evenminusodd" };
		MyCalculatorMain.main(args);
		Integer rightResult = 30909;
		File outputFile = new File(args[1]);
		Integer calcResult = readFromFile(outputFile);
		assertEquals(rightResult, calcResult);

	}


	@Test
	public void mainForMean() throws Exception {
		// mean
		String argsForMax[] = new String[] { pathToInputFolder, pathToOutputFolder + "/meanResult.txt", "Mean" };
		MyCalculatorMain.main(argsForMax);
		Integer rightMean = 976;
		File outputFile = new File(argsForMax[1]);
		Integer calcResult = readFromFile(outputFile);
		assertEquals(rightMean, calcResult);

	}


	@SuppressWarnings("resource")
	private Integer readFromFile(File outputFile) throws Exception, FileNotFoundException {
		Scanner scanner = new Scanner(outputFile);
		Integer calcResult = null;
		if (scanner.hasNextInt())
			calcResult = scanner.nextInt();
		else
			throw new Exception("Wrong data in output file!");
		if (scanner.hasNext())
			throw new Exception("Wrong data in output file!");
		scanner.close();
		return calcResult;
	}

}
