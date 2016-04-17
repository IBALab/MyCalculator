package com.lab.calc;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyCalculatorMain {

	public static void main(String[] args) {
				
		if (args.length == 3){
			String pathToInputFolder = args[0].trim();
			String pathToOutputFolder = args[1].trim();
			String mathOperation = args[2].trim().toLowerCase();
			
			MyDecompression(pathToInputFolder);
			ArrayList<Integer> allValuesList = null;
			try {
				allValuesList = MySourceReading(pathToInputFolder+"/decompressed");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Integer result = null;
			try {
				result = MyMathDoing(allValuesList,mathOperation);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				MyResultWriter(result,pathToOutputFolder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else System.out.println("Wrong number of parameters!");

	}
	
	
	public static void MyDecompression(String pathToInputFolder){
		//MyDecompressor md = new MyDecompressor();
		//md.decompressAllTarGz(pathToInputFolder);
	}
	
	
	public static ArrayList<Integer> MySourceReading(String pathToInputFolder) throws FileNotFoundException{
		MySourceReader msr = new MySourceReader();
		return msr.getAllValues(pathToInputFolder);
	}
	
	
	public static Integer MyMathDoing(ArrayList<Integer> allValuesList,String mathOperation) throws Exception {
		MyMath mm = new MyMath();
		Integer resultValue = null;
		switch (mathOperation){
			case "sum" : resultValue = mm.sum(allValuesList) ; break;
			case "min" : resultValue = mm.min(allValuesList) ; break;
			case "max" : resultValue = mm.max(allValuesList) ; break;
			case "evenminusodd" : resultValue = mm.EvenMinusOdd(allValuesList) ; break;
			case "mean" : resultValue = mm.Mean(allValuesList) ; break;
			default : throw new  Exception ("Invalid math operation") ;
		}
		return resultValue;
	}
	
	
	private static void MyResultWriter(Integer result, String pathToOutputFolder) throws IOException {
		FileWriter fileWriter = new FileWriter(pathToOutputFolder);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(result);
		printWriter.close();
	}
	

}
