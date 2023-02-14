package ioStreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {

	public static void main(String[] args) {
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader("characters.txt");
			writer = new FileWriter("newcharactersfile.txt");
			// reading source file and writing content to target file character by character
			int content;
			while ( (content = reader.read()) != -1) {
				writer.append((char)content);					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
