package dev.yoavmlotok.thirdgen.feature;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class ImprovedThirdPerson {
	public static boolean perspectiveManuallyChanged;

	public static boolean isConditionMet() {
        assert MinecraftClient.getInstance().player != null;
		PlayerEntity player = MinecraftClient.getInstance().player;
        return (player.isSprinting() || player.isFallFlying() || player.getAbilities().flying || player.getRootVehicle() != player) && !(player.isSubmergedInWater() || player.isInLava() || player.isFreezing() || player.isInsideWall() || player.isUsingItem());
	}
}
