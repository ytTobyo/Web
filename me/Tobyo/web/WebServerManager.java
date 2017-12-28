package me.Tobyo.web;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpsServer;

public class WebServerManager {

	private HttpsServer server;

	public WebServerManager(int port) {
		try {
			server = HttpsServer.create(new InetSocketAddress(port), 0);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void start() {
		server.start();
	}

	public void stop() {
		server.stop(0);

	}

	public HttpsServer getServer() {
		return server;
	}
}
