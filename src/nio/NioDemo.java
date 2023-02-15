package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("characters.txt");
		FileChannel readChannel = fin.getChannel();
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		int result = readChannel.read(readBuffer);
		System.out.println("file read successfully "+result);
		
		FileOutputStream fout = new FileOutputStream("nioCharacters.txt");
		FileChannel writeChannel = fout.getChannel();
		ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
		String message = "this is a test string";
		writeBuffer.put(message.getBytes());
		writeBuffer.flip();
		result = writeChannel.write(writeBuffer);
		writeBuffer.clear();
		
		result = writeChannel.write(writeBuffer);
		System.out.println("new file successfully writen " + result);
	}

}
