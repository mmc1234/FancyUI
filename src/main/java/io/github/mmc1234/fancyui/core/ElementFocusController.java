package io.github.mmc1234.fancyui.core;

public class ElementFocusController implements Focusable.FocusController {
    private Element element;
    @Override
    public Element getFocused() {
        return element;
    }

    @Override
    public void setFocused(Focusable focusable) {
        if(focusable == element) return;

        if(focusable == null) {
            blur();
        } else if(focusable.canGrabFocus()) {
            focus(focusable);
        }
    }

    private void blur() {
        element = null;
    }

    private void focus(Focusable focusable) {
        element = (Element) focusable;
    }

    @Override
    public Focusable.FocusCycle getFocusCycle() {
        return null;
    }
}
