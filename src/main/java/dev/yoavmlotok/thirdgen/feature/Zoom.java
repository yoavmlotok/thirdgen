package dev.yoavmlotok.thirdgen.feature;

import dev.yoavmlotok.thirdgen.config.ThirdGenConfig;

public class Zoom {
	public static double currentFov = ThirdGenConfig.initialZoomFov.getValue();

	public static boolean wasAlreadyPressed;
}
