
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package dev.redstone.deathbsod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import dev.redstone.deathbsod.client.gui.AboutStartGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeathbsodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DeathbsodModMenus.ABOUT_START_GUI.get(), AboutStartGuiScreen::new);
		});
	}
}
