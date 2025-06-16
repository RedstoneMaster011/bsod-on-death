
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package dev.redstone.deathbsod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import dev.redstone.deathbsod.world.inventory.AboutStartGuiMenu;
import dev.redstone.deathbsod.DeathbsodMod;

public class DeathbsodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DeathbsodMod.MODID);
	public static final RegistryObject<MenuType<AboutStartGuiMenu>> ABOUT_START_GUI = REGISTRY.register("about_start_gui", () -> IForgeMenuType.create(AboutStartGuiMenu::new));
}
