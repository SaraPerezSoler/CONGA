package org.xtext.botGenerator.generator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZip {
	private FileOutputStream fos;
	private ZipOutputStream zos;

	public CreateZip(String path, String name) {

		try {
			fos = new FileOutputStream(path + "/" + name + ".zip");
			zos = new ZipOutputStream(new BufferedOutputStream(fos));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void addFile(String path, String fileName) {
		try {
			String srcFile = path + "/" + fileName;

			File fileToZip = new File(srcFile);
			FileInputStream fis;

			fis = new FileInputStream(fileToZip);

			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addFileToFolder(String path, String folderName, String fileName) {
		try {
			String srcFile = path + "/" + fileName;

			File fileToZip = new File(srcFile);
			FileInputStream fis;

			fis = new FileInputStream(fileToZip);

			ZipEntry zipEntry = new ZipEntry(folderName+"/"+fileToZip.getName());
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			zos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
