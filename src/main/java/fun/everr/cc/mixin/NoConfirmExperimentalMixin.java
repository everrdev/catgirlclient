package fun.everr.cc.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import com.mojang.serialization.Lifecycle;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;

@Mixin(WorldOpenFlows.class)
public abstract class NoConfirmExperimentalMixin {
    @Inject(at = @At("HEAD"), method = "confirmWorldCreation", cancellable = true, remap = false)
    private static void onConfirmWorldCreation(Minecraft pMinecraft, CreateWorldScreen pLastScreen, Lifecycle pLifecycle, Runnable pOnConfirmed, CallbackInfo ci) {
        pOnConfirmed.run();
        ci.cancel();
    }
}
