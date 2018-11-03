package com.pacgame.provider.builder.component;

import com.pacgame.provider.builder.IComponentBuilder;
import com.pacgame.provider.ui.button.ButtonProvidedObject;

public interface IButtonBuilder<T extends ButtonProvidedObject> extends IComponentBuilder<T> {

    IButtonBuilder<T> text(String text);
}
