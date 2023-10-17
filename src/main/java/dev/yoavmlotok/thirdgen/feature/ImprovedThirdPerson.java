package dev.yoavmlotok.thirdgen.feature;

import net.minecraft.client.MinecraftClient;

public class ImprovedThirdPerson {
	public static boolean perspectiveManuallyChanged;

	public static boolean isFlying() {
        assert MinecraftClient.getInstance().player != null;
        return MinecraftClient.getInstance().player.getAbilities().flying;
	}
}
