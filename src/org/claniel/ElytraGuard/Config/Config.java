package org.claniel.ElytraGuard.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.claniel.ElytraGuard.ElytraGuard;


public class Config {
	protected FileConfiguration config;
	
	public Config(FileConfiguration config) {
		this.config=config;
		this.defineDefaultConfiguration();
	}

	public void createConfigIfNotExists() {
		File c=new File("plugins" + File.separator + ElytraGuard.PLUGIN_NAME + File.separator + "config.yml");
		if(!c.exists()) {
			this.defineDefaultConfiguration();
			ElytraGuard.getPluginInstance().saveConfig();
		}
	}
	
	public void defineDefaultConfiguration() {
		config.addDefault("DISABLE_ELYTRA_FLY", true);
		config.addDefault("DISABLE_ELYTRA_USE", false);
		config.addDefault("IF_USE_ELYTRA_REMOVE_FROM_INVENTORY", false);
		config.addDefault("DEFAULT_LOCALE", "en");
		config.addDefault("MESSAGE_TITLE", "&e[&5ElytraGuard&e] ");
		List<String> worlds = new ArrayList<String>();
		worlds.add("world_the_end");
		config.addDefault("DISABLED_WORLDS", worlds);
		this.config.options().copyDefaults(true);
	}
}
