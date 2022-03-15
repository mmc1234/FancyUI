package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaAlign implements EnumHelper<YogaAlign> {
    AUTO,
    FLEX_START,
    CENTER,
    FLEX_END,
    STRETCH,
    BASELINE,
    SPACE_BETWEEN,
    SPACE_AROUND;

    public static YogaAlign valueOf(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}
