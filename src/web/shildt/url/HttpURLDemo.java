package web.shildt.url;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.google.com");
			HttpURLConnection urlCon = 
					(HttpURLConnection)url.openConnection();
			System.out.println("request method: "+urlCon.getRequestMethod());
			System.out.println("response code: "+urlCon.getResponseCode());
			System.out.println("response message: "+urlCon.getResponseMessage());
			Map<String, List<String>> hdrMap = urlCon.getHeaderFields();
			Set<String> hdrField = hdrMap.keySet();
			System.out.println("this is a header: ");
			for (String key : hdrField) {
				System.out.println("Key: "+key+ "  Value: "+hdrMap.get(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
