package org.claniel.ElytraGuard.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.claniel.ElytraGuard.Utils.PlayerUtil;
import org.claniel.ElytraGuard.Utils.WorldUtils;

public class RemoveElytraFromInventory implements Listener{
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		HumanEntity he = event.getWhoClicked();
		if(he instanceof Player) {
			Player player = (Player)he;
			if(WorldUtils.isDisabled(player.getWorld().getName())) {
				return;
			}
			if(this.hasPermission(player)) {
				return;
			}
			if(event.getCurrentItem() != null) {
				Material item = event.getCurrentItem().getType();
				if(item.name().equals("ELYTRA")) {
					PlayerUtil.sendLocaleMessage(player, "cannot_use_elytra");
					event.setCancelled(true);
					player.getInventory().remove(Material.ELYTRA);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent event) {
		if(WorldUtils.isDisabled(event.getPlayer().getWorld().getName())) {
			return;
		}
		if(this.hasPermission(event.getPlayer())) {
			return; 
		}
		String material = event.getItem().getItemStack().getType().name();
		if(material.equals("ELYTRA")) {
			PlayerUtil.sendLocaleMessage(event.getPlayer(), "cannot_pickup_elytra");
			event.setCancelled(true);
			event.getItem().remove();
		}
	}
	
	protected boolean hasPermission(Player p) {
		return p.hasPermission("elytraguard.autoremoveelytra");
	}

}
