package dev.redstone.deathbsod.mixins;

import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.components.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DeathScreen.class)
public abstract class NoRespawnMixin {

    @Inject(method = "createButtons", at = @At("TAIL"))
    private void disableRespawnButton(CallbackInfo ci) {
        for (Button button : ((DeathScreen)(Object)this).getChildren()) {
            if (button.getMessage().getString().equals("Respawn")) {
                button.active = false; // Disable the button
            }
        }
    }
}