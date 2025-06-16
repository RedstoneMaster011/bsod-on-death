package dev.redstone.deathbsod;

import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.resources.language.I18n;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = {Dist.CLIENT})
public class NoRespawn {
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onGuiInit(ScreenEvent.Init.Post event) {
        LOGGER.info("ScreenEvent fired: " + event.getScreen().getClass().getName());

        if (event.getScreen() instanceof DeathScreen) {
            LOGGER.info("DeathScreen detected!");

            List<AbstractWidget> widgets = event.getScreen().children().stream()
                .filter(AbstractWidget.class::isInstance)
                .map(AbstractWidget.class::cast)
                .collect(Collectors.toList());

            for (AbstractWidget button : widgets) {
                LOGGER.info("Found button: " + button.getMessage().getString());

                if (button.getMessage().getString().equals(I18n.get("deathScreen.respawn"))) {
                    LOGGER.info("Disabling Respawn button...");
                    button.active = false;  // Disable the respawn button
                }
            }
        }
    }
}