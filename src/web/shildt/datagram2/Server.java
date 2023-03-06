package web.shildt.datagram2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

	private DatagramSocket ds;
	private final int clientPort = 999;
	private final int serverPort = 998;
	private byte[] buffer = new byte[1024];

	public static void main(String[] args) {
		new Server().run();
	}
	
	public void run() {
		try {
			ds = new DatagramSocket(serverPort);
		} catch (SocketException e) {
			System.out.println("error while creating server");
			e.printStackTrace();
		}
		int pos = 0;
		while(true) {
			try {
				int c = System.in.read();
				System.out.println("input: "+ (char)c);
				switch(c) {
				case -1 :
					System.out.println("server shut down");
					ds.close();
					return;
				case'\r':
					
					break;
				case'\n':
					ds.send(new DatagramPacket(buffer, pos,
							InetAddress.getLocalHost(), clientPort));
					pos = 0;
					System.out.println("message sent");
					break;
				default:
					buffer[pos++] = (byte)c;
				}
			} catch (IOException e) {
				System.out.println("error while reading system input");
				e.printStackTrace();
			}
		}
	}

	
	
}
