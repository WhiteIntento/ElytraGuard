package org.claniel.ElytraGuard.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.claniel.ElytraGuard.ElytraGuard;
import org.claniel.ElytraGuard.Config.Locale;


public class LocaleUtil {

	protected static Map<String,Locale> locales = new HashMap<String,Locale>();
	
	public static String get(String locale, String messageKey) {
		Locale l;
		try {
			l = getOrCreateLocale(locale);
			return l.get(messageKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}
	
	public static String get(String messageKey) {
		return get(ElytraGuard.getPluginInstance().getConfig().getString("DEFAULT_LOCALE"),messageKey);
	}
	
	public static Locale getOrCreateLocale(String locale) throws IOException {
		if(locales.get(locale) == null) {
			locales.put(locale,new Locale(locale));
		}
		
		return locales.get(locale);
	}
	
	public static void set(String locale, String key,Object value) throws IOException {
		Locale l = getOrCreateLocale(locale);
		l.set(key, value);
	}
	
	public static void saveLocale(String locale) throws IOException {
		Locale l = getOrCreateLocale(locale);
		l.getConfigHandler().save();
	}
}
