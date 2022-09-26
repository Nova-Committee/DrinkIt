package committee.nova.drinkit.config

import committee.nova.drinkit.config.CommonConfig.{config, drinkable}
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.common.config.Configuration

object CommonConfig {
  def init(e: FMLPreInitializationEvent): Unit = new CommonConfig(e)

  private var config: Configuration = _
  var drinkable: Array[String] = _
}

class CommonConfig(e: FMLPreInitializationEvent) {
  config = new Configuration(e.getSuggestedConfigurationFile)
  config.load()
  drinkable = config.getStringList("drinkable", Configuration.CATEGORY_GENERAL, Array("mushroomStew", "exampleDrinkable1", "exampleDrinkable2"), "List of drinkable item's unlocalized name")
  config.save()
}
