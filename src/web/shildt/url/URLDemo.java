package web.shildt.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://herbschild.com/articles");
			System.out.println("protocol: "+url.getProtocol());
			System.out.println("port: "+url.getPort());
			System.out.println("host: "+url.getHost());
			System.out.println("file: "+url.getFile());
			System.out.println("full form "+ url.toExternalForm());
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}

}
