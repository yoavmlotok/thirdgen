package dev.yoavmlotok.thirdgen.config;

import dev.yoavmlotok.thirdgen.ThirdGen;
import dev.yoavmlotok.thirdgen.config.option.Range;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ThirdGenConfig {
	public static Range initialZoomFov = new Range(15.0, 0.15, 30.0);

	// Change To Rear View
	public static boolean onRun = false;
	public static boolean onCreativeFly = false;
	public static boolean onElytraFly = false;
	public static boolean onSitting = false;
	public static boolean notOnSubmerged = false;
	public static boolean notOnTouchingLava = false;
	public static boolean notOnFreezing = false;
	public static boolean notOnInsideWall = false;
	public static boolean notOnUsingItem = false;

	public static void initialize() {

		/*
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setIndent(2);
		dumperOptions.setPrettyFlow(true);
		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

		Yaml yaml = new Yaml(dumperOptions);
		try {
			Map<String, Object> config = yaml.load(new FileInputStream("config/quilt/thirdgen.yaml"));
			initialZoomFov.setValue(((double) config.get("initialZoomFov")));
			onRun = ((boolean) config.get("onRun"));
			onCreativeFly = ((boolean) config.get("onCreativeFly"));
			onElytraFly = ((boolean) config.get("onElytraFly"));
			onSitting = ((boolean) config.get("onSitting"));
			notOnSubmerged = ((boolean) config.get("notOnSubmerged"));
			notOnTouchingLava = ((boolean) config.get("notOnTouchingLava"));
			notOnFreezing = ((boolean) config.get("notOnFreezing"));
			notOnInsideWall = ((boolean) config.get("notOnInsideWall"));
			notOnUsingItem = ((boolean) config.get("notOnUsingItem"));
			ThirdGen.LOGGER.info("loaded config file");
		}
		catch (Exception exception) {
			Map<String, Object> defaultConfig = new LinkedHashMap<>();
			defaultConfig.put("initialZoomFov", initialZoomFov.getValue());
			defaultConfig.put("onRun", onRun);
			defaultConfig.put("onCreativeFly", onCreativeFly);
			defaultConfig.put("onElytraFly", onElytraFly);
			defaultConfig.put("onSitting", onSitting);
			defaultConfig.put("notOnSubmerged", notOnSubmerged);
			defaultConfig.put("notOnTouchingLava", notOnTouchingLava);
			defaultConfig.put("notOnFreezing", notOnFreezing);
			defaultConfig.put("notOnInsideWall", notOnInsideWall);
			defaultConfig.put("notOnUsingItem", notOnUsingItem);
			try {
				yaml.dump(defaultConfig, new PrintWriter("config/quilt/thirdgen.yaml"));
				ThirdGen.LOGGER.info("created config file");
			}
			catch (FileNotFoundException fileNotFoundException) {
				ThirdGen.LOGGER.trace(fileNotFoundException.toString());
			}
		}
		 */
	}

	private Map<String, Object> readConfig() {
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setIndent(2);
		dumperOptions.setPrettyFlow(true);
		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

		Yaml yaml = new Yaml(dumperOptions);

		InputStream configFile;
		try {
			 configFile = new FileInputStream("config/quilt/thirdgen.yaml");
		}
		catch (FileNotFoundException configNotFoundException) {
			ThirdGen.LOGGER.info("couldn't find config file, generating config file");

			Map<String, Object> config = new LinkedHashMap<>();

			try {
				yaml.dump(config, new PrintWriter("config/quilt/thirdgen.yaml"));
			}
			catch (FileNotFoundException couldNotWriteException) {
				throw new RuntimeException("couldn't write config to file");
            }

			return config;
        }

		return yaml.load(configFile);
	}
}
