package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaUnit implements EnumHelper<YogaUnit> {
    UNDEFINED,
    POINT,
    PERCENT,
    AUTO;
    public static YogaUnit fromInt(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}