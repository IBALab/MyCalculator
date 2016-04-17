package com.lab.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MySourceReader {

	public ArrayList<Integer> getAllValues (String sourceDirPath) throws FileNotFoundException{
		
		ArrayList<Integer> AllValuesList = new  ArrayList<Integer>();
		
		File sourceDir = new File(sourceDirPath);
		File[] listOfFiles = sourceDir.listFiles();
		Arrays.sort(listOfFiles);
		if (listOfFiles.length == 0)
			return AllValuesList;
		
		for (int i = 0; i < listOfFiles.length; i++) {
			File currentFile = listOfFiles[i];
			if (currentFile.isFile() && currentFile.getName().endsWith(".txt")) {
				Scanner scanner = new Scanner(currentFile);
				while(scanner.hasNextInt())
					AllValuesList.add(scanner.nextInt());
				scanner.close();
			}
		}
		return AllValuesList;
	}
}
