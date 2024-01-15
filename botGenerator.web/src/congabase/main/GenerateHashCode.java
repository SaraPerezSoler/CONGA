package congabase.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateHashCode {
//	private static final String INPUT_URI = "D:\\Desktop\\ValidationSetup-main\\Rasa";
//	private static final String LOG_FILE = "D:\\Desktop\\ValidationSetup-main\\hashCodeR.txt";

	private static final String INPUT_URI = "D:\\Desktop\\ValidationSetup-main\\Dialogflow";
	private static final String LOG_FILE = "D:\\Desktop\\ValidationSetup-main\\hashCodeD.txt";

	private static final String[] IGNORE_FILES = { "D:/Git/asymob/chatbots/botsInDSL" };
	private FileWriter outputWriter;

	public static void main(String[] args) {

		GenerateHashCode generateHashCode = null;
		try {
			generateHashCode = new GenerateHashCode(LOG_FILE);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File inputFile = new File(INPUT_URI);

		List<File> files = new ArrayList<File>();
		files.add(inputFile);

		while (!files.isEmpty()) {
			File f = files.get(0);
			boolean flag = false;
			for (String ignore : IGNORE_FILES) {
				if (extract(f.getAbsolutePath(), "").equals(ignore)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				files.remove(f);
				continue;
			}
			if (f.isDirectory()) {
				for (File f1 : f.listFiles()) {
					files.add(f1);
				}
			} else if (f.getName().endsWith(".bot") || f.getName().endsWith(".BOT")) {
				try {
					String name = f.getName().replace(".bot", "").replace(".BOT", "");
					if (name.equals("Date")) {
						System.out.println("Date");
					}
					String string = generateHashCode.readString(f.getAbsolutePath());
					generateHashCode.printIssues(name, string.hashCode());
				} catch (Exception e) {
					e.printStackTrace();
					// System.out.println("Error in " + f.getName());
				}
			}

			files.remove(f);
		}
		try {
			generateHashCode.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static String extract(String s, String extract) {
		return s.substring(extract.length()).replaceAll("\\\\", "/");
	}

	public GenerateHashCode(String outputFile) throws IOException {

		File output = new File(outputFile);
		output.createNewFile();
		this.outputWriter = new FileWriter(output);
	}

	public String readString(String string) {
		String text = "";
		try {
			File myObj = new File(string);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				text += data +"\n";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return text;
	}

	public void printIssues(String name, int hashcode) throws IOException {
			this.outputWriter.write(name + "\t"+hashcode+"\n");

	}

	public void close() throws IOException {
		this.outputWriter.close();
	}
}
