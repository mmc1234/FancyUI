package io.github.mmc1234.fancyui.yoga.internal;

import io.github.mmc1234.fancyui.yoga.YogaDisplay;
import io.github.mmc1234.fancyui.yoga.YogaFlexDirection;
import io.github.mmc1234.fancyui.yoga.YogaJustify;
import org.lwjgl.util.yoga.YGNode;
import org.lwjgl.util.yoga.Yoga;

public class Native {
    public static final long YGNodeNewWithConfig(long config) {
        return Yoga.YGNodeNewWithConfig(config);
    }

    public static final void YGNodeSetConfig(long ygNode, long config) {
        YGNode.nconfig(ygNode, config);
    }

    public static final void YGNodeStyleSetFlexDirection(long ygNode, YogaFlexDirection value) {
        Yoga.YGNodeStyleSetFlexDirection(ygNode, value == null ? YogaFlexDirection.values()[0].value() : value.value());
    }

    public static final YogaJustify YGNodeStyleGetJustifyContent(long ygNode) {
        return YogaJustify.valueOf(Yoga.nYGNodeStyleGetJustifyContent(ygNode));
    }

    public static final void YGNodeStyleSetJustifyContent(long ygNode, YogaJustify value) {
        Yoga.YGNodeStyleSetJustifyContent(ygNode, value == null ? YogaFlexDirection.values()[0].value() : value.value());
    }

    public static YogaDisplay YGNodeStyleGetDisplay(long ygNode) {
        return YogaDisplay.valueOf(Yoga.YGNodeStyleGetDisplay(ygNode));
    }

    public static void YGNodeStyleSetDisplay(long ygNode, YogaDisplay display) {
        Yoga.YGNodeStyleSetDisplay(ygNode, display.value());
    }
}
