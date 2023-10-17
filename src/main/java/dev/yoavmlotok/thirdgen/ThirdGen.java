package dev.yoavmlotok.thirdgen;

import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBind;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
public class ThirdGen implements ClientModInitializer {
	public static final KeyBind zoomKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBind("key.thirdgen.zoom",InputUtil.KEY_C_CODE, "key.categories.thirdgen.thirdgen"));

	@Override
	public void onInitializeClient(ModContainer mod) {

	}
}
