package no.hvl.dat110.appexample;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;



public class SimpleHTTPClient {

	public static void main(String[] args) throws Exception {

		System.out.print("URL:> ");

		Scanner scanner = new Scanner(System.in);
		String url = scanner.nextLine();

		URL urlobj = new URI(url).toURL();  
		HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		if (responseCode == HttpURLConnection.HTTP_OK) { // status code 200

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}

			in.close();
		}

		scanner.close();
		con.disconnect();

	}
}
