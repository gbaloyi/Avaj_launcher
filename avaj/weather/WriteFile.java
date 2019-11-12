package avaj.weather;

import	java.io.*;

public class WriteFile {
	private static WriteFile writefile = null;
	private static BufferedWriter bw = null;
	private static File file = null;
	private static FileWriter fw = null;
	private WriteFile() {
	}

	public static WriteFile	getWriteFile() {
		if (writefile == null) {
			try{
				writefile = new WriteFile();
				file = new File("sim.txt");
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
			} catch (IOException ioe) {}
		}
		return writefile;
	}

	public void	writetofile(String str) {
		try {

			bw.write(str);
			bw.newLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void close() {
		try {
			if ( bw != null)
				bw.close();
		} catch (Exception ex) {
			System.out.println("Error in closing the BufferedWriter"+ex);
		}
	}
}