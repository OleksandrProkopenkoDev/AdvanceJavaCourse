package web.shildt.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server implements Runnable{

	private DatagramSocket ds;
	private int clientPort;
	private byte[] buffer;
	
	public Server(int serverPort, int bufferSize, int clientPort) {
		buffer = new byte[bufferSize];
		this.clientPort = clientPort;
		try {
			ds = new DatagramSocket(serverPort);
		} catch (SocketException e) {
			System.out.println("error while creating server");
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		int pos = 0;
		while(true) {
			try {
				int c = System.in.read();
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
