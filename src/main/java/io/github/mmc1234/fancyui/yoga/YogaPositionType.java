package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaPositionType implements EnumHelper<YogaPositionType> {
    RELATIVE,
    ABSOLUTE;
    public static YogaPositionType fromInt(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}