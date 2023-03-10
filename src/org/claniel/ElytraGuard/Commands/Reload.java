package org.claniel.ElytraGuard.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.claniel.ElytraGuard.ElytraGuard;


public class Reload implements CommandExecutor  {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!sender.hasPermission("elytraguard.reload")) {
			sender.sendMessage("You are not allowed to use this command");
			return true;
		}
		
		ElytraGuard.getPluginInstance().reloadConfig();
		ElytraGuard.getPluginInstance()._stopPlugin();
		try {
			ElytraGuard.getPluginInstance()._startPlugin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender.sendMessage("Plugin has been reloaded successful");
		return true;
	}

}
