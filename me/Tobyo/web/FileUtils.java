package me.Tobyo.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import me.Tobyo.main.Main;

public class FileUtils {

	public static String getFileContents(String filename) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Main.getInstance().getDataFolder() + "//webpages/" + filename));
			StringBuilder stringBuilder = new StringBuilder();
			String line = bufferedReader.readLine();
			while (line != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
			return stringBuilder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "<h1>Error!</h1>";
	}

}
