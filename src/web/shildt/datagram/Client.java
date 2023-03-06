package web.shildt.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client implements Runnable{
	private DatagramSocket ds;
	private byte[] buffer;

	public Client(int clientPort, int bufferSize) {
		buffer = new byte[bufferSize];
		try {
			ds = new DatagramSocket(clientPort);
		} catch (SocketException e) {
			System.out.println("error while creating client");
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
			try {
				ds.receive(p);
				System.out.println(new String(p.getData(), 0, p.getLength()));
			} catch (IOException e) {
				System.out.println("client receiving error");
				e.printStackTrace();
			}
		}
	}
}
