package committee.nova.drinkit.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonConfig {
    private static Configuration cfg;
    private static String[] drinkable;

    public static void init(FMLPreInitializationEvent e) {
        cfg = new Configuration(e.getSuggestedConfigurationFile());
        cfg.load();
        drinkable = cfg.getStringList("drinkable", Configuration.CATEGORY_GENERAL, new String[]{"minecraft:mushroom_stew", "minecraft:beetroot_soup", "example_namespace:example_item"}, "List of drinkable item's resource location name");
        cfg.save();
    }

    public static String[] getDrinkable() {
        return drinkable;
    }
}
