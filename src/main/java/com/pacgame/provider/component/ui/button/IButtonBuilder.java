package com.pacgame.provider.component.ui.button;

import com.pacgame.provider.component.IComponentBuilder;

public interface IButtonBuilder<T extends ButtonProvidedObject> extends IComponentBuilder<T> {

    IButtonBuilder<T> text(String text);
}
