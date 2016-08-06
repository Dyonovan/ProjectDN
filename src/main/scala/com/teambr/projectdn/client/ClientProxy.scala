package com.teambr.projectdn.client

import com.teambr.projectdn.client.renderers.tiles.AltarEntityRenderer
import com.teambr.projectdn.common.CommonProxy
import com.teambr.projectdn.common.tiles.TileAltar
import com.teambr.projectdn.lib.Constants
import com.teambr.projectdn.managers.BlockManager
import net.minecraftforge.client.model.obj.OBJLoader
import net.minecraftforge.fml.client.registry.ClientRegistry

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
class ClientProxy extends CommonProxy {

    override def preInit(): Unit = {
        // Item Block Models
        ItemRenderManager.registerBlockModel(BlockManager.blockAltar, "blockAltar", "normal")
    }

    override def init(): Unit = {
        ItemRenderManager.registerItemRenderers()

        ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileAltar], new AltarEntityRenderer[TileAltar])
    }

    override def postInit(): Unit = { }

}
