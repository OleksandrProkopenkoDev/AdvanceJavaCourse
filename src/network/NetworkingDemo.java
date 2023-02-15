package network;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkingDemo {

	public static void main(String[] args) {
		String url = "www.simplilearn.com";
		try {
			InetAddress inetAddress = Inet4Address.getByName(url);
			System.out.println("Address: " + Arrays.toString(inetAddress.getAddress()));
			
//			getHostAddress() method
			System.out.println("Host address: "+inetAddress.getHostAddress());
//			
			System.out.println("isAnyLocalAddress : " + inetAddress.isAnyLocalAddress());

			System.out.println("isLinkLocalAddress : " + inetAddress.isLinkLocalAddress());

			System.out.println("isLoopBackAddress : " + inetAddress.isLoopbackAddress());

			System.out.println("isSiteLocalAddress : " + inetAddress.isSiteLocalAddress());

			System.out.println("HashCode : " + inetAddress.hashCode());

			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
