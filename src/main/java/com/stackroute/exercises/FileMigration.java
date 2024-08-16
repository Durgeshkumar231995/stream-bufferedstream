package com.stackroute.exercises;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMigration {

	// Write here logic to read content of first file and write it in second file
	String readingFromfirstFile = "";

	public String fileContentDuplicator(String firstFile, String secondFile) throws IOException {
		
		if (firstFile == null || firstFile.isBlank() || firstFile.isEmpty() || secondFile == null
				|| secondFile.isBlank() || secondFile.isEmpty()) {
			return "Given fileName to read or write is empty, null or blank space";
		}

		String ff = firstFile.trim();
		String sf = secondFile.trim();

		try (BufferedInputStream BIS = new BufferedInputStream(new FileInputStream(ff))) {

			int byteData;
			// bytes reading from BIS
			while ((byteData = BIS.read()) != -1) {
				
				readingFromfirstFile += (char) byteData;
				System.out.print((char) byteData);
			}
			
			BufferedOutputStream BOS = new BufferedOutputStream(new FileOutputStream(sf));
			BOS.write(readingFromfirstFile.getBytes());
			BOS.flush();

		} catch (IOException e) {
			throw new IOException();
		}

		return readingFromfirstFile;
	}
}
