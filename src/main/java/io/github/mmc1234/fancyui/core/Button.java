package io.github.mmc1234.fancyui.core;

import io.github.mmc1234.fancyui.core.event.MouseActionEvent;
import io.github.mmc1234.fancyui.core.internal.NanoVGInternal;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NanoVG;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Button extends Element implements Experimental {
    private Clickable clickable;
    private String text;

    public final List<Consumer<MouseActionEvent>> click = new ArrayList<>();

    public Button() {
        this.clickable = new Clickable(this);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean isMouseOver(double x, double y) {
        return getRect().containsPoint(x, y);
    }

    @Override
    public void mouseDown(MouseActionEvent event) {
        clickable.processMouseDown(event);
    }

    @Override
    public void mouseUp(MouseActionEvent event) {
        clickable.processMouseUp(event);
    }

    @Override
    public void mouseClick(MouseActionEvent event) {
        click.forEach(c->c.accept(event));
    }

    @Override
    public void render(long ctx) {
        var color = NVGColor.create();
        NanoVG.nvgBeginPath(ctx);
        var rect = getRect();
        NanoVG.nvgRect(ctx, rect.x0(), rect.y0(), rect.x1()-rect.x0(), rect.y1()-rect.y0());
        NanoVG.nvgFillColor(ctx, clickable.isDown() ?
                NanoVGInternal.rgb(color, 0.5f, 0.5f, 0.5f) :
                NanoVGInternal.rgb(color, 0.7f, 0.7f, 0.7f));
        NanoVG.nvgFill(ctx);
        if(text != null && !text.isBlank()) {

            NanoVG.nvgBeginPath(ctx);
            NanoVG.nvgFillColor(ctx, clickable.isDown() ?
                    NanoVGInternal.rgb(color, 0.8f, 0.4f, 0.8f) :
                    NanoVGInternal.rgb(color, 1.0f, 0.4f, 0.9f));
            NanoVG.nvgText(ctx, rect.x0(),rect.y0()+16, text);
        }
        color.close();
    }
}
