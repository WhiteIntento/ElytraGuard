package org.claniel.ElytraGuard.Config;

import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.claniel.ElytraGuard.Directories;


public class Locale {

	protected String locale;
	protected ConfigHandler configHandler;
	public Locale(String locale) throws IOException {
		this.locale=locale;
		configHandler= new ConfigHandler(Directories.localeDirectory,locale);
	}
	
	public String get(String key) {
		return configHandler.getConfig().getString(key);
	}
	
	public void set(String key, Object value) {
		this.configHandler.getConfig().set(key, value);
	}
	
	public YamlConfiguration getConfig() {
		return configHandler.getConfig();
	}
	
	public ConfigHandler getConfigHandler() {
		return configHandler;
	}
}
