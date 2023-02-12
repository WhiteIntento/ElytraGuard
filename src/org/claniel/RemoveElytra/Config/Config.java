package org.claniel.RemoveElytra.Config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.claniel.RemoveElytra.RemoveElytra;


public class Config {
	protected FileConfiguration config;
	
	public Config(FileConfiguration config) {
		this.config=config;
		this.defineDefaultConfiguration();
	}

	public void createConfigIfNotExists() {
		File c=new File("plugins" + File.separator + RemoveElytra.PLUGIN_NAME + File.separator + "config.yml");
		if(!c.exists()) {
			this.defineDefaultConfiguration();
			RemoveElytra.getPluginInstance().saveConfig();
		}
	}
	
	public void defineDefaultConfiguration() {
		config.addDefault("DISABLE_ELYTRA_FLY", true);
		config.addDefault("DISABLE_ELYTRA_USE", false);
		config.addDefault("IF_USE_ELYTRA_REMOVE_FROM_INVENTORY", false);
		this.config.options().copyDefaults(true);
	}
}
