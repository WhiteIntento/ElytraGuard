package org.claniel.ElytraGuard.Config;

import java.io.IOException;

import org.claniel.ElytraGuard.Utils.LocaleUtil;


public class DefineDefaultLocales {

	public static void defineEnglishLocales() throws IOException {
		Locale l = LocaleUtil.getOrCreateLocale("en");
		l.set("cannot_use_elytra", "&aYou are not allowed to use Elytra");
		l.set("cannot_pickup_elytra", "&aYou have no right to take Elytra");
		l.set("cannot_fly_elytra", "&aYou are not allowed to fly with Elytra");
		if(!l.getConfig().getKeys(false).isEmpty()) {
			l.getConfigHandler().save();
		}
	}
}
