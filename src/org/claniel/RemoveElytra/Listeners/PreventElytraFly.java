package org.claniel.RemoveElytra.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.claniel.RemoveElytra.RemoveElytra;

public class PreventElytraFly implements Listener{

	@EventHandler
	public void onEntityToggleGlide(EntityToggleGlideEvent event) {
		//This check entity if player
		if(event.getEntity() instanceof Player) {
			Player p= (Player) event.getEntity();
			if(p.hasPermission("removeelytra.elytrafly")) {
				return;
			}
			//тази проверка проверява дали се лети с метода event.isGliding()  и дали на потребителя има сложен elytra в inventory
			// с p.getInventory().getChestplate().getType() == Material.ELYTRA(проверявадали материала слложен в chestplace е elytra)
			if (event.isGliding() && p.getInventory().getChestplate().getType() == Material.ELYTRA) {
		        event.setCancelled(true);  //stop event
		    }
		}
	}

}
