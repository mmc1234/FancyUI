package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaJustify implements EnumHelper<YogaJustify> {
    FLEX_START,
    CENTER,
    FLEX_END,
    SPACE_BETWEEN,
    SPACE_AROUND;

    public static YogaJustify valueOf(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}
