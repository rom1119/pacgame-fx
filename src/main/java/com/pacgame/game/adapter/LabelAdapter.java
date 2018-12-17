package com.pacgame.game.adapter;

import com.pacgame.View;
import com.pacgame.game.IColor;
import com.pacgame.game.Ilabel;
import com.pacgame.uiElement.text.Label;
import com.pacgame.uiElement.text.Text;

public class LabelAdapter extends ViewAdapter implements Ilabel {

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
    public View getProvidedObject() {
        return label;
    }
}
