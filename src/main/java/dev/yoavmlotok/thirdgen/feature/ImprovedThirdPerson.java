package dev.yoavmlotok.thirdgen.feature;

import dev.yoavmlotok.thirdgen.config.ThirdGenConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class ImprovedThirdPerson {
	public static boolean perspectiveManuallyChanged;

	public static boolean wasAlreadyRunning = false;
	public static double lastTimeStartedRunning = 0;

	public static boolean areConditionMet() {
        assert MinecraftClient.getInstance().player != null;
		PlayerEntity player = MinecraftClient.getInstance().player;

		if (!wasAlreadyRunning && player.isSprinting()) {
			lastTimeStartedRunning = player.age;
		}
		wasAlreadyRunning = player.isSprinting();

		boolean areConditionsMet = false;

		if (player.isSprinting() && lastTimeStartedRunning + 20 < player.age) {
			areConditionsMet = ThirdGenConfig.onRun;
		}
		if (player.getAbilities().flying) {
			areConditionsMet |= ThirdGenConfig.onCreativeFly;
		}
		if (player.isFallFlying()) {
			areConditionsMet |= ThirdGenConfig.onElytraFly;
		}
		if (player.getRootVehicle() != player) {
			areConditionsMet |= ThirdGenConfig.onSitting;
		}
		if (player.isSubmergedInWater()) {
			areConditionsMet &= !ThirdGenConfig.notOnSubmerged;
		}
		if (player.isInLava()) {
			areConditionsMet &= !ThirdGenConfig.notOnTouchingLava;
		}
		if (player.isFreezing()) {
			areConditionsMet &= !ThirdGenConfig.notOnFreezing;
		}
		if (player.isInsideWall()) {
			areConditionsMet &= !ThirdGenConfig.notOnInsideWall;
		}
		if (player.isUsingItem()) {
			areConditionsMet &= !ThirdGenConfig.notOnUsingItem;
		}

        return areConditionsMet;
	}
}
