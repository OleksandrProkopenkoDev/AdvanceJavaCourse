package web.shildt.url;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionDemo {

	public static void main(String[] args) throws Exception {
		int c;
		URL url = new URL("http://www.google.com");
		URLConnection urlCon = url.openConnection();
		long d = urlCon.getDate();
		if(d==0) {
			System.out.println("No date");
		}else {
			System.out.println("current date "+ new Date(d));
		}
		System.out.println("getContentType: "+urlCon.getContentType());
		d = urlCon.getExpiration();
		if(d==0) {
			System.out.println("No date expiration");
		}else {
			System.out.println("expiration date "+ new Date(d));
		}
		d = urlCon.getLastModified();
		if(d==0) {
			System.out.println("No date modification");
		}else {
			System.out.println("last modified date "+ new Date(d));
		}
		long len = urlCon.getContentLengthLong();
		if(len==0) {
			System.out.println("content length not available");
		}else {
			System.out.println("lcontent length "+ len);
		}
		if(len!=0) {
			System.out.println("-----------content-----------");
			InputStream in = urlCon.getInputStream();
			while( (c=in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
		}else {
			System.out.println("content not available");
		}
		
	}

}
