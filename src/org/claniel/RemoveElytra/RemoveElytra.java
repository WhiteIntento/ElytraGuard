package org.claniel.RemoveElytra;

import org.bukkit.plugin.java.JavaPlugin;
import org.claniel.RemoveElytra.Config.Config;
import org.claniel.RemoveElytra.Listeners.PreventClickPlaceElytra;
import org.claniel.RemoveElytra.Listeners.PreventElytraFly;
import org.claniel.RemoveElytra.Listeners.RemoveElytraFromInventory;

public class RemoveElytra extends JavaPlugin {
	public static final String PLUGIN_NAME="RemoveElytra";
	protected Config configManager=null;
	
	protected static RemoveElytra pluginInstance=null;
	  @Override
	  public void onEnable() {
	    // This method is called when the plugin is enabled
	    
	    pluginInstance=this;
	    this._startPlugin();
	  }
	  
	  
	  public void _startPlugin() {
		  this.configManager= new Config(this.getConfig());
		  this.configManager.createConfigIfNotExists();
		  getLogger().info("RemoveElytra has been enabled.");
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

	



  public void onDisable() {
    // This method is called when the plugin is disabled
    getLogger().info("RemoveElytra has been disabled.");
  }
  
  public static RemoveElytra getPluginInstance() {
	  return pluginInstance;
  }

}

