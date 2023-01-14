package committee.nova.drinkit;


import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.List;

import static net.minecraft.tags.ItemTags.create;

@Mod(DrinkIt.MODID)
public class DrinkIt {
    public static final ForgeConfigSpec COMMON_CONFIG;
    private static final ForgeConfigSpec.ConfigValue<List<String>> cfgDrinkable;
    private static final ForgeConfigSpec.ConfigValue<List<String>> cfgThick;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("DrinkIt Configuration");
        cfgDrinkable = builder.comment("The items defined as drinks").define("drinkable", ImmutableList.of("minecraft:beetroot_soup", "example:another_drinkable"));
        cfgThick = builder.comment("The items defined as thick drinks").define("thick", ImmutableList.of("minecraft:suspicious_stew", "example:another_thick"));
        COMMON_CONFIG = builder.build();
    }

    public static final String MODID = "drinkit";
    public static final TagKey<Item> TAG_DRINKABLE = create(new ResourceLocation(MODID + ":drinkable"));
    public static final TagKey<Item> TAG_THICK = create(new ResourceLocation(MODID + ":thick"));

    public DrinkIt() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_CONFIG);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static boolean isDrinkable(ItemStack i) {
        return i.is(TAG_DRINKABLE) || isItemInList(i.getItem(), cfgDrinkable.get()) || isThick(i);
    }

    public static boolean isThick(ItemStack i) {
        return i.is(TAG_THICK) || isItemInList(i.getItem(), cfgThick.get());
    }

    private static boolean isItemInList(Item i, List<String> l) {
        final ResourceLocation r = i.builtInRegistryHolder().key().location();
        return l.contains(r.toString());
    }
}
