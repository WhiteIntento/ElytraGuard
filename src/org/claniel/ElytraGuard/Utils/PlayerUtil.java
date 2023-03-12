package org.claniel.ElytraGuard.Utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.claniel.ElytraGuard.ElytraGuard;

import net.md_5.bungee.api.ChatColor;

public class PlayerUtil {

	/**
	 * This method send colored locale message to player
	 * @param p
	 * @param message
	 */
	public static void sendLocaleMessage(Player p, String message) {
		String c="&";
		String messageTitle=ElytraGuard.getPluginInstance().getConfig().getString("MESSAGE_TITLE");
		p.sendMessage(ChatColor.translateAlternateColorCodes(c.toCharArray()[0], messageTitle + LocaleUtil.get(message)));
	}
	
	public static void sendLocaleMessage(CommandSender p, String message) {
		String c="&";
		String messageTitle=ElytraGuard.getPluginInstance().getConfig().getString("MESSAGE_TITLE");
		p.sendMessage(ChatColor.translateAlternateColorCodes(c.toCharArray()[0], messageTitle + LocaleUtil.get(message)));
	}
}
