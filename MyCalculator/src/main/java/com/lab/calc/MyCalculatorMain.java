package com.lab.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.compress.archivers.ArchiveException;

public class MyCalculatorMain {

	public static void main(String[] args) throws Exception {

		if (args.length == 3) {
			String pathToInputFolder = args[0].trim();
			String pathToOutputFolder = args[1].trim();
			String mathOperation = args[2].trim().toLowerCase();

			String pathToOutputTarGz = pathToInputFolder + "/" + "decompressed";
			new File(pathToOutputTarGz).mkdir();
			MyDecompression(pathToInputFolder, pathToOutputTarGz);
			ArrayList<Integer> allValuesList = MySourceReading(pathToOutputTarGz);
			Integer result = null;
			try {
				result = MyMathDoing(allValuesList, mathOperation);
			} catch (Exception e) {
				e.printStackTrace();
			}

			MyResultWriter(result, pathToOutputFolder);
		} else
			throw new Exception("Wrong number of parameters!");

	}


	public static void MyDecompression(String pathToInputFolder, String pathToOutputFolder) {
		MyDecompressor md = new MyDecompressor();
		try {
			md.decompressor(pathToInputFolder, pathToOutputFolder);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArchiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static ArrayList<Integer> MySourceReading(String pathToInputFolder) {
		MySourceReader msr = new MySourceReader();
		try {
			return msr.getAllValues(pathToInputFolder);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public static Integer MyMathDoing(ArrayList<Integer> allValuesList, String mathOperation) throws Exception {
		MyMath mm = new MyMath();
		Integer resultValue = null;
		switch (mathOperation) {
		case "sum":
			resultValue = mm.sum(allValuesList);
			break;
		case "min":
			resultValue = mm.min(allValuesList);
			break;
		case "max":
			resultValue = mm.max(allValuesList);
			break;
		case "evenminusodd":
			resultValue = mm.EvenMinusOdd(allValuesList);
			break;
		case "mean":
			resultValue = mm.Mean(allValuesList);
			break;
		default:
			throw new Exception("Invalid math operation");
		}
		return resultValue;
	}


	private static void MyResultWriter(Integer result, String pathToOutputFolder) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(pathToOutputFolder);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(result);
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
