package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.component.ui.IUIElementBuilder;

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
