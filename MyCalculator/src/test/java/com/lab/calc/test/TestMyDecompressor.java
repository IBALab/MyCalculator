package com.lab.calc.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import com.lab.calc.MyDecompressor;

public class TestMyDecompressor  extends org.junit.Assert {
	
	static MyDecompressor mdc;
	
	public static String pathToInputFolder = "src/test/resources";
	public static String pathToOutputFolder = pathToInputFolder + "/MyCalculatorTestResults";
	
	@BeforeClass
	public static void setUp() throws IOException {
		mdc=new MyDecompressor();
		
		
	}
	

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testTarFile () throws Exception {
		File correctFilePath = new File(pathToInputFolder+"/input_2016042020.tar");
		File outputPath = new File(pathToOutputFolder);
		List<File> ut = mdc.unTar(correctFilePath, outputPath);
		assertNotNull(ut);
	}
	
	@Test(expected = IOException.class)
	public void testWrongTarFile () throws Exception {
		File wrongFilePath = new File("wrongFilePath.tar");
		File outputPath = new File(pathToOutputFolder);
		mdc.unTar(wrongFilePath, outputPath);
	}
	
	@Test
	public void testGzFile () throws Exception {
		File correctFilePath = new File(pathToInputFolder+"/input_2016042210.tar.gz");
		File outputPath = new File(pathToOutputFolder);
		File outputFile = mdc.unGzip(correctFilePath, outputPath);
		assertNotNull(outputFile);
	}

	@Test(expected = IOException.class)
	public void testWrongGzFile () throws Exception {
		File wrongFilePath = new File("wrongFilePath.tar.gz");
		File outputPath = new File(pathToOutputFolder);
		mdc.unGzip(wrongFilePath, outputPath);
	}
	
	@Test
	public void testTarGzFile () throws Exception {
		mdc.decompressor(pathToInputFolder, pathToOutputFolder);
	}
	
}
