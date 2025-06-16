package dev.redstone.deathbsod.mixins;

import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.components.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeathScreen.class)
public abstract class NoRespawnMixin {

    @Inject(method = "createButtons", at = @At("HEAD"))
    private void disableRespawnButton(CallbackInfo ci) {
        for (Button button : this.buttons) {
            if (button.getMessage().getString().equals("Respawn")) {
                button.active = false; // This disables the button, preventing interaction
            }
        }
    }
}