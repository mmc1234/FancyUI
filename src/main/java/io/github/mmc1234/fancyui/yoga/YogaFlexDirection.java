package io.github.mmc1234.fancyui.yoga;

import io.github.mmc1234.fancyui.util.EnumHelper;

public enum YogaFlexDirection implements EnumHelper<YogaFlexDirection> {
    Column,
    ColumnReverse,
    Row,
    RowReverse;

    public static YogaFlexDirection valueOf(int i) {
        return EnumHelper.intToEnum(values(), i);
    }
}
