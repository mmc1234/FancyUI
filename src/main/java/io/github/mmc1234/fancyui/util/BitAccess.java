package io.github.mmc1234.fancyui.util;

public class BitAccess {
    public static int setAndGetAtIndex(int flags, int index, boolean v) {
        if(v) {
            return enable(flags, index);
        } else {
            return disable(flags, index);
        }
    }
    public static boolean getAtIndex(int flags, int index) {
        return (flags & 1 << index) != 0;
    }

    public static int enable(int flags, int index) {
        return flags | 1 << index;
    }

    public static int disable(int flags, int index) {
        return flags & ~(1 << index);
    }
}
