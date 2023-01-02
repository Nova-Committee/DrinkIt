package committee.nova.drinkit;

import committee.nova.drinkit.config.CommonConfig;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Arrays;

@Mod(modid = "drinkit", useMetadata = true, acceptableRemoteVersions = "*")
public class DrinkIt {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        CommonConfig.init(e);
    }

    public static boolean isDrinkable(Item item) {
        final ResourceLocation r = item.getRegistryName();
        if (r == null) return false;
        return Arrays.stream(CommonConfig.getDrinkable()).anyMatch(d -> d.equals(r.toString()));
    }
}
