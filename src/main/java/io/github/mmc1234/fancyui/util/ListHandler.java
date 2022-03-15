package io.github.mmc1234.fancyui.util;

public interface ListHandler<T> {
    boolean cancelAdd(T element);
    void handleAdd(T element);
    void handleRemove(T element);
}
