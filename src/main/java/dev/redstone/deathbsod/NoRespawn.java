package dev.redstone.deathbsod;

import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.screens.DeathScreen.TitleConfirmScreen;
import net.minecraft.client.resources.language.I18n;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = {Dist.CLIENT})
public class NoRespawn {
    @SubscribeEvent
    public static void onGuiRender(ScreenEvent.Render.Post event) {
        if (event.getScreen() instanceof DeathScreen || event.getScreen() instanceof TitleConfirmScreen) {
            List<AbstractWidget> widgets = event.getScreen().children().stream()
                .filter(AbstractWidget.class::isInstance)
                .map(AbstractWidget.class::cast)
                .collect(Collectors.toList());

            for (AbstractWidget button : widgets) {
                if (button.getMessage().getString().equals(I18n.get("deathScreen.respawn")) ||
                	 button.getMessage().getString().equals(I18n.get("deathScreen.spectate")) ||
                    button.getMessage().getString().equals(I18n.get("deathScreen.titleScreen"))) {
                    button.active = false;
                }
            }
        }
    }
}