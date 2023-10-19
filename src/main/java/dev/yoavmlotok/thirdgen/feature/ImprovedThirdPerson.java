package dev.yoavmlotok.thirdgen.feature;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class ImprovedThirdPerson {
	public static boolean perspectiveManuallyChanged;

	public static boolean wasAlreadyRunning = false;
	public static double lastTimeStartedRunning = 0;

	public static boolean isConditionMet() {
        assert MinecraftClient.getInstance().player != null;
		PlayerEntity player = MinecraftClient.getInstance().player;

		if (!wasAlreadyRunning && player.isSprinting()) {
			lastTimeStartedRunning = player.age;
		}
		wasAlreadyRunning = player.isSprinting();

        return ((player.isSprinting() && lastTimeStartedRunning + 20 < player.age) || player.isFallFlying() || player.getAbilities().flying || player.getRootVehicle() != player) && !(player.isSubmergedInWater() || player.isInLava() || player.isFreezing() || player.isInsideWall() || player.isUsingItem());
	}
}
