package dev.redstone.deathbsod.mixins;

import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.components.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.stream.Collectors;

@Mixin(DeathScreen.class)
public abstract class NoRespawnMixin {

    @Inject(method = "createButtons", at = @At("HEAD"))
    private void disableRespawnButton(CallbackInfo ci) {
        List<Button> buttons = ((DeathScreen)(Object)this).renderables.stream()
            .filter(Button.class::isInstance)
            .map(Button.class::cast)
            .collect(Collectors.toList());

        for (Button button : buttons) {
            if (button.getMessage().getString().equals("Respawn")) {
                button.active = false; // Disable the button
            }
        }
    }
}