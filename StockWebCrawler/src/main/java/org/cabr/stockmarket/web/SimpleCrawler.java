package org.cabr.stockmarket.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SimpleCrawler {

	public boolean parse(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean downloadFile(String url) {
		
		try {
			URL file = new URL(url);
			InputStream inStr = file.openConnection().getInputStream();
			BufferedInputStream bufInStr = new BufferedInputStream(inStr);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	public String parse(String baseurl, String... strings) {

		baseurl = validateBaseUrl(baseurl);

		StringBuilder concatenatedURL = new StringBuilder(baseurl);

		concatenatedURL.append(strings[0]);
		
		if (strings.length > 3) {
			try{
			int dateFrom = Integer.parseInt(strings[1]);
			int dateTo = Integer.parseInt(strings[2]);
			checkDateOrder(dateFrom, dateTo, strings);
			concatenatedURL.append("&d1=");
			concatenatedURL.append(strings[1]);
			concatenatedURL.append("&d2=");
			concatenatedURL.append(strings[2]);
			}
			catch (NumberFormatException e){
				
			}
		}
		concatenatedURL.append("&i=");
		if (strings.length > 3) {				
			concatenatedURL.append(strings[3]);
			concatenatedURL.append("&o=");
			concatenatedURL.append(strings[4]);
		}
		else {	
			concatenatedURL.append(strings[1]);	
			concatenatedURL.append("&o=");
			concatenatedURL.append(strings[2]);
		}
				
		return concatenatedURL.toString();
	}

	private String validateBaseUrl(String baseurl) {
		baseurl.trim();
		if (baseurl.startsWith("http://")) {
			if (baseurl.endsWith("/")) {
				baseurl = baseurl + "q/d/l/?s=";
			} else {
				baseurl = baseurl + "/q/d/l/?s=";
			}
		} else {
			if (baseurl.endsWith("/")) {
				baseurl ="http://" + baseurl + "q/d/l/?s=";
			} else {
				baseurl ="http://" + baseurl + "/q/d/l/?s=";
			}
		}
		return baseurl;
	}

	private void checkDateOrder(int dateFrom, int dateTo, String[] strings) {
		if (dateFrom > dateTo) {
			String temp = strings[1];
			strings[1] = strings[2];
			strings[2] = temp;
		}
		
	}

}
