package MySourceReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MySourceReader {

	public ArrayList<Integer> getAllValues (String sourceDirPath) throws FileNotFoundException{
		
		ArrayList<Integer> AllValuesList=new  ArrayList<Integer>();
		
		File folder = new File(sourceDirPath);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length==0)
			return AllValuesList;
		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		if (file.isFile() && file.getName().endsWith(".txt")) {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextInt())
				AllValuesList.add(scanner.nextInt());
		  }
		}

		return AllValuesList;
	}
}
