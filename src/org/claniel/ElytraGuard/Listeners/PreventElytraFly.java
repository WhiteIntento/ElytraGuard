package org.claniel.ElytraGuard.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.claniel.ElytraGuard.Utils.PlayerUtil;
import org.claniel.ElytraGuard.Utils.WorldUtils;

public class PreventElytraFly implements Listener{

	@EventHandler
	public void onEntityToggleGlide(EntityToggleGlideEvent event) {
		
		//This check entity if player
		if(event.getEntity() instanceof Player) {
			Player p= (Player) event.getEntity();
			if(WorldUtils.isDisabled(p.getWorld().getName())) {
				return;
			}
			if(p.hasPermission("elytraguard.elytrafly")) {
				return;
			}
			// This check verifies whether the player is flying using the event.isGliding() method and whether the player has an Elytra in their inventory.
			// It checks this by checking if the material in the chestplace is ELYTRA using p.getInventory().getChestplate().getType() == Material.ELYTRA.
			if (event.isGliding() && p.getInventory().getChestplate().getType() == Material.ELYTRA) {
				PlayerUtil.sendLocaleMessage(p, "cannot_fly_elytra");
		        event.setCancelled(true);  //stop event
		    }
		}
	}

}
