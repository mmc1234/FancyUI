package io.github.mmc1234.fancyui.yoga;

import org.lwjgl.util.yoga.Yoga;

public record YogaValue(float value, YogaUnit unit) {

    public static final YogaValue UNDEFINED = new YogaValue(Yoga.YGUndefined, YogaUnit.UNDEFINED);
    public static final YogaValue ZERO = new YogaValue(0, YogaUnit.POINT);
    public static final YogaValue AUTO = new YogaValue(Yoga.YGUndefined, YogaUnit.AUTO);

    @Override
    public String toString() {
        return switch (unit) {
            case UNDEFINED -> "undefined";
            case POINT -> Float.toString(value);
            case PERCENT -> value + "%";
            case AUTO -> "auto";
            default -> throw new IllegalStateException();
        };
    }

    public static YogaValue parse(String s) {
        if (s == null) return null;
        return switch (s) {
            case "undefined" -> UNDEFINED;
            case "auto" -> AUTO;
            default -> s.endsWith("%") ?
                    new YogaValue(Float.parseFloat(s.substring(0, s.length() - 1)), YogaUnit.PERCENT) :
                    new YogaValue(Float.parseFloat(s), YogaUnit.POINT);
        };
    }
}
