package io.github.mmc1234.fancyui.core;

import io.github.mmc1234.fancyui.core.event.MouseActionEvent;

import java.util.Objects;

public class Clickable {
    private boolean down;
    private Element target;

    public Clickable(Element target) {
        this.target = Objects.requireNonNull(target);
    }

    public void processMouseUp(MouseActionEvent event) {
        if(!down || event.getButton() != 0) return;
        down = false;
        if(target.isMouseOver(event.getX(), event. getY())) {
            event.setCancel(true);
            target.mouseClick(new MouseActionEvent(0, event.getMods(), event.getX(), event.getY()));
        } else {
            // cancel
        }
    }

    public boolean isDown() {
        return down;
    }

    public void processMouseDown(MouseActionEvent event) {
        if(event.isCancel() || event.getButton() != 0) return;

        if(target.isMouseOver(event.getX(), event. getY())) {
            down = true;
            event.setCancel(true);
        }
    }
}
