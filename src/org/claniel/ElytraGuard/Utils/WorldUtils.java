package org.claniel.ElytraGuard.Utils;

import org.claniel.ElytraGuard.ElytraGuard;

public class WorldUtils {

	public static boolean isDisabled(String worldName) {
		return ElytraGuard.getPluginInstance().getConfig().getList("DISABLED_WORLDS").contains(worldName);
	}
}
