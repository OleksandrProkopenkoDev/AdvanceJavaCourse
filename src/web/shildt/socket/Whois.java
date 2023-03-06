package web.shildt.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {

	public static void main(String[] args) {
		try {
			int c;
//			create socket connection with internic.net
//			port 43
			Socket s = new Socket("whois.internic.net", 43);
			System.out.println("1");
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			String str = "f.com";
			
			byte[] buf = str.getBytes();
			out.write(buf);
			Thread.sleep(1000);
			System.out.println("2");
			while( (c = in.read()) != -1) {
				System.out.println("while");
				System.out.println((char)c);
			}
			s.close();
			
		}catch (Exception e) {
			System.out.println("error ");
			e.printStackTrace();
			
		}
	}

}
