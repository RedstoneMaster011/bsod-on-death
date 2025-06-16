package dev.redstone.deathbsod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import dev.redstone.deathbsod.world.inventory.AboutStartGuiMenu;
import dev.redstone.deathbsod.network.AboutStartGuiButtonMessage;
import dev.redstone.deathbsod.DeathbsodMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class AboutStartGuiScreen extends AbstractContainerScreen<AboutStartGuiMenu> {
	private final static HashMap<String, Object> guistate = AboutStartGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_accept_conditions;

	public AboutStartGuiScreen(AboutStartGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("deathbsod:textures/screens/about_start_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_info"), 77, 6, -10027009, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_this_mod_blue_screens_your_pc_wh"), 36, 19, -16777063, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_your_pc_when_you_die"), 38, 30, -16777063, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_but"), 81, 42, -154, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_it_wont_damage_your_pc_but_will"), 31, 53, -16777063, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_but_will_close_any_unsaved_stuff"), 5, 64, -16777063, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_help"), 78, 80, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_windows_only"), 58, 91, -13434880, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_req_python_powershell_java"), 27, 103, -13434880, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.deathbsod.about_start_gui.label_have_fun"), 68, 114, -13421569, false);
	}

	@Override
	public void init() {
		super.init();
		button_accept_conditions = Button.builder(Component.translatable("gui.deathbsod.about_start_gui.button_accept_conditions"), e -> {
			if (true) {
				DeathbsodMod.PACKET_HANDLER.sendToServer(new AboutStartGuiButtonMessage(0, x, y, z));
				AboutStartGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 32, this.topPos + 134, 114, 20).build();
		guistate.put("button:button_accept_conditions", button_accept_conditions);
		this.addRenderableWidget(button_accept_conditions);
	}
}
