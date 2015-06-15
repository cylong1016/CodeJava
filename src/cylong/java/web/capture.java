package cylong.java.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author cylong
 * @version 2015年6月15日 下午9:42:35
 */
public class capture {
	
	public static void main(String[] args) {
		String URL = "http://www.baidu.com";
		BufferedReader reader = getReader(URL);
		try {
			String temp = null;
			while((temp = reader.readLine()) != null) {
				System.out.println(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到某个url的连接
	 * @param url
	 * @return HttpURLConnection
	 * @author cylong
	 * @version 2015年5月21日 下午2:33:03
	 */
	public static HttpURLConnection getConn(String url) {
		HttpURLConnection urlConn = null;
		try {
			urlConn = (HttpURLConnection)new URL(url).openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setUseCaches(true);
			urlConn.connect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlConn;
	}

	/**
	 * 得到一个url的reader 读取网页数据
	 * @param url
	 * @return BufferedReader
	 * @author cylong
	 * @version 2015年6月15日 下午9:20:04
	 */
	public static BufferedReader getReader(String url) {
		InputStream input = null;
		BufferedReader reader = null;
		HttpURLConnection urlConn = null;
		try {
			urlConn = (HttpURLConnection)new URL(url).openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setUseCaches(true);
			urlConn.connect();
			input = urlConn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reader;
	}
}
