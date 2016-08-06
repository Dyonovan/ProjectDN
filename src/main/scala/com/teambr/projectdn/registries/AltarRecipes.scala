package com.teambr.projectdn.registries

import com.teambr.projectdn.collections.AltarRecipe
import com.teambr.projectdn.collections.WorldStructure.EnumAlterType
import com.teambr.projectdn.managers.ItemManager
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

import scala.collection.mutable.ArrayBuffer

/**
  * This file was created for ProjectDN
  *
  * ProjectDN is licensed under the
  * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
  * http://creativecommons.org/licenses/by-nc-sa/4.0/
  *
  * @author Dyonovan
  * @since 8/5/2016
  */
object AltarRecipes {

    private lazy val altarRecipes = new ArrayBuffer[AltarRecipe]

    def init(): Unit = {
        altarRecipes += new AltarRecipe(EnumAlterType.DAY_TIER_1, new ItemStack(Items.DIAMOND), new ItemStack(ItemManager.itemCrystal, 1, 1), 10.0F)
        altarRecipes += new AltarRecipe(EnumAlterType.DAY_TIER_2, new ItemStack(Items.EMERALD), new ItemStack(ItemManager.itemCrystal, 1, 1), 10.0F)
        altarRecipes += new AltarRecipe(EnumAlterType.NIGHT_TIER_2, new ItemStack(Items.NETHER_STAR), new ItemStack(ItemManager.itemCrystal, 1, 1), 10.0F)
        altarRecipes += new AltarRecipe(EnumAlterType.NIGHT_TIER_1, new ItemStack(Items.NETHER_WART), new ItemStack(ItemManager.itemCrystal, 1, 1), 10.0F)
    }

    def isItemValid(enumAlterType: EnumAlterType, itemStack: ItemStack): Boolean = {
        if (enumAlterType == EnumAlterType.INVALID || itemStack == null) return false
        if (getRecipe(enumAlterType, itemStack) != null) return true
        false
    }

    def getRecipe(enumAlterType: EnumAlterType, input: ItemStack): AltarRecipe = {
        if (enumAlterType == EnumAlterType.INVALID || input == null) return null
        for (recipe <- altarRecipes) {
            if (recipe.getInputStack.isItemEqual(input))
                recipe.getAltarType match {
                    case EnumAlterType.DAY_TIER_1 =>
                        if (enumAlterType == EnumAlterType.DAY_TIER_1 || enumAlterType == EnumAlterType.DAY_TIER_2 || enumAlterType == EnumAlterType.DAY_TIER_3) return recipe
                    case EnumAlterType.DAY_TIER_2 =>
                        if (enumAlterType == EnumAlterType.DAY_TIER_2 || enumAlterType == EnumAlterType.DAY_TIER_3) return recipe
                    case EnumAlterType.DAY_TIER_3 =>
                        if (enumAlterType == EnumAlterType.DAY_TIER_3) return recipe
                    case EnumAlterType.NIGHT_TIER_1 =>
                        if (enumAlterType == EnumAlterType.NIGHT_TIER_1 || enumAlterType == EnumAlterType.NIGHT_TIER_2 || enumAlterType == EnumAlterType.NIGHT_TIER_3) return recipe
                    case EnumAlterType.NIGHT_TIER_2 =>
                        if (enumAlterType == EnumAlterType.NIGHT_TIER_2 || enumAlterType == EnumAlterType.NIGHT_TIER_3) return recipe
                    case EnumAlterType.NIGHT_TIER_3 =>
                        if (enumAlterType == EnumAlterType.NIGHT_TIER_3) return recipe
                    case _ =>
                }
        }
        null
    }



}