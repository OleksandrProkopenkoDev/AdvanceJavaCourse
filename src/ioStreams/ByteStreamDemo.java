package ioStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

	public static void main(String[] args) {
		FileInputStream inputStream = null;
		FileOutputStream outStream = null;
		try {
			inputStream = new FileInputStream("look1.mp4");
			outStream = new FileOutputStream("newByteLook.mp4");
			
			int content;
		
			// reads a byte at a time, if it reached end of the file, returns -1
			while ((content = inputStream.read()) != -1) {

				outStream.write(content);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
