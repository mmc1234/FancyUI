package io.github.mmc1234.fancyui.example;

import com.google.common.base.Preconditions;
import io.github.mmc1234.fancyui.core.Element;
import io.github.mmc1234.fancyui.core.Experimental;
import io.github.mmc1234.fancyui.core.event.MouseActionEvent;
import jdk.incubator.foreign.ResourceScope;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.nanovg.NanoVGGL3;
import org.lwjgl.opengl.GL;

public class ExampleApp implements Runnable {
    class Pos {
        double x,y;
    }
    long window;
    /**
     * NanoVG context address
     * */
    long ctx;
    Pos mousePos = new Pos();
    Element element;

    private void init(ResourceScope scope) throws Exception {
        GLFW.glfwInit();
        scope.addCloseAction(GLFW::glfwTerminate);

        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

        window = GLFW.glfwCreateWindow(400, 300, "Example NanoVG", 0L, 0L);
        Preconditions.checkState(window != 0, "Bad window");
        scope.addCloseAction(()-> GLFW.glfwDestroyWindow(window));

        GLFW.glfwSetCursorPosCallback(window, new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                mousePos.x = xpos;
                mousePos.y = ypos;
            }
        });

        GLFW.glfwSetMouseButtonCallback(window, (window1, button, action, mods) -> {
            var event = new MouseActionEvent(button, mods, mousePos.x, mousePos.y);
            if (action == GLFW.GLFW_PRESS) {
                element.mouseDown(event);
            } else {
                element.mouseUp(event);
            }
        });

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();

        ctx = NanoVGGL3.nvgCreate(NanoVGGL3.NVG_STENCIL_STROKES);

        int font = NanoVG.nvgCreateFont(ctx, "Arial", "C:/Windows/Fonts/Arial.ttf");
        if (font == -1) {
            throw new Exception("Could not add font");
        }
        NanoVG.nvgFontSize(ctx, 16);
    }

    protected void render() {
        NanoVG.nvgBeginFrame(ctx, 400, 300, 1);

        if(element instanceof Experimental experimental)
            experimental.render(ctx);

        NanoVG.nvgEndFrame(ctx);

        GLFW.glfwSwapBuffers(window);
    }

    @Override
    public void run() {
        try(var scope = ResourceScope.newConfinedScope()) {
            init(scope);
            while (!GLFW.glfwWindowShouldClose(window)) {
                GLFW.glfwPollEvents();
                render();
                GLFW.glfwPollEvents();
                Thread.sleep(60);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
