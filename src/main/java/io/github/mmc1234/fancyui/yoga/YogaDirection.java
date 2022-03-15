package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaDirection implements EnumHelper<YogaDirection> {
    Inherit,
    LTR,
    RTL;
    public static YogaDirection valueOf(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}
