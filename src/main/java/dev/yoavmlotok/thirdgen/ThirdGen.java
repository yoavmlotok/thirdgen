package dev.yoavmlotok.thirdgen;

import com.mojang.blaze3d.platform.InputUtil;
import dev.yoavmlotok.thirdgen.config.ThirdGenConfig;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBind;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThirdGen implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Third Gen");

	public static final KeyBind frontPerspectiveKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBind("key.thirdgen.front-perspective", InputUtil.KEY_F4_CODE, "key.categories.thirdgen.thirdgen"));
	public static final KeyBind zoomKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBind("key.thirdgen.zoom", InputUtil.KEY_C_CODE, "key.categories.thirdgen.thirdgen"));

	@Override
	public void onInitializeClient(ModContainer mod) {
		ThirdGenConfig.initialize();
	}
}
