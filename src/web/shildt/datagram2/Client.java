package web.shildt.datagram2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {
	private DatagramSocket ds;
	private byte[] buffer = new byte[1024];

	public static void main(String[] args) {
		new Client().run();
	}

		
	public void run() {
		try {
			ds = new DatagramSocket(999);
		} catch (SocketException e) {
			System.out.println("error while creating client");
			e.printStackTrace();
		}
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
