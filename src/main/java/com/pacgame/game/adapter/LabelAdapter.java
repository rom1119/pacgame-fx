package com.pacgame.game.adapter;

import com.pacgame.game.IColor;
import com.pacgame.game.ILabel;
import com.pacgame.uiElement.text.Text;

public class LabelAdapter extends ViewAdapter implements ILabel {

    private Text label;

    public LabelAdapter(Text label) {
        this.label = label;
    }

    @Override
    public void hide() {
        label.hide();
    }

    @Override
    public void show() {
        label.show();
    }

    @Override
    public void setBackground(IColor color) {
        label.setBackground(((ColorAdapter)color).getValue());
    }

    @Override
    public Text getProvidedObject() {
        return label;
    }
}
