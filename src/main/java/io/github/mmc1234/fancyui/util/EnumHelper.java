package io.github.mmc1234.fancyui.util;

public interface EnumHelper<T extends Enum<?> & EnumHelper> {
    default int value() {
        if(this instanceof Enum<?> enumInstance){
            return enumInstance.ordinal();
        }
        throw new UnsupportedOperationException();
    }

    static <T extends Enum<?> & EnumHelper> T intToEnum(T[] values, int i) {
        if(values[i].value() == i) {
            return values[i];
        }
        for (var v : values) {
            if(v.value() == i) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }
}
