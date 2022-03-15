package io.github.mmc1234.fancyui.example;

import com.google.common.base.Preconditions;
import jdk.incubator.foreign.ResourceScope;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.nanovg.NanoVGGL3;
import org.lwjgl.opengl.GL;

public class ExampleNanoVG {
    public static void main(String[] args) throws Exception {
        try(var scope = ResourceScope.newConfinedScope()) {
            GLFW.glfwInit();
            scope.addCloseAction(GLFW::glfwTerminate);

            GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

            var window = GLFW.glfwCreateWindow(400, 300, "Example NanoVG", 0L, 0L);
            Preconditions.checkState(window != 0, "Bad window");
            scope.addCloseAction(()-> GLFW.glfwDestroyWindow(window));

            GLFW.glfwMakeContextCurrent(window);
            GL.createCapabilities();

            var ctx = NanoVGGL3.nvgCreate(NanoVGGL3.NVG_STENCIL_STROKES);

            int font = NanoVG.nvgCreateFont(ctx, "Arial", "C:/Windows/Fonts/Arial.ttf");
            if (font == -1) {
                throw new Exception("Could not add font");
            }
            NanoVG.nvgFontSize(ctx, 16);

            var color = NVGColor.create();
            scope.addCloseAction(color::close);

            while (!GLFW.glfwWindowShouldClose(window)) {
                GLFW.glfwPollEvents();

                NanoVG.nvgBeginFrame(ctx, 400, 300, 1);

                NanoVG.nvgBeginPath(ctx);
                NanoVG.nvgRect(ctx, 20, 20, 100, 100);
                NanoVG.nvgFillColor(ctx, color.r(0).g(1).b(1).a(1));
                NanoVG.nvgFill(ctx);

                NanoVG.nvgBeginPath(ctx);
                NanoVG.nvgFillColor(ctx, color.r(1).g(0).b(1).a(1));
                NanoVG.nvgText(ctx, 0,16, "Hello NanoVG!");

                NanoVG.nvgEndFrame(ctx);

                GLFW.glfwSwapBuffers(window);

                Thread.sleep(60);
                GLFW.glfwPollEvents();
            }
        }
    }
}
