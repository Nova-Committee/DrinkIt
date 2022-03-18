package committee.nova.drinkit;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.tags.ItemTags.bind;

@Mod(DrinkIt.MODID)
public class DrinkIt {
    public static final String MODID = "drinkit";
    public static final ITag.INamedTag<Item> DRINKABLE = bind(MODID + ":drinkable");
    public static final ITag.INamedTag<Item> THICK = bind(MODID + ":thick");

    public DrinkIt() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
