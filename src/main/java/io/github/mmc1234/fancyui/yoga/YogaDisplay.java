package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaDisplay implements EnumHelper<YogaDisplay> {
    FLEX,NONE;
    public static YogaDisplay valueOf(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}