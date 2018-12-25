package com.pacgame.game.adapter.factory;

import com.pacgame.game.IColor;
import com.pacgame.game.IUIComponent;
import com.pacgame.game.IUIComponentFactory;
import com.pacgame.game.adapter.ButtonAdapter;
import com.pacgame.game.adapter.InputTextAdapter;
import com.pacgame.game.adapter.LabelAdapter;
import com.pacgame.uiElement.UIFactory;

public class UIComponentFactoryAdapter implements IUIComponentFactory {

    private UIFactory uiFactory;

    public UIComponentFactoryAdapter(UIFactory uiFactory) {
        this.uiFactory = uiFactory;
    }

    @Override
    public IUIComponent createButton(String text) {
        return new ButtonAdapter(uiFactory.createButtonSuccess(text));
    }

    @Override
    public IUIComponent createInputText(int width, int height) {
        InputTextAdapter inputTextAdapter = new InputTextAdapter(uiFactory.createTextArea());
        inputTextAdapter.setWidth(width);
        inputTextAdapter.setHeight(height);
        return inputTextAdapter;
    }

    @Override
    public IUIComponent createLabelText(String text) {
        return new LabelAdapter(uiFactory.createTextElement(text));
    }
}
