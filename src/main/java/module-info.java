module FancyUI {
    requires org.lwjgl.yoga;
    requires org.lwjgl.glfw;
    requires org.lwjgl.opengl;
    requires org.lwjgl.nanovg;
    requires com.google.common;
    requires jdk.incubator.foreign;
    exports io.github.mmc1234.fancyui.core;
    exports io.github.mmc1234.fancyui.yoga;
    exports io.github.mmc1234.fancyui.util;
}