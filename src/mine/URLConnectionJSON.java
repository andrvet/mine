package mine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.rmi.CORBA.Util;

import org.json.simple.JSONObject;


public class URLConnectionJSON {

	public static void main(String[] args)  {
		
		

		//see: http://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html

			
		String requestURL = "https://en.wikipedia.org/w/api.php?action=query&prop=categories&format=json&clshow=!hidden&cllimit=10&titles=New%20York";
		 
		try {
			URL	wikiRequest = new URL(requestURL);
			URLConnection connection;
			connection = wikiRequest.openConnection();
			connection.setDoOutput(true);  
			 
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 Scanner scanner = new Scanner(wikiRequest.openStream());
			 String response = scanner.useDelimiter("\\Z").next();
			 //JSONObject json = Util.parseJson(response);
			 scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 

		 
		

		 
	}

}
