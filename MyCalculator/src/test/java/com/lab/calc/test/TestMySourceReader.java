package com.lab.calc.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.lab.calc.MySourceReader;

public class TestMySourceReader {
	static MySourceReader msr;

	
	@ClassRule
	public static TemporaryFolder tempFolder = new TemporaryFolder(new File("/tmp"));
	   
	
	@BeforeClass
	public static void setUp() throws IOException {
		
		msr=new MySourceReader();
		File fileTxtValid1 = tempFolder.newFile("file1.txt");
		File fileTxtValid2 = tempFolder.newFile("file2.txt");
		File fileDocInvalid = tempFolder.newFile("file3.doc");
		File fileNoExtInvalid = tempFolder.newFile("file4");
		tempFolder.newFolder("subfolder");
		File fileInSubDirInvalid = tempFolder.newFile("subfolder/file5.txt");
		
		FileWriter fileWriter = new FileWriter(fileTxtValid1);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(1 + "\n" + 1 + "\n" + 1);
		printWriter.close();
		
		fileWriter = new FileWriter(fileTxtValid2);
		printWriter = new PrintWriter(fileWriter);
		printWriter.println(2 + "\n" + 2 + "\n" + 2);
		printWriter.close();

		
		fileWriter = new FileWriter(fileDocInvalid);
		printWriter = new PrintWriter(fileWriter);
		printWriter.println(3 + "\n" + 3 + "\n" + 3);
		printWriter.close();
		
		fileWriter = new FileWriter(fileNoExtInvalid);
		printWriter = new PrintWriter(fileWriter);
		printWriter.println(4 + "\n" + 4 + "\n" + 4);
		printWriter.close();
		
		fileWriter = new FileWriter(fileInSubDirInvalid);
		printWriter = new PrintWriter(fileWriter);
		printWriter.println(5 + "\n" + 5 + "\n" + 5);
		printWriter.close();		
	}
	

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void getAllValues () throws FileNotFoundException{
		ArrayList<Integer> AllValuesList = new  ArrayList<Integer>();
		AllValuesList.add(2);
		AllValuesList.add(2);
		AllValuesList.add(2);
		AllValuesList.add(1);
		AllValuesList.add(1);
		AllValuesList.add(1);
		assertEquals(msr.getAllValues(tempFolder.getRoot().toString()), AllValuesList);
	}
}
