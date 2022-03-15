package io.github.mmc1234.fancyui.core.internal;

import org.lwjgl.nanovg.NVGColor;

public class NanoVGInternal {
    public static long CONTEXT = 0;

    public static NVGColor rgba(NVGColor color, float r, float g, float b, float a) {
        return color.r(r).g(g).b(b).a(a);
    }

    public static NVGColor rgb(NVGColor color, float r, float g, float b) {
        return color.r(r).g(g).b(b).a(1);
    }

}
