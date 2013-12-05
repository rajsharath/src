package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	
	public int[] readFile(String path) {
		BufferedReader br = null;
		int[] arr = new int[100000];
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(path));
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				arr[i] = Integer.parseInt(sCurrentLine);
				i++;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return arr;
	}

}
