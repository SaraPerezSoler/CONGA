package zipUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
	private FileOutputStream fos;
	private ZipOutputStream zos;

	public Zip(String path, String name) {

		try {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}else {
				if (!file.isDirectory()) {
					file.mkdirs();
				}
			}
			fos = new FileOutputStream(path + "/" + name + ".zip");
			zos = new ZipOutputStream(new BufferedOutputStream(fos));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*public void addFile(String path, String fileName) {
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
	}*/
	public void addFile(String fileName, InputStream input) {
		try {
			ZipEntry zipEntry = new ZipEntry(fileName);
			zos.putNextEntry(zipEntry);

			byte[] bytes = input.readAllBytes();
			int length = bytes.length;
			zos.write(bytes, 0, length);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*public void addFileToFolder(String path, String folderName, String fileName) {
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
	}*/
	public void addFileToFolder(String folderName, String fileName, InputStream input) {
		try {
			ZipEntry zipEntry = new ZipEntry(folderName+"/"+fileName);
			zos.putNextEntry(zipEntry);
			byte[] bytes = input.readAllBytes();
			int length = bytes.length;
			zos.write(bytes, 0, length);

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
