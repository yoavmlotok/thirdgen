package dev.yoavmlotok.thirdgen.mixin;

import dev.yoavmlotok.thirdgen.ThirdGen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Perspective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
	@Shadow
	private Perspective perspective;

	@Inject(at = @At("HEAD"), method = "getPerspective", cancellable = true)
	private void getPerspective(CallbackInfoReturnable<Perspective> cir) {
		if (ThirdGen.frontPerspectiveKeyBind.isPressed()) {
			cir.setReturnValue(Perspective.THIRD_PERSON_FRONT);
		}
	}

	@Inject(at = @At("HEAD"), method = "setPerspective", cancellable = true)
	private void setPerspective(Perspective perspective, CallbackInfo ci) {
		if (perspective.isFrontView()) {
			this.perspective = Perspective.FIRST_PERSON;
			ci.cancel();
		}
	}
}
