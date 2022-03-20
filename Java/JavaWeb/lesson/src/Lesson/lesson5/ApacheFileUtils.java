package com.lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ApacheFileUtils {

	public static void main(String[] args) {
		try {
			File f1 = new File("loremipsum.txt");
			File f2 = new File("target.txt");
			
//			InputStream in = new FileInputStream(f1);
//			OutputStream out = new FileOutputStream(f2);
//			
//			byte[] buf = new byte[1024];
//			int len;
//			while ((len = in.read(buf)) > 0) {
//				out.write(buf, 0, len);
//			}
//			
//			in.close();
//			out.close();
			
			FileUtils.copyFile(f1, f2);
			System.out.println("File copied!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
