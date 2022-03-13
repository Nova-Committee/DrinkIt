package committee.nova.drinkit;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrinkIt implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Drink It");
	public static final String MODID = "drinkit";
	public static final TagKey<Item> DRINKABLE = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "drinkable"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("drink it hahayes");
	}
}
