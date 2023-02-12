package org.claniel.RemoveElytra.Listeners;

import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;

/**
 * This class prevent usage righ click elytra for place in youself
 * @author Claniel
 *
 */
public class PreventClickPlaceElytra implements Listener {

	@EventHandler
	  public void onPlayerInteract(PlayerInteractEvent event) {
		if(this.hasPermission(event.getPlayer())) {
			return;
		}
		if(event.getItem() != null) {
			if(event.getItem().getType().name().equals("ELYTRA")) {
		    	event.setCancelled(true);
		    }
		}
	 }
	
	@EventHandler
	public void onInventoryClicn(InventoryClickEvent event) {
		
		HumanEntity he = event.getWhoClicked();
		if(he instanceof Player) {
			Player player = (Player)he;
			if(this.hasPermission(player)) {
				return;
			}
			if(event.getCurrentItem() != null) {
				Material item = event.getCurrentItem().getType();
				if(item.name().equals("ELYTRA")) {
					event.setCancelled(false);
					player.getInventory().remove(Material.ELYTRA);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerPicupItem(PlayerPickupItemEvent event) {
		if(this.hasPermission(event.getPlayer())) {
			return;
		}
		String material = event.getItem().getItemStack().getType().name();
		if(material.equals("ELYTRA")) {
			event.setCancelled(true);
		}
	}
	
	protected boolean hasPermission(Player p) {
		return p.hasPermission("removeelytra.use.elytra");
	}
	

}

