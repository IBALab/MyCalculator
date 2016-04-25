package com.lab.calc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class MyDecompressor {

	public List<File> unTar(File inputFile, File outputDir)
			throws FileNotFoundException, IOException, ArchiveException {

		List<File> untaredFiles = new LinkedList<File>();
		InputStream is = new FileInputStream(inputFile);
		TarArchiveInputStream debInputStream = (TarArchiveInputStream) new ArchiveStreamFactory()
				.createArchiveInputStream("tar", is);
		TarArchiveEntry entry = null;
		while ((entry = (TarArchiveEntry) debInputStream.getNextEntry()) != null) {
			File outputFile = new File(outputDir, entry.getName());
			if (entry.isDirectory()) {
				if (!outputFile.exists()) {
					if (!outputFile.mkdirs()) {
						throw new IllegalStateException(
								String.format("Couldn't create directory %s.", outputFile.getAbsolutePath()));
					}
				}
			} else {
				OutputStream outputFileStream = new FileOutputStream(outputFile);
				IOUtils.copy(debInputStream, outputFileStream);
				outputFileStream.close();
			}
			untaredFiles.add(outputFile);
		}
		debInputStream.close();

		return untaredFiles;
	}

	public File unGzip(File inputFile, File outputDir) throws FileNotFoundException, IOException {

		File outputFile = new File(outputDir, inputFile.getName().substring(0, inputFile.getName().length() - 3));

		GZIPInputStream in = new GZIPInputStream(new FileInputStream(inputFile));
		FileOutputStream out = new FileOutputStream(outputFile);

		IOUtils.copy(in, out);

		in.close();
		out.close();

		return outputFile;
	}

	public void decompressor(String sourceDirPath, String targetDirPath)
			throws FileNotFoundException, IOException, ArchiveException {
		File sourceDir = new File(sourceDirPath);
		File targetDir = new File(targetDirPath);
		File[] listOfFiles = sourceDir.listFiles();
		Arrays.sort(listOfFiles);
		MyDecompressor datz = new MyDecompressor();
		for (int i = 0; i < listOfFiles.length; i++) {
			File currentInputFile = listOfFiles[i];
			if (currentInputFile.isFile() && currentInputFile.getName().endsWith(".tar.gz")) {
				datz.unTar(datz.unGzip(currentInputFile, targetDir), targetDir);
			}
		}
		File[] listOfFilesTargetFolder = targetDir.listFiles();
		Arrays.sort(listOfFilesTargetFolder);
		for (int i = 0; i < listOfFilesTargetFolder.length; i++) {
			File targetTarFile = listOfFilesTargetFolder[i];
			try {
				if (targetTarFile.isFile() && targetTarFile.getName().endsWith(".tar")) {
					targetTarFile.delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
