package io.github.mmc1234.fancyui.core.event;

public class MouseActionEvent implements Cancelable {
    public static class Down extends MouseActionEvent {
        public Down(int button, int mods, double x, double y) {
            super(button, mods, x, y);
        }
    }
    public static class Up extends MouseActionEvent {
        public Up(int button, int mods, double x, double y) {
            super(button, mods, x, y);
        }
    }

    public static class Click extends MouseActionEvent {
        public Click(int mods, double x, double y) {
            super(0, mods, x, y);
        }
    }

    private boolean cancel;
    private final int button;
    private final int mods;
    private final double x;
    private final double y;

    public MouseActionEvent(int button, int mods, double x, double y) {
        this.button = button;
        this.mods = mods;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isCancel() {
        return cancel;
    }

    @Override
    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getButton() {
        return button;
    }

    public int getMods() {
        return mods;
    }
}
