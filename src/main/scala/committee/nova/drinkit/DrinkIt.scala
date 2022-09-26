package committee.nova.drinkit

import committee.nova.drinkit.config.CommonConfig
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraft.item.Item
import org.apache.logging.log4j.LogManager

@Mod(modid = DrinkIt.MODID, useMetadata = true, modLanguage = "scala")
object DrinkIt {
  final val LOGGER = LogManager.getLogger
  final val MODID = "drinkit"

  @EventHandler def preInit(e: FMLPreInitializationEvent): Unit = CommonConfig.init(e)

  def isDrinkable(item: Item): Boolean = CommonConfig.drinkable.contains(item.getUnlocalizedName.substring(5))
}
