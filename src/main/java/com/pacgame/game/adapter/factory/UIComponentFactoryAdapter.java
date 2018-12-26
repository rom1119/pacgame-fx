package com.pacgame.game.adapter.factory;

import com.pacgame.event.EventFacade;
import com.pacgame.event.EventFacadeImpl;
import com.pacgame.game.*;
import com.pacgame.game.adapter.ButtonAdapter;
import com.pacgame.game.adapter.InputTextAdapter;
import com.pacgame.game.adapter.LabelAdapter;
import com.pacgame.uiElement.UIFactory;

public class UIComponentFactoryAdapter implements IUIComponentFactory {

    private UIFactory uiFactory;
    private EventFacade eventFacade;

    public UIComponentFactoryAdapter(UIFactory uiFactory, EventFacade eventFacade) {
        this.uiFactory = uiFactory;
        this.eventFacade = eventFacade;
    }

    @Override
    public IButton createButton(String text) {
        return new ButtonAdapter(uiFactory.createButtonSuccess(text), eventFacade);
    }

    @Override
    public IInputText createInputText(int width, int height) {
        InputTextAdapter inputTextAdapter = new InputTextAdapter(uiFactory.createTextArea());
        inputTextAdapter.setWidth(width);
        inputTextAdapter.setHeight(height);
        return inputTextAdapter;
    }

    @Override
    public ILabel createLabelText(String text) {
        return new LabelAdapter(uiFactory.createTextElement(text));
    }
}
