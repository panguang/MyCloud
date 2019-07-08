package com.fuse.KeyStone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

public class keystone {
	public static String ValidationGet(String url, String user, String password) throws IOException {
		URL urladress = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) urladress.openConnection();
		String authString = user + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		connection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		connection.setRequestProperty("accept", "application/json");

		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3642.0 Safari/537.36");

		InputStream is = connection.getInputStream();

		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = "";
		while ((str = br.readLine()) != null) {
			sb.append(str + "\n");
			System.out.println(str);
		}

		is.close();

		connection.disconnect();

		return sb.toString();
	}

	public static String ValidationPost(String url, String user, String password, String data) throws IOException {
		URL urladress = new URL(url);
		PrintWriter out = null;
		HttpURLConnection connection = (HttpURLConnection) urladress.openConnection();
		String authString = user + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		connection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3642.0 Safari/537.36");

		connection.setRequestProperty("Content-Type", "application/json");

		connection.setDoOutput(true);
		connection.setDoInput(true);

		out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "utf-8"));

		out.print(data);

		out.flush();

		InputStream is = connection.getInputStream();

		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str = "";
		while ((str = br.readLine()) != null) {
			sb.append(str + "\n");
			System.out.println(str);
		}

		is.close();
		out.close();

		connection.disconnect();

		return sb.toString();
	}
}
