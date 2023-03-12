package org.claniel.ElytraGuard;

import java.io.File;

public class Directories {

	public final static String pluginsDirectory = "plugins";
	public final static String pluginDirectory = Directories.pluginsDirectory + File.separator +  ElytraGuard.PLUGIN_NAME;
	public final static String localeDirectory = pluginDirectory + File.separator + "locales";
	
	public static void createDirectoriesIfNotExists() {
		File pd= new File(pluginDirectory);
		if(!pd.exists()) {
			pd.mkdirs();
		}
		File ld = new File(localeDirectory);
		if(!ld.exists()) {
			ld.mkdir();
		}
	}
}
