package io.github.mmc1234.fancyui.core;

import io.github.mmc1234.fancyui.core.event.MouseActionEvent;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NanoVG;

public class CheckBox extends Element implements Experimental {
    private Clickable clickable;
    private boolean checked;

    public CheckBox() {
        this.clickable = new Clickable(this);
    }

    @Override
    public boolean isMouseOver(double x, double y) {
        return getRect().containsPoint(x, y);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public void mouseUp(MouseActionEvent event) {
        clickable.processMouseUp(event);
    }

    @Override
    public void mouseDown(MouseActionEvent event) {
        clickable.processMouseDown(event);
    }

    @Override
    public void mouseClick(MouseActionEvent event) {
        setChecked(!isChecked());
    }

    @Override
    public void render(long ctx) {
        var color = NVGColor.create();
        NanoVG.nvgBeginPath(ctx);
        var rect = getRect();
        NanoVG.nvgRect(ctx, rect.x0(), rect.y0(), rect.x1()-rect.x0(), rect.y1()-rect.y0());
        NanoVG.nvgFillColor(ctx, color.r(isChecked() ? 0 : 0.3f).g(0.5f).b(0.5f).a(1));
        NanoVG.nvgFill(ctx);
        color.close();
    }
}
