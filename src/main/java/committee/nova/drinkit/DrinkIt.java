package committee.nova.drinkit;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DrinkIt implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Drink It");
	public static final String MODID = "drinkit";
	public static final Tag<Item> DRINKABLE = TagFactory.ITEM.create(new Identifier(MODID, "drinkable"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("drink it hahayes");
	}
}
