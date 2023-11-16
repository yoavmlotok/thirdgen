package dev.yoavmlotok.thirdgen.config.option;

import net.minecraft.util.math.MathHelper;

public class Range {
	public final double minValue;
	public final double maxValue;

	private double value;

	public Range(double value, double minValue, double maxValue) {
		this.value = value;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public void setValue(double value) {
		this.value = MathHelper.clamp(value, minValue, maxValue);
	}

	public double getValue() {
		return value;
	}
}
