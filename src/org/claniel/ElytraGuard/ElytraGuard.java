package org.claniel.ElytraGuard;

import java.io.IOException;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.claniel.ElytraGuard.Commands.Reload;
import org.claniel.ElytraGuard.Config.Config;
import org.claniel.ElytraGuard.Config.DefineDefaultLocales;
import org.claniel.ElytraGuard.Listeners.PreventClickPlaceElytra;
import org.claniel.ElytraGuard.Listeners.PreventElytraFly;
import org.claniel.ElytraGuard.Listeners.RemoveElytraFromInventory;



public class ElytraGuard extends JavaPlugin {
	public static final String PLUGIN_NAME="ElytraGuard";
	protected Config configManager=null;
	
	protected static ElytraGuard pluginInstance=null;
	  @Override
	  public void onEnable() {
	    // This method is called when the plugin is enabled
	    
	    try {
			this._startPlugin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  
	  public void _startPlugin() throws IOException {
		  pluginInstance=this;
		  this.configManager= new Config(this.getConfig());
		  this.configManager.createConfigIfNotExists();
		  Directories.createDirectoriesIfNotExists();
		  DefineDefaultLocales.defineEnglishLocales();
		  this.getCommand("reload").setExecutor(new Reload());
		  this.registerListeners();
		  getLogger().info("RemoveElytra has been enabled.");
		 
		  
	  }
	  
	  
	  public void registerListeners() {
		  if(this.getConfig().getBoolean("DISABLE_ELYTRA_FLY")) {
			  getServer().getPluginManager().registerEvents(new PreventElytraFly(), this);
		  }
		  if(this.getConfig().getBoolean("DISABLE_ELYTRA_USE")) {
			  getServer().getPluginManager().registerEvents(new PreventClickPlaceElytra(), this);
		  }
		  if(this.getConfig().getBoolean("IF_USE_ELYTRA_REMOVE_FROM_INVENTORY")) {
			  getServer().getPluginManager().registerEvents(new RemoveElytraFromInventory(), this);
		  }
	  }
	  
	  public void unregisterAllListeners() {
		  HandlerList.unregisterAll(this);
	  }
	  
	  public void _stopPlugin() {
		  this.unregisterAllListeners();
	  }

	



  public void onDisable() {
    // This method is called when the plugin is disabled
    getLogger().info("RemoveElytra has been disabled.");
  }
  
  public static ElytraGuard getPluginInstance() {
	  return pluginInstance;
  }

}

