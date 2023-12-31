package dev.yoavmlotok.thirdgen.mixin;

import dev.yoavmlotok.thirdgen.ThirdGen;
import dev.yoavmlotok.thirdgen.config.ThirdGenConfig;
import dev.yoavmlotok.thirdgen.feature.Zoom;
import net.minecraft.client.Mouse;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {
	@Shadow
	private double cursorDeltaX;

	@Shadow
	private double cursorDeltaY;

	@Inject(at = @At("HEAD"), method = "updateLookDirection")
	private void updateLookDirection(CallbackInfo ci) {
		if (ThirdGen.zoomKeyBind.isPressed()) {
			cursorDeltaX *= ThirdGenConfig.zoomMouseSensitivityMultiplier * Zoom.currentFov / ThirdGenConfig.initialZoomFov;
			cursorDeltaY *= ThirdGenConfig.zoomMouseSensitivityMultiplier * Zoom.currentFov / ThirdGenConfig.initialZoomFov;
		}
	}

	@Inject(at = @At("HEAD"), method = "onMouseScroll", cancellable = true)
	private void onMouseScroll(long window, double scrollDeltaX, double scrollDeltaY, CallbackInfo ci) {
		if (ThirdGen.zoomKeyBind.isPressed()) {
			Zoom.currentFov = MathHelper.clamp(Zoom.currentFov - scrollDeltaY * ThirdGenConfig.fovChangeOnScroll * Zoom.currentFov / ThirdGenConfig.initialZoomFov, 0.15, 30.0);
			ci.cancel();
		}
	}
}
