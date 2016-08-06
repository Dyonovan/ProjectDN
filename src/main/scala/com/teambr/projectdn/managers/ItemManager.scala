package com.teambr.projectdn.managers

import com.teambr.projectdn.common.items.{ItemCrystal, ItemCrystalSeed, ItemIngotSky, ItemSpellLevelBook}
import com.teambr.projectdn.lib.Constants
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.{GameRegistry, IForgeRegistryEntry}
import net.minecraftforge.oredict.OreDictionary

/**
  * This file was created for ProjectDN
  *
  * ProjectDN is licensed under the
  * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
  * http://creativecommons.org/licenses/by-nc-sa/4.0/
  *
  * @author Dyonovan
  * @since 8/4/16
  */
object ItemManager {

    lazy val itemCrystal = new ItemCrystal
    lazy val spellLevelBook = new ItemSpellLevelBook

    def preInit(): Unit = {
        registerItem(spellLevelBook, "spellLevelBook")
    }

    def registerItem(item: Item, name: String, oreDict: String): Item = {
        item.setRegistryName(Constants.MOD_ID, name)
        GameRegistry.register(item)
        if (oreDict != null) OreDictionary.registerOre(oreDict, item)
        item
    }

    def registerItem(item: Item, name: String): Item = {
        registerItem(item, name, null)
    }

}
