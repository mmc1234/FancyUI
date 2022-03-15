package io.github.mmc1234.fancyui.core;

public sealed interface Focusable permits Element {
    public interface FocusController {
        Focusable getFocused();
        void setFocused(Focusable focusable);
        default boolean isFocus(Focusable focusable) {
            return getFocused() == focusable;
        }
        FocusCycle getFocusCycle();
    }

    public enum FocusDirection {
        LEFT, RIGHT, UP, DOWN,
        NEXT, PREVIOUS;
    }

    public interface FocusCycle {
        Focusable getNextFocusable(Focusable current, FocusDirection direction);
    }

    default void focus() {
        if(getFocusController() != null && canGrabFocus())
            getFocusController().setFocused(this);
    }

    default boolean isFocus() {
        return isFocus(getFocusController());
    }

    boolean isFocusable();

    default boolean canGrabFocus() {
        return isFocusable();
    }

    default boolean isFocus(FocusController fc) {
        return fc != null && fc.isFocus(this);
    }

    default void blur() {
        var fc = getFocusController();
        if(isFocus(fc)) fc.setFocused(null);
    }

    void setFocusable(boolean v);

    FocusController getFocusController();

}
