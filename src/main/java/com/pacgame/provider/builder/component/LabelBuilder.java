package com.pacgame.provider.builder.component;

import com.pacgame.provider.builder.IUIElementBuilder;
import com.pacgame.provider.ui.text.Label;

public class LabelBuilder implements IUIElementBuilder<Label> {

    protected Label buildedInstance;
    private String textElement;

    public LabelBuilder text(String textElement)
    {
        this.textElement = textElement;

        return this;
    }

    @Override
    public Label build() {
        buildedInstance = new Label(this.textElement);
        return buildedInstance;
    }

    @Override
    public Label buildedObject() {
        return buildedInstance;
    }
}
