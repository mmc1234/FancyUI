package io.github.mmc1234.fancyui.example;

import io.github.mmc1234.fancyui.core.Button;
import io.github.mmc1234.fancyui.yoga.YogaDirection;
import io.github.mmc1234.fancyui.yoga.YogaDisplay;
import io.github.mmc1234.fancyui.yoga.YogaFlexDirection;

public class ExampleButton {

    public static void main(String[] args) throws Exception {
        var app = new ExampleApp();

        var btn = new Button();
        btn.setText("Hello Button!");
        btn.click.add((e)->System.out.println("Click"));
        app.element = btn;

        var ygNode = app.element.getYogaNode();
        ygNode.setDisplay(YogaDisplay.FLEX);
        ygNode.setFlexDirection(YogaFlexDirection.Row);
        ygNode.setWidth("25%");
        ygNode.setHeight("8%");
        ygNode.calculateLayout(400, 300, YogaDirection.LTR);

        app.run();
    }
}
