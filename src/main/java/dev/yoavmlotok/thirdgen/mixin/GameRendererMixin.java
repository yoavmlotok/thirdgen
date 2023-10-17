package dev.yoavmlotok.thirdgen.mixin;

import dev.yoavmlotok.thirdgen.ThirdGen;
import dev.yoavmlotok.thirdgen.config.ThirdGenConfig;
import dev.yoavmlotok.thirdgen.feature.Zoom;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
	@Shadow
	private boolean renderingPanorama;

	@Inject(at = @At("HEAD"), method = "getFov", cancellable = true)
	private void getFov(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> ci) {
		if (this.renderingPanorama) {
			ci.setReturnValue(90.0);
		}

		if (!Zoom.wasAlreadyPressed && ThirdGen.zoomKeyBind.isPressed()) {
			Zoom.currentFov = ThirdGenConfig.initialZoomFov;
		}
		Zoom.wasAlreadyPressed = ThirdGen.zoomKeyBind.isPressed();

		if (ThirdGen.zoomKeyBind.isPressed()) {
			ci.setReturnValue(Zoom.currentFov);
		}
	}
}
