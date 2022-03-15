package io.github.mmc1234.fancyui.yoga;

import org.lwjgl.util.yoga.Yoga;

public class YogaConfig {
    private static final YogaConfig DEFAULT = new YogaConfig();
    private long _config;

    public YogaConfig() {
        this._config = Yoga.YGConfigNew();
    }

    public long toRawLongValue() {
        return _config;
    }
    public static YogaConfig getDefault() {
        return DEFAULT;
    }
}
