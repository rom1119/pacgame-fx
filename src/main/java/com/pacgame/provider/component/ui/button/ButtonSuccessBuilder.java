package com.pacgame.provider.component.ui.button;

public class ButtonSuccessBuilder implements IButtonBuilder<ButtonSuccess> {

    protected ButtonSuccess buildedInstance;
    private String text;


    @Override
    public ButtonSuccess build() {
        buildedInstance = new ButtonSuccess(text);
        buildedInstance.setText(text);

        return buildedInstance;
    }

    @Override
    public ButtonSuccessBuilder text(String text) {
        this.text = text;

        return this;
    }
}
