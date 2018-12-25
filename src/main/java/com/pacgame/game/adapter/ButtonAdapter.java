package com.pacgame.game.adapter;

import com.pacgame.View;
import com.pacgame.event.EventFacade;
import com.pacgame.game.IButton;
import com.pacgame.game.IColor;
import com.pacgame.game.event.ui.ButtonAction;
import com.pacgame.game.event.ui.UIEventHandler;
import com.pacgame.uiElement.btn.Button;

public class ButtonAdapter extends ViewAdapter implements IButton {

    private Button button;
    private EventFacade eventFacade;
    private UIEventHandler

    public ButtonAdapter(Button button, EventFacade eventFacade) {
        this.button = button;
        this.eventFacade = eventFacade;
    }

    @Override
    public void hide() {
        button.hide();
    }

    @Override
    public void show() {
        button.show();
    }

    @Override
    public void setBackground(IColor color) {
        button.setBackground(((ColorAdapter)color).getValue());
    }

    @Override
    public View getProvidedObject() {
        return button;
    }

    @Override
    public void setOnAction(UIEventHandler<ButtonAction> handler) {
        getProvidedObject().addEventHandler(eventFacade., );
    }
}
