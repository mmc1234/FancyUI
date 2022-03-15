package io.github.mmc1234.fancyui.util;

public record ImmutableRect(float x0, float y0, float x1, float y1) {
    public boolean containsPoint(double x, double y) {
        return x>=x0 && y>=y0 && x<x1 && y<y1;
    }
}
