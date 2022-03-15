package io.github.mmc1234.fancyui.core;

import io.github.mmc1234.fancyui.core.event.MouseActionEvent;
import io.github.mmc1234.fancyui.util.*;
import io.github.mmc1234.fancyui.yoga.YogaNode;

import java.util.List;

public non-sealed class Element implements Focusable {
    public static final int FOCUSABLE_FLAG = 0;
    private int flags;
    private Element parent;
    private final List<Element> children;
    private final FocusController focusController;
    private final YogaNode yogaNode;

    public void mouseDown(MouseActionEvent event) {}
    public void mouseUp(MouseActionEvent event) {}
    public void mouseClick(MouseActionEvent event) {}

    public Element() {
        this.yogaNode = new YogaNode();
        focusController = new ElementFocusController();
        children = new ListenableList<>(null);
    }

    public boolean isMouseOver(double x, double y) {
        return false;
    }
    // TODO Deprecated
    public YogaNode getYogaNode() {
        return yogaNode;
    }

    public ImmutableRect getRect() {
        var x = yogaNode.getLayoutX();
        var y = yogaNode.getLayoutX();
        return new ImmutableRect(x, y, x+yogaNode.getLayoutWidth(), y+yogaNode.getLayoutHeight());
    }

    @Override
    public boolean isFocusable() {
        return BitAccess.getAtIndex(flags, FOCUSABLE_FLAG);
    }

    @Override
    public void setFocusable(boolean v) {
        flags = BitAccess.setAndGetAtIndex(flags, FOCUSABLE_FLAG, v);
    }

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public int size() {
        if(children == null) return 0;
        return children.size();
    }

    @Override
    public FocusController getFocusController() {
        throw new UnsupportedOperationException();
    }

    // TODO
    public Object getStyleAccess() {
        throw new UnsupportedOperationException();
    }
}
