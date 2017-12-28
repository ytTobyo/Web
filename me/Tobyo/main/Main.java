package me.Tobyo.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.Tobyo.web.WebFileManager;
import me.Tobyo.web.WebServerManager;

public class Main extends JavaPlugin {

	public static Main instance;
	
	private static WebServerManager webServerManager;
	
	@Override
	public void onEnable() {
		instance = this;
		webServerManager = new WebServerManager(99);
		webServerManager.start();
		new WebFileManager();
		commands();
	}

	private void commands() {

	}

	@Override
	public void onDisable() {
		webServerManager.stop();
	}


	public static Main getInstance() {
		return instance;
	}
	
	public static WebServerManager getWebServerManager() {
		return webServerManager;
	}

}
