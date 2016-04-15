package MySourceReader;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestMySourceReader {
	static MySourceReader msr;

	@ClassRule
	public static TemporaryFolder tempFolder = new TemporaryFolder(new File("/tmp/decompressed"));
	   
	@BeforeClass
	public static void setUp() throws IOException {
		
		msr=new MySourceReader();
		File filetxt1=tempFolder.newFile("file1.txt");
		File filetxt2=tempFolder.newFile("file2.txt");
		File filedoc3=tempFolder.newFile("file3.doc");
		File file4=tempFolder.newFile("file4");
		File subfolder = tempFolder.newFolder("subfolder");
		File sffiletxt5=tempFolder.newFile("subfolder/file5.txt");
		
		FileWriter fwriter=new FileWriter(filetxt1);
		PrintWriter pwriter=new PrintWriter(fwriter);
		pwriter.println(1+"\n"+1+"\n"+1);
		pwriter.close();
		
		fwriter=new FileWriter(filetxt2);
		pwriter=new PrintWriter(fwriter);
		pwriter.println(2+"\n"+2+"\n"+2);
		pwriter.close();

		
		fwriter=new FileWriter(filedoc3);
		pwriter=new PrintWriter(fwriter);
		pwriter.println(3+"\n"+3+"\n"+3);
		pwriter.close();
		
		fwriter=new FileWriter(file4);
		pwriter=new PrintWriter(fwriter);
		pwriter.println(4+"\n"+4+"\n"+4);
		pwriter.close();
		
		fwriter=new FileWriter(sffiletxt5);
		pwriter=new PrintWriter(fwriter);
		pwriter.println(5+"\n"+5+"\n"+5);
		pwriter.close();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getAllValues () throws FileNotFoundException{
		ArrayList<Integer> AllValuesList=new  ArrayList<Integer>();
		AllValuesList.add(1);
		AllValuesList.add(1);
		AllValuesList.add(1);
		AllValuesList.add(2);
		AllValuesList.add(2);
		AllValuesList.add(2);
		assertEquals(msr.getAllValues(tempFolder.getRoot().toString()),AllValuesList);
	}

}
