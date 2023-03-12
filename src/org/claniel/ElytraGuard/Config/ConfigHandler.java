package org.claniel.ElytraGuard.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.claniel.ElytraGuard.Directories;


public class ConfigHandler {
	protected File configFile;
	protected YamlConfiguration config;
	protected String fileExtension ="yml";
	public ConfigHandler(String filename) throws IOException {
		configFile=new File(Directories.pluginDirectory,filename + "." + this.fileExtension);
		this.defineConfig(configFile);
	}
	
	public ConfigHandler(String directory, String filename) throws IOException {
		this.defineConfig(directory, filename);
	}
	
	public void defineConfig(File configFile) throws IOException {
		this.configFile=configFile;
		config = YamlConfiguration.loadConfiguration(configFile);
		if(!configFile.exists()) {
			configFile.createNewFile();
		}
	}
	
	public void defineConfig(String directory, String filename) throws IOException {
		configFile=new File(directory,filename + "." + this.fileExtension );
		defineConfig(configFile);
	}
	
	
	public File getConfigFile() {
		return configFile;
	}


	public void setConfigFile(File configFile) {
		this.configFile = configFile;
	}


	public YamlConfiguration getConfig() {
		return config;
	}


	public void setConfig(YamlConfiguration config) {
		this.config = config;
	}
	
	public void save() throws IOException {
		this.config.save(configFile);
	}
}
