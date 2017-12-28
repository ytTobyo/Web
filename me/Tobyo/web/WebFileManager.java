package me.Tobyo.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import me.Tobyo.main.Main;

public class WebFileManager implements HttpHandler {

	public WebFileManager() {
		load();
	}

	public void load() {
		File dir = new File(Main.getInstance().getDataFolder() + "//webpages//");
		if (!dir.getParentFile().exists()) {
			dir.getParentFile().mkdirs();
		}
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (!files[i].isDirectory()) {
					Main.getWebServerManager().getServer().createContext("/" + files[i].getName(), this);
				}
			}
		}
	}

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		String response = FileUtils.getFileContents(httpExchange.getRequestURI().toString());
		httpExchange.sendResponseHeaders(200, response.length());
		OutputStream outputStream = httpExchange.getResponseBody();
		outputStream.write(response.getBytes());
		outputStream.close();
	}
}
