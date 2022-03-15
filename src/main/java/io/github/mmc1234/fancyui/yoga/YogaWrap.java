package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaWrap implements EnumHelper<YogaWrap> {
    NO_WARP,
    WARP,
    WARP_REVERSE;
    public static YogaWrap fromInt(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}