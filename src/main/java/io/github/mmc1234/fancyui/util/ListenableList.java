package io.github.mmc1234.fancyui.util;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ListenableList<T> extends AbstractList<T> {
    private final List<T> list = new ArrayList<>();
    private final ListHandler handler;

    public ListenableList(ListHandler handler) {
        this.handler = handler;
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void add(int index, T element) {
        if(handler != null) {
            if(!handler.cancelAdd(element)) {
                list.add(index, element);
                handler.handleAdd(element);
            }
        }
    }

    @Override
    public T remove(int index) {
        var child =  list.remove(index);
        if(child != null) {
            handler.handleRemove(child);
        }
        return child;
    }

    @Override
    public int size() {
        return list.size();
    }
}
