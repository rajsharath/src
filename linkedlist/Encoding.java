package linkedlist;

import java.io.UnsupportedEncodingException;

public class Encoding {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String x = "漢字";
		String c = Character.toString(x.charAt(0));
		System.out.println(c.codePointAt(0));
		byte[] asciiByte = x.getBytes();
		System.out.println(new String(asciiByte, "cp1252"));
		System.out.println(System.getProperty("file.encoding"));
	}
	}
