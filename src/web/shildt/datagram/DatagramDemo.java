package web.shildt.datagram;

public class DatagramDemo {
	
	public final static int SERVER_PORT = 998;
	public final static int CLIENT_PORT = 999;
	public final static int BUFFER_SIZE = 1024;
	
	
	
	public static void main(String[] args) {
		new Thread(new Server(SERVER_PORT,BUFFER_SIZE,CLIENT_PORT)).start();
		new Thread(new Client(CLIENT_PORT,BUFFER_SIZE)).start();
	}

}
