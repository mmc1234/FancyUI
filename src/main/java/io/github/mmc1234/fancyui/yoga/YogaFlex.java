package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaFlex implements EnumHelper<YogaFlex> {
    NO_WARP,
    WARP,
    WARP_REVERSE;
    public static YogaFlex valueOf(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}