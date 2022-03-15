package io.github.mmc1234.fancyui.example;

import io.github.mmc1234.fancyui.core.CheckBox;
import io.github.mmc1234.fancyui.yoga.YogaDirection;
import io.github.mmc1234.fancyui.yoga.YogaDisplay;
import io.github.mmc1234.fancyui.yoga.YogaFlexDirection;

public class ExampleCheckBox {

    public static void main(String[] args) throws Exception {
        var app = new ExampleApp();

        app.element = new CheckBox();
        var ygNode = app.element.getYogaNode();
        ygNode.setDisplay(YogaDisplay.FLEX);
        ygNode.setFlexDirection(YogaFlexDirection.Row);
        ygNode.setWidth("100");
        ygNode.setHeight("10%");
        ygNode.calculateLayout(400, 300, YogaDirection.LTR);

        app.run();
    }
}
