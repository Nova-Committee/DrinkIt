package committee.nova.drinkit;


import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.tags.ItemTags.bind;

@Mod(DrinkIt.MODID)
public class DrinkIt {
    public static final String MODID = "drinkit";
    public static final Tag.Named<Item> DRINKABLE = bind(MODID + ":drinkable");
    public static final Tag.Named<Item> THICK = bind(MODID + ":thick");

    public DrinkIt() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
