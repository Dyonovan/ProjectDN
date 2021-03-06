package com.teambr.luxetumbra.common.items

import com.teambr.luxetumbra.LuxEtUmbra
import com.teambr.luxetumbra.lib.Constants
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{ItemShield, ItemStack}
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.text.translation.I18n

/**
  * This file was created for Lux et Umbra
  *
  * Lux et Umbra is licensed under the
  * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
  * http://creativecommons.org/licenses/by-nc-sa/4.0/
  *
  * @author Paul Davis <pauljoda>
  * @since 8/6/2016
  */
class ItemEnergyShield(name : String) extends ItemShield {
    setUnlocalizedName(Constants.MOD_ID + ":" + name)
    setMaxStackSize(1)
    setCreativeTab(LuxEtUmbra.luxEtUmbra)

    override def getCreativeTab: CreativeTabs = LuxEtUmbra.luxEtUmbra

    override def getIsRepairable(toRepair: ItemStack, repair: ItemStack): Boolean = false

    override def getItemStackDisplayName(stack: ItemStack): String =
        ("" + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim
}

// Just used to bind a TESR to the itemstack. lol
class DummyTile extends TileEntity {}
class DummyDayTile extends DummyTile {}
class DummyNightTile extends DummyTile {}
class DummyBlock extends Block(Material.IRON) {}
